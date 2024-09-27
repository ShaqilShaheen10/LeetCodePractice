1.Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int m=0; 
        while(l<r){
            int c=Math.min(height[l],height[r])*(r-l);
            m=Math.max(c,m);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            } 
        } 
        return m;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.Single Number

class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3.Reverse Bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r=0; 
        for(int i=0;i<32;i++){
            r<<=1; 
            r|=(n&1); 
            n>>=1;
        }
        return r;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.Number of 1 Bits

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int r=0;
       for(int i=0;i<32;i++){
           if(((n>>i)&1)==1){
               r++; 
           }
       }
       return r;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
     int count=0;
     for(int i=s.length()-1;i>=0;i--){ 
         if(s.charAt(i)!=' '){
             count++;
         }
         else{
             if(count>0)
             return count;
         }
     }
     return count;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
