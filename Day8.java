1. Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                if (!seen.add(board[r][c] + "in row" + r) ||
                    !seen.add(board[r][c] + "in col" + c) ||
                    !seen.add(board[r][c] + "in block" + r/3 + c/3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.  Minimum Time to Make Rope Colorful

class Solution {
    public int minCost(String colors, int[] neededTime) {

        char[] str=colors.toCharArray();
        int min=0;
        for(int i=0;i<str.length-1;i++){
            if(str[i]==str[i+1]){
                if(neededTime[i]<neededTime[i+1]){
                    min+=neededTime[i];
                    neededTime[i]=0;
                }
                else{
                    min+=neededTime[i+1];
                    neededTime[i+1]=neededTime[i];
                }
            }
        }
        return min;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3.  Zigzag Conversion

class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        StringBuffer[] arr=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++) arr[i]=new StringBuffer();
        int i=0;
        while(i<n){
            for(int ind=0;ind<numRows && i<n; ind++){
                arr[ind].append(s.charAt(i++));
            }
            for(int ind=numRows-2;ind>0 && i<n;ind--){
                arr[ind].append(s.charAt(i++));
            }
        }
        StringBuffer ans=new StringBuffer();
        for(StringBuffer e:arr){
            ans.append(e);
        }
        return ans.toString();
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            char[] c=word.toCharArray();
            Arrays.sort(c);
            String w=new String(c);
            if(!map.containsKey(w)){
                map.put(w,new ArrayList<>());
            }
            map.get(w).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.  Swap Nodes in Pairs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode t=new ListNode(0);
        t.next=head;
        ListNode cur=t;
        while(cur.next!=null && cur.next.next!=null){
            ListNode first=cur.next;
            ListNode second=cur.next.next;
            first.next=second.next;
            cur.next=second;
            cur.next.next=first;
            cur=cur.next.next;
        }
        return t.next;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
