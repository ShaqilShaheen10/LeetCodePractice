1. Find All the Numbers Disappeared in an Array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int m=nums.length;
        int[] map=new int[m+1];
        List<Integer> ans=new ArrayList<>();
        for(int e:nums){
            map[e]++; 
        }
        for(int i=1;i<m+1;i++){
            if(map[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Reverse String 

Class Solution { 
 public void reverseString(char[] s){ 
        for(int i=0,j=s.length-1;i<s.length/2;i++,j--){ 
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            }
         } 
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Base 7
 
class Solution {
    public String convertToBase7(int num) { 
        int base=1;
        int ans=0;
        while(num!=0){
            int rem=num%7;
            ans+=base*rem;
            base*=10;
            num/=7;
        }
        return Integer.toString(ans);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.  Fibonacci Number

    class Solution { 
    public int fib(int n) {
      var d=new int[n+2];
      d[n+1]=1;
      for(int i=n-1;i>=0;i--){
          d[i]=d[i+1]+d[i+2];
      }
      return d[0];
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Number Complement

class Solution {
    public int findComplement(int num) {
        int temp=num;
        String s="";
        while(temp!=0){
            if((temp&1)==1) s+="0";
            else s+="1";
            temp>>=1;
        }
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        int ans=Integer.parseInt(new String(sb),2);
        return ans;
    } 
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Hamming Distance

class Solution {
    public int hammingDistance(int x, int y) {
        int count=0;
        int a=x^y;
        String b=Integer.toBinaryString(a);
        for(int i=0;i<b.length();i++){ 
            if(b.charAt(i)=='1') count++;
        }
        return count;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Bitwise AND of Numbers Range

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int c=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            c++;
        }
        return (left<<c);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. Find the Town Judge

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustcount = new int[n + 1];
        for (int[] relation : trust) {
            trustcount[relation[0]]--;
            trustcount[relation[1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (trustcount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. Longest Palindrome

    class Solution {
    public int longestPalindrome(String s) {
        int[] c=new int[128];
        for(char ch:s.toCharArray()){
            c[ch]++;
        }
        int r=0;
        for(int co:c){
            r+=co/2*2;
            if(r%2==0 && co%2==1)
            r+=1;
        }
        return r;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. Third Maximum Number

class Solution {
    public int thirdMax(int[] nums) {
       Arrays.sort(nums);
       int n=nums[nums.length-1];
       int t=1;
       int i=nums.length-1;
       while(t<3 && i>0){
           if(nums[i]!=nums[i-1]){
               t++;
               if(t==3)
               return nums[i-1];
           }
           i--;
       }
       return n;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
