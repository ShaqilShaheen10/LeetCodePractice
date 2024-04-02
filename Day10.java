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
3. Determine if Two Strings Are Close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(char ch:word1.toCharArray()){
            f1[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            f2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(f1[i]==0 && f2[i]!=0 || f1[i]!=0 && f2[i]==0){
                return false;
            }
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]){
                return false;
            }
        }
        return true;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Linked List Cycle

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode s=head,f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
                return true;
            }
        }
        return false;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Majority Element

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
