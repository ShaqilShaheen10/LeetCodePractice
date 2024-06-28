1.Find the First Palindromic String

class Solution {
    public String firstPalindrome(String[] words) {
      for(String word:words){
          StringBuilder reversed=new StringBuilder(word).reverse();
          if(word.equals(reversed.toString())) return word;
      }
      return "";
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Fizz Buzz

class Solution {
    public List<String> fizzBuzz(int n) {
      List<String> ans=new ArrayList<>();
      for(int i=1;i<=n;i++){
          if(i%3==0 && i%5==0){
              ans.add("FizzBuzz");
          }
          else if(i%3==0){
              ans.add("Fizz");
          }
          else if(i%5==0){
              ans.add("Buzz");
          }
          else{
              ans.add(""+i);
          }
      }
      return ans;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Perfect Number

class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum=0;
        if(num%2!=0){
            return false;
        }
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                sum+=i;
            }
        }
        return sum==num;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.  Rearrange Array Elements by Sign

class Solution {
    public int[] rearrangeArray(int[] a) {
        int n=a.length;
        int[] ans=new int[n];
        int pi=0,ni=1;
        for(int i=0;i<n;i++){
            if(a[i]>0){
                ans[pi]=a[i];
                pi+=2;
            }
            else{
                ans[ni]=a[i]; 
                ni+=2;
            }
        }
        return ans;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Find Polygon with the Largest Perimeter

class Solution {
    public long largestPerimeter(int[] nums) {
        long sum=0;
        Arrays.sort(nums);
        for(int num:nums){
            sum+=num;
        }
        int n=nums.length;
        for(int i=n-1;i>=2;i--){
            sum-=nums[i];
            if(sum>nums[i]){
                return sum+nums[i];
            }
        }
        return -1;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
