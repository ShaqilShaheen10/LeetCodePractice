package com.garagewa.auth.service;

import com.garagewa.auth.apiclient.CustomerClient;
import com.garagewa.auth.apiclient.NotificationClient;
import com.garagewa.auth.apiclient.VendorClient;
import com.garagewa.auth.common.*;
import com.garagewa.auth.model.AdminUser;
import com.garagewa.auth.repo.AdminUserRepository;
import com.garagewa.common.common.UserRoleType;
import com.garagewa.common.exception.AuthErrorCode;
import com.garagewa.common.exception.AuthException;
import com.garagewa.common.exception.TTException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private NotificationClient notificationClient;
    @Autowired
    private VendorClient vendorClient;
    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Integer EXPIRE_MINS = 5;
    private LoadingCache otpCache;
    @Value("${fast2sms.authorization}")
    private String api_key;
    @Value("${fast2sms.sender_id}")
    private String sender_id;
    @Value("${fast2sms.route}")
    private String route;

    public AdminUserService() {
        super();
        otpCache = CacheBuilder.newBuilder().
                expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
                .build(new CacheLoader() {
                    @Override
                    public Object load(Object key) throws Exception {
                        return null;
                    }
                });
    }

    public void addAdmin(AdminUser admin) {
        AdminUser isAdmin = adminUserRepository.findByEmailEmailAndIsSuspendFalse(admin.getEmail().getEmail());

        if(isAdmin == null)
            adminUserRepository.save(admin);

        log.info("Successfully update all user in Admin repository");
    }

