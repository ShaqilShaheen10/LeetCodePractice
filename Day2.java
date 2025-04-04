Add Binary

class Solution {
    public String addBinary(String a, String b) {
   StringBuilder s=new StringBuilder(); 
   int carry=0;
   int i=a.length()-1;  
   int j=b.length()-1;
   while(i>=0||j>=0||carry==1){   
       if(i>=0) 
        carry+=a.charAt(i--)-'0'; 
       if(j>=0) 
        carry+=b.charAt(j--)-'0';  
     s.append(carry%2);
     carry/=2; 
     }
   return s.reverse().toString();
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.Sqrt(x)

class Solution {
    public int mySqrt(int x) { 
        long l=0,r=(x/2)+1;
        while(l<r){
            long m=l+(r-l)/2+1;
            long sq=m*m;
            if(sq==x){
                return (int)m;
            }
            else if(sq<x){
                l=m; 
            }
            else{
                r=m-1;  
            }
        } 
        return (int)l;
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3.Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {
       int l=0;
       int r=s.length()-1;
       while(l<r){
           Character start=s.charAt(l);
           Character end=s.charAt(r);
        if(!Character.isLetterOrDigit(start)){
            l++;
            continue;}
        if(!Character.isLetterOrDigit(end)){
            r--; 
            continue;}
        if(Character.toLowerCase(start)!=Character.toLowerCase(end)){
            return false;
        }
        l++;
        r--;
       }
    return true;
    }
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  4.Valid Parentheses

  class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack=new Stack<>();
     for(char c:s.toCharArray()){
         if(c=='(')
             stack.push(')');
         else if(c=='{')
             stack.push('}');
         else if(c=='[')
             stack.push(']');
         else if(stack.isEmpty() || stack.pop()!=c)
          return false; 
     }
     return stack.isEmpty();
     }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.Plus One

class Solution {
    public int[] plusOne(int[] digits) { 
      int n=digits.length;
      for(int i=n-1;i>=0;i--){
          if(digits[i]<9){
              digits[i]++;
              return digits;
          }
          digits[i]=0;
      }
      int[] new_n=new int[n+1];
      new_n[0]=1;
      return new_n;
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
