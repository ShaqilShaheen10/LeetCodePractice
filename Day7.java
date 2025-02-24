1. Find the Index of the First Occurance in a String
  
  class Solution {
    public int strStr(String haystack, String needle) {
        int haylength=haystack.length();
        int needlelength=needle.length();
        if(haylength<needlelength)
        return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j=0;
            while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j))
            j++;
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Search Insert Position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){ 
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return start; 
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Happy Number

class Solution {
    public boolean isHappy(int n) { 
       Set<Integer> set=new HashSet<>();
       while(n!=1){ 
           int c=n;
           int s=0;
           while(c>0){ 
               s+=(c%10)*(c%10);
               c/=10;
           }
           if(!set.add(s)){
               return false;
           }
           n=s;
       }
       return true;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Reverse Integer

class Solution {
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            int l=x%10;
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && l>7)){
                return 0;
            }
            if(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && l<-8)){
                return 0;
            }
            res=res*10+l;
            x/=10;
        } 
        return res;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Integer to Roman

class Solution{
public static String intToRoman(int num) { 
    String M[]={"","M","MM","MMM"};
    String C[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String X[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String I[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
    return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[num%10];
}
}  
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
