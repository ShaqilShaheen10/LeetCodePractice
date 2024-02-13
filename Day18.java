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
4.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
