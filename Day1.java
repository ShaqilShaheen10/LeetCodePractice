1.Two Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){ 
            for(int j=i+1;j<nums.length;j++){ 
                if(nums[i]+nums[j]==target){
                    int a[]={i,j};
                    return a;
                }
            }
        }
        return null;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
    int a=x;
    int v=0;  
    while(x>0){
        int r=x%10;
        v=(v*10)+r;
        x=x/10; 
    }
    if(v==a) 
        return true;
    else
        return false;
    }
    }
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
3.Roman to Integer

class Solution {
    public int romanToInt(String s) {
      Map<Character,Integer> map=new HashMap<>();
      map.put('I',1);
      map.put('V',5); 
      map.put('X',10);
      map.put('L',50);
      map.put('C',100);
      map.put('D',500);
      map.put('M',1000);
    int result=map.get(s.charAt(s.length()-1));
    for(int i=s.length()-2;i>=0;i--){
        if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
            result-=map.get(s.charAt(i));
        }
        else{
            result+=map.get(s.charAt(i));
        }
    }
    return result;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int MaxP=0;
        int minS=prices[0];
        for(int i=0;i<prices.length;i++){ 
            minS=Math.min(minS,prices[i]);
            int Profit=prices[i]-minS;
            MaxP=Math.max(MaxP,Profit);
        }
        return MaxP;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.Longest Common Prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
     StringBuilder result=new StringBuilder();
     Arrays.sort(strs);
     char[] first=strs[0].toCharArray();
     char[] last=strs[strs.length-1].toCharArray();
     for(int i=0;i<first.length;i++){
         if(first[i]!=last[i])
         break;
         result.append(first[i]);
     }
     return result.toString();
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
