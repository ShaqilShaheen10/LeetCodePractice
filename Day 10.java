1. Determine if String Halves Are Alike

class Solution {
    public boolean halvesAreAlike(String s) {
        int mid=s.length()/2;
        String first=s.substring(0,mid);
        String second=s.substring(mid);
        int firstCount=countVowels(first);
        int secondCount=countVowels(second);
        return firstCount==secondCount;
    }
    private int countVowels(String str){
        int count=0;
        for(char ch:str.toCharArray()){
            if("AEIOUaeiou".indexOf(ch)!=-1){
                count++;
            }
        }
        return count;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.Minimum Number of Steps to Make Two String Anagrams

public class Solution {
    public int minSteps(String s, String t) {
        int[] countS=new int[26];
        int[] countT=new int[26];
        for(char ch:s.toCharArray()){
            countS[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            countT[ch-'a']++;
        }
        int steps=0;
        for(int i=0;i<26;i++){
            steps+=Math.abs(countS[i]-countT[i]);
        }
        return steps/2;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
