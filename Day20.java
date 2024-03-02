1. Longest Uncommon Subsequence

class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        if(a.length()>b.length()){
            return a.length();
        }else{
            return b.length();
        }
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Max Consecutive Ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int m=0,j=-1,i=0;
        for(;i<nums.length;i++){
            if(nums[i]==0){
                m=Math.max(m,i-j-1);
                j=i;
            }
        }
        return Math.max(m,i-j-1);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Detect Capital

class Solution {
    public boolean detectCapitalUse(String word) {
        int caps=0,low=0,first=0;
        for(char ch:word.toCharArray()){
            if(ch>=65 && ch<=90){
                caps++;
                if(first==0) first=1;
            }
            else{
                low++;
                if(first==0) first=2;
            }
        }
        if(caps==0 || low==0 || first==1 && caps==1) return true;
        else return false;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Island Perimeter

class Solution {
    public int islandPerimeter(int[][] g) {
        int c=0;
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                if(g[i][j]==1){
                    if(i-1<0 || g[i-1][j]==0) c++;
                    if(j-1<0 || g[i][j-1]==0) c++;
                    if(i+1>=g.length || g[i+1][j]==0) c++;
                    if(j+1>=g[0].length || g[i][j+1]==0) c++;
                }
            }
        }
        return c;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Teemo Attacking

class Solution {
    public int findPoisonedDuration(int[] t, int d) {
        int sum = d;
        int temp = t[0] + d - 1;
        for (int i = 1; i < t.length; i++){
            if (t[i] > temp) {
                sum += d;
            }
            else { 
                sum += t[i] + d - 1 - temp;
            }
            temp = t[i] + d - 1;
        }
        return sum;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Maximum Odd Binary Number

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int c1=0,c0=0;
        for(char a:s.toCharArray()){
            if(a=='1') c1++;
            else if(a=='0') c0++;
        }
        StringBuilder ans=new StringBuilder();
        ans.append("1".repeat(c1-1));
        ans.append("0".repeat(c0));
        ans.append("1");
        return ans.toString();
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Squares of a Sorted Array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int start=0,end=n-1;
        for(int i=n-1;i>=0;i--){
            if(Math.abs(nums[start])>=Math.abs(nums[end])){
                ans[i]=nums[start]*nums[start];
                start++;
            }
            else{
                ans[i]=nums[end]*nums[end];
                end--;
            }
        }
        return ans;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
