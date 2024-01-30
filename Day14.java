1. Ransom Note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] a=new int[26];
        for(char c:magazine.toCharArray()){
            a[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            if(a[c-'a']==0) return false;
            a[c-'a']--;
        }
        return true;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Counting Bits

class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        arr[0]=0;
        for(int i=1;i<=n;i++){
            int t=i,c=0;
            while(t!=0){
                t=t&(t-1);
                c++;
            }
            arr[i]=c;
        }
        return arr;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Ugly Number

class Solution {
    public boolean isUgly(int n) {
       if(n==0){
           return false;
       }
       for(int i=2;i<=6;i++){
           while(n%i==0){
               n=n/i;
           }
       }
       return n==1;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. First Unique Character in a String

class Solution {
    public int firstUniqChar(String s) {
        int a=Integer.MAX_VALUE;
        for(char c='a';c<='z';c++){
            int i=s.indexOf(c);
            if(i!=-1 && i==s.lastIndexOf(c)){
                a=Math.min(a,i);
            }
        }
        return a==Integer.MAX_VALUE?-1:a;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
