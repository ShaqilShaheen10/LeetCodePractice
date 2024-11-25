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
6. Redistribute Characters to Make All Strings Equal

class Solution {
    public boolean makeEqual(String[] words) {
      if(words.length==0){
          return true;
      }
      int total=0;
      for(String s:words){
          total+=s.length();
      }
      if(total%words.length!=0){
          return false;
      }
      int[] myMap=new int[26];
      for(String s:words){
          for(char c:s.toCharArray()){
              myMap[c-'a']++;
          }
      }
      for(int i:myMap){
          if(i%words.length!=0){
              return false;
          }
      }
      return true;
    }
}    
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Largest Substring Between Two Equal Characters

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int a=-1;
        for(int l=0;l<s.length();l++){
            for(int r=l+1;r<s.length();r++){
                if(s.charAt(l)==s.charAt(r)){
                    a=Math.max(a,r-l-1);
                }
            }
        }
        return a;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. Assign Cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int n=g.length,m=s.length;
        while(i<n && j<m){
            if(g[i]<=s[j]){
                count++;
                i++;j++;
            }
            else j++;
        }
        return count;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. Convert an Array into 2D Array With Conditions

import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] f=new int[nums.length+1];
        List<List<Integer>> a=new ArrayList<>();
        for(int c:nums){
            if(f[c]>=a.size()){
                a.add(new ArrayList<>());
            }
            a.get(f[c]).add(c);
            f[c]++;
        }
        return a;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. Balanced Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Height(root)==-1) return false;
        return true;}
    public int Height(TreeNode root){
        if(root==null) return 0;
        int l=Height(root.left);
        int r=Height(root.right);
        if(l==-1 || r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return Math.max(l,r)+1;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
