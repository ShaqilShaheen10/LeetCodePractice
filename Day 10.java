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
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
