package com.garagewa.auth.rest;

import com.garagewa.auth.common.*;
import com.garagewa.auth.model.AdminUser;
import com.garagewa.auth.service.AdminUserService;
import com.garagewa.common.exception.AuthErrorCode;
import com.garagewa.common.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminUserController extends CurrentAccessUser {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/signIn")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>(getCurrentAccessUser(), HttpStatus.CREATED);
    }

//    @PostMapping("/signIn/sendOtp")
//    public ResponseEntity<Object> sendOtp(@RequestBody LoginDto loginDto){
//        if(loginDto.getUsername().isEmpty())
//            throw new AuthException("Key can't be empty", AuthErrorCode.VALIDATION_ERROR);
//
//        adminUserService.sendOtp(loginDto.getUsername());
//        return new ResponseEntity<>("Otp sent successfully", HttpStatus.CREATED);
//    }
@PostMapping("/signIn/sendOtp")
public ResponseEntity<Object> sendOtp(@RequestBody LoginDto loginDto) {
    String phoneNumber = loginDto.getUsername(); // Assuming username is the phone number

    if (phoneNumber.isEmpty()) {
        throw new AuthException("Phone number can't be empty", AuthErrorCode.VALIDATION_ERROR);
    }
    // Check phone number validation
    adminUserService.checkPhoneValidation(phoneNumber);
    // Generate OTP
    int otp = adminUserService.generateOTP(phoneNumber);
    // Send OTP
    adminUserService.sendOtp(phoneNumber, otp);
    return new ResponseEntity<>("OTP sent successfully", HttpStatus.CREATED);
}
//   @PostMapping("/signIn/verifyOtp")
//   public ResponseEntity<Object> verifyOtp(@RequestBody LoginDto loginDto){
//       if(loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
//           throw new AuthException("Key and value can't be empty", AuthErrorCode.VALIDATION_ERROR);
//
//       adminUserService.verifyOtp(loginDto);
//
//       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//               loginDto.getUsername(), loginDto.getPassword()));
//
//       SecurityContextHolder.getContext().setAuthentication(authentication);
//
//       return new ResponseEntity<>(getCurrentAccessUser(), HttpStatus.CREATED);
//   }

    @PostMapping("/signIn/verifyOtp")
    public ResponseEntity<Object> verifyOtp(@RequestBody LoginDto loginDto) {
        String key = loginDto.getUsername();
        String otpValue = loginDto.getPassword();
        try {
            // Verify OTP
            adminUserService.otpVerify(otpValue, key);
            // Check if the user is present
            boolean isUserPresent = adminUserService.isPresent(key, null);
            if (!isUserPresent) {
                // User not found, create the user
                AdminUser adminUser = new AdminUser(); // Replace with actual user creation logic
                adminUserService.addAdmin(adminUser); // Add the user
                return new ResponseEntity<>("New user created and redirected to onboarding process.", HttpStatus.CREATED);
            }
            // Create session object
            Map<String, Object> session = createSessionObject();
            // Prepare response body
            Map<String, Object> responseBody = prepareResponseBody("User authenticated successfully", session);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch (AuthException e) {
            // Handle invalid OTP exception
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    private Map<String, Object> createSessionObject() {
        Map<String, Object> session = new HashMap<>();
        session.put("onboarded", true); // Assuming user is onboarded
        // Add more session attributes as needed
        return session;
    }
    private Map<String, Object> prepareResponseBody(String message, Map<String, Object> session) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", message);
        responseBody.put("session", session);
        return responseBody;
    }

    @GetMapping("/authentication/checkSession")
    public ResponseEntity<Object> checkSession(){
        return new ResponseEntity<>(getCurrentAccessUser(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('ADMIN') or hasAuthority('SUPER_VENDOR') or hasAuthority('VENDOR')")
    @PostMapping("/adminUsers")
    public ResponseEntity<Object> addUserByAdmin(@RequestBody AdminUser adminUser){
        return new ResponseEntity<>(adminUserService.addUserByAdmin(adminUser), HttpStatus.CREATED);
    }

    @PostMapping("/signUp")
    public ResponseEntity<Object> register(@RequestBody AdminUser adminUser){
        return new ResponseEntity<>(adminUserService.register(adminUser), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('ADMIN') or hasAuthority('CUSTOMER') or hasAuthority('VENDOR') or hasAuthority('SUPER_VENDOR') or hasAuthority('MECHANIC')")
    @DeleteMapping("/authentication/delete")
    public ResponseEntity<?> deleteUser(@RequestParam String userId){
        adminUserService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/signIn/users")
    public boolean isPresent(@RequestParam String phone,
                             @RequestParam String email){
        return adminUserService.isPresent(phone,email);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('ADMIN') or hasAuthority('CUSTOMER') or hasAuthority('SUPER_VENDOR') or hasAuthority('VENDOR') or hasAuthority('MECHANIC')")
    @PostMapping("/changePassword")
    public boolean changePassword(@RequestBody PasswordDto passwordDto){
       return adminUserService.changePassword(passwordDto);
    }

    @PostMapping("/forgotPassword/otp")
    public ResponseEntity<Object> sendForgotPasswordOtp(@RequestBody ForgotPasswordDto forgotPasswordDto){
        adminUserService.sendForgotPasswordOtp(forgotPasswordDto.getUsername());
        return new ResponseEntity<>("Otp sent successfully",HttpStatus.CREATED);
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordDto forgotPasswordDto){
        adminUserService.forgotPassword(forgotPasswordDto);
        return new ResponseEntity<>("Password changed",HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('ADMIN') or hasAuthority('CUSTOMER') or hasAuthority('SUPER_VENDOR') or hasAuthority('VENDOR') or hasAuthority('MECHANIC')")
    @PutMapping("/authentication/{id}/updates")
    public ResponseEntity<Object> updateUser(@PathVariable String id,
                                             @RequestBody UserDto userDto){
        return new ResponseEntity<>(adminUserService.updateUser(id,userDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('ADMIN') or hasAuthority('SUPER_VENDOR') or hasAuthority('VENDOR')")
    @PutMapping("/authentication/{id}/approves")
    public ResponseEntity<Object> approveUser(@PathVariable String id,
                                              @RequestBody UserDto userDto){
        return new ResponseEntity<>(adminUserService.approveUser(id,userDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('ADMIN') or hasAuthority('SUPER_VENDOR') or hasAuthority('VENDOR')")
    @PutMapping("/authentication/{id}/suspends")
    public ResponseEntity<Object> suspendUser(@PathVariable String id,
                                              @RequestBody UserDto userDto){
        return new ResponseEntity<>(adminUserService.suspendUser(id,userDto), HttpStatus.OK);
    }
}
