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
