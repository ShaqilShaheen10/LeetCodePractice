1. Gives Number Higher or Lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */ 
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n==1)return 1;
        if(guess(n)==0)return n;
        int f=1,l=n;
        int m;
        while(f<l){
            m=f+(l-f)/2;
            int t=guess(m);
            if(t==0) return m;
            else if(t==-1) l=m;
            else f=m;
        }
        return 0;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Sequential Digits
 
    class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String c="123456789";
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<c.length();i++){
            for(int j=i+1;j<=c.length();j++){
                int curr=Integer.parseInt(c.substring(i,j));
                if(curr<=high && curr>=low){
                    a.add(curr);
                }
            }
        }
        a.sort(null);
        return a;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Nim Game

class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Valid Perfect Square

class Solution {
public boolean isPerfectSquare(int num) {
        double sqr=Math.sqrt(num);
        int val=(int)sqr;
        if((val*val)==num){
            return true;
        }
        return false;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Intersection of Two Arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      int[] temp=new int[1001];
      for(int i:nums1){
          temp[i]=1;
      }
      int count=0;
      for(int i:nums2){
          if(temp[i]==1){
              count++;
              temp[i]=2;
          }
      }
      int[] arr=new int[count];
      int j=0;
      for(int i:nums2){
          if(temp[i]==2){
              temp[i]=1;
              arr[j]=i;
              j++;
          }
      }
      return arr;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