//    public void sendOtp(String key) {
//        AdminUser adminUser = adminUserRepository.findByEmailEmailOrPhonePhoneAndIsSuspendFalse(key,key);
//
//        if(adminUser == null)
//            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);
//
//        int otp = generateOTP(key);
//
//        adminUser.setOneTimePassword(passwordEncoder.encode(String.valueOf(otp)));
//        adminUserRepository.save(adminUser);
//
//        boolean isMail = key.contains("@");
//
//        if(isMail){
//            try {
//                notificationClient.sendAuthOtpEmail(key, String.valueOf(otp));
//            }catch(Exception exception){
//                throw new AuthException("Mail not sent", AuthErrorCode.MAIL_NOT_SENT);
//            }
//        }else{
//            try{
//                notificationClient.sendAuthOtpMsg(key,otp);
//            }catch(Exception exception){
//                throw new AuthException("Msg not sent", AuthErrorCode.MSG_NOT_SENT);
//            }
//        }
//    }
public void sendOtp(String key, int otp) {
        // Check if the provided key is an email or phone number
        boolean isMail = key.contains("@");
        // Format the phone number if it includes country code
        String numbers = key.replaceFirst("\\+91", "");
        // Define the SMS message and route
        String message = "OTP for Garagewa registration is: " + otp + ". Do not share it with anyone.";
        String route = "otp";
        // Prepare request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("variables_values", String.valueOf(otp));
        requestBody.put("route", route);
        requestBody.put("numbers", numbers);
            // Send the OTP via Fast2SMS API
            HttpResponse<JsonNode> response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
                    .header("authorization", api_key)
                    .header("Content-Type", "application/json")
                    .body(new JSONObject(requestBody))
                    .asJson();

            if (response.getStatus() != 200) {
                // Handle failure to send OTP
                throw new AuthException("Msg not sent", AuthErrorCode.MSG_NOT_SENT);
            } else {
                log.info("OTP is sent successfully ======> {}",otp);
            }
    }
    public void verifyOtp(LoginDto loginDto) {
        otpVerify(loginDto.getPassword(), loginDto.getUsername());
    }

    public int generateOTP(String key){
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

        if(getOtp(key) != null)
            clearOTP(key);

        otpCache.put(key, otp);
        return otp;
    }

    public void otpVerify(String otp, String key) {
        if(otp.equals(getOtp(key))) {
            clearOTP(key);
            return;
        }
        throw new AuthException("Wrong OTP", AuthErrorCode.WRONG_OTP);
    }

    public String getOtp(String key){
        try{
            return otpCache.get(key).toString();
        }catch (Exception e){
            return null;
        }
    }

    public void clearOTP(String key){
        otpCache.invalidate(key);
    }

    public void deleteUser(String userId) {
        AdminUser adminUser = adminUserRepository.findByUserId(userId);

        if(adminUser == null)
            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);

        adminUserRepository.deleteById(adminUser.getId());
    }

    public boolean isPresent(String phone, String email) {
        AdminUser adminUser = adminUserRepository.findByEmailEmailOrPhonePhone(email,phone);
        return adminUser != null;
    }

    @Transactional
    public boolean changePassword(PasswordDto password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = "";

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails)
            username = ((UserDetails) principal).getUsername();

        AdminUser adminUser = adminUserRepository.findByEmailEmailOrPhonePhoneAndIsSuspendFalse(username,username);

        adminUser.setPassword(passwordEncoder.encode(password.getNewPassword()));
        adminUserRepository.save(adminUser);
        return true;
    }

    public AdminUser addUserByAdmin(AdminUser adminUserDetails) {
        AdminUser adminUser = adminUserRepository.findByEmailEmailOrPhonePhone(adminUserDetails.getEmail().getEmail(),adminUserDetails.getPhone().getPhone());

        if(adminUser != null)
            adminUserRepository.deleteById(adminUser.getId());

        return adminUserRepository.save(adminUserDetails);
    }

    public AdminUser register(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    public AdminUser updateUser(String id, UserDto userDto) {
        AdminUser adminUser = adminUserRepository.findByUserId(id);

        if(adminUser == null)
            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);

        adminUser.setUsername(userDto.getUsername());
        adminUser.setPhone(new Phone(userDto.getPhone()));
        adminUser.setEmail(new Email(userDto.getEmail()));

        adminUser = adminUserRepository.save(adminUser);
        return adminUser;
    }

    public AdminUser approveUser(String id, UserDto userDto) {
        AdminUser adminUser = adminUserRepository.findByUserId(id);

        if(adminUser == null)
            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);

        adminUser.setIsVerified(userDto.getIsVerified());
        adminUserRepository.save(adminUser);
        return adminUser;
    }

    public AdminUser suspendUser(String id, UserDto userDto) {
        AdminUser adminUser = adminUserRepository.findByUserId(id);

        if(adminUser == null)
            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);

        adminUser.setIsSuspend(userDto.getIsSuspend());
        adminUserRepository.save(adminUser);
        return adminUser;
    }

    public void sendForgotPasswordOtp(String username) {
        AdminUser adminUser = adminUserRepository.findByEmailEmailOrPhonePhoneAndIsSuspendFalse(username,username);

        if(adminUser == null)
            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);

        int otp = generateOTP(username);

        boolean isMail = username.contains("@");

        if(isMail){
            try {
                notificationClient.sendAuthOtpEmail(username, String.valueOf(otp));
            }catch(Exception exception){
                throw new AuthException("Mail not sent", AuthErrorCode.MAIL_NOT_SENT);
            }
        }else{
            try{
                notificationClient.sendAuthOtpMsg(username,otp);
            }catch(Exception exception){
                throw new AuthException("Msg not sent", AuthErrorCode.MSG_NOT_SENT);
            }
        }
    }

    public void forgotPassword(ForgotPasswordDto forgotPasswordDto) {
        AdminUser adminUser = adminUserRepository.findByEmailEmailOrPhonePhoneAndIsSuspendFalse(forgotPasswordDto.getUsername(), forgotPasswordDto.getUsername());

        if(adminUser == null)
            throw new AuthException("User not found", AuthErrorCode.USER_NOT_FOUND);

        if(forgotPasswordDto.getPassword().length()<4)
            throw new AuthException("Please enter a valid password",AuthErrorCode.VALIDATION_ERROR);

        otpVerify(forgotPasswordDto.getOtp(), forgotPasswordDto.getUsername());

        adminUser.setPassword(passwordEncoder.encode(forgotPasswordDto.getPassword()));
        adminUserRepository.save(adminUser);

        String role = adminUser.getAuthority().getRole();

        if(role.equals(UserRoleType.CUSTOMER.toString())){
            customerClient.forgotPassword(adminUser.getUserId(), forgotPasswordDto);
        }else {
            if(role.equals(UserRoleType.VENDOR.toString()))
                vendorClient.vendorForgotPassword(adminUser.getUserId(), forgotPasswordDto);
            if(role.equals(UserRoleType.SUPER_VENDOR.toString()))
                vendorClient.superVendorForgotPassword(adminUser.getUserId(), forgotPasswordDto);
            if(role.equals(UserRoleType.MECHANIC.toString()))
                vendorClient.mechanicForgotPassword(adminUser.getUserId(), forgotPasswordDto);
        }
    }
    public void checkPhoneValidation(String phone) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = null;

        try {
            phoneNumber = phoneNumberUtil.parse(phone, "");
        } catch (NumberParseException e) {
            throw new RuntimeException(e);
        }

        if(!phoneNumberUtil.isValidNumber(phoneNumber))
            throw new TTException("Invalid phone number");
    }
}
