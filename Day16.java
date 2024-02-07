1. is Subsequence

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        int i=0,j=0;
        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==m;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Find First and Last Element in a Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int f=-1,L=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                f=m;
                L=m;
                while(f>0 && nums[f-1]==target){
                    f--;
                }
                while(L<nums.length-1 && nums[L+1]==target){
                    L++;
                }
                break;
            }else if(nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return new int[]{f,L};
        }
    }

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Binary Watch

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> r=new ArrayList();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==turnedOn){
                    if(m<10) r.add(String.format("%d:0%d",h,m));
                    else r.add(String.format("%d:%d",h,m));
                }
            }
        }
        return r;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
