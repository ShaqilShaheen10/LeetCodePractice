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

Class Solution{
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
5.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
