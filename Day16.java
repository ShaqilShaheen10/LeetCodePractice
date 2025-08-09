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
4. Perfect Squares

class Solution {
    public int numSquares(int n) { 
        int sqrt=(int) Math.sqrt(n);  
        if(sqrt*sqrt==n) return 1; 
        while(n%4==0) n=n/4;
        if(n%8==7) return 4;
        for(int i=1;i*i<=n;i++){
            int s=i*i;
            int b=(int) Math.sqrt(n-s);
            if(b*b==n-s)return 2;
        }
        return 3;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Word Pattern

class Solution {
    public boolean wordPattern(String pattern, String s) { 
       String[] word=s.split(" ");
       if(word.length!=pattern.length()) return false;
       HashMap<Character,String> map=new HashMap();
       for(int i=0;i<pattern.length();i++){
           char c=pattern.charAt(i);
           if(map.containsKey(c)){
               if(!map.get(c).equals(word[i])){
                   return false;
               }
           }
           else{
               if(map.containsValue(word[i])){
                   return false;
               }
               map.put(c,word[i]);
           }
       }
       return true;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
