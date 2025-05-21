1. Intersection of Two Linked Lists

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x; 
          next = null; 
      }
  }
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode a=headA;
        ListNode b=headB; 
        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a; 
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Power of Two 
 
class Solution { 
    public boolean isPowerOfTwo(int n) { 
    return n>0 && (n&n-1)==0;
    } 
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Add Digits
 
class Solution { 
    public int addDigits(int num) {
        if(num==0)return 0; 
        else if(num%9==0)return 9;
        else return num%9;
    } 
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.  Invert Binary Tree

  public class TreeNode { 
      int val;
      TreeNode left; 
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  } 
 
class Solution{
    public TreeNode invertTree(TreeNode root){
        if(root==null)return null;
        TreeNode temp=root.left;
        root.left=root.right; 
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right); 
        return root;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. House Robber 

class Solution {
    public int rob(int[] nums) { 
       int rob=0; 
       int norob=0;
       for(int i=0;i<nums.length;i++){
           int newRob=norob+nums[i];
           int newNoRob=Math.max(norob,rob);
           rob=newRob;
           norob=newNoRob;
       }
       return Math.max(rob,norob);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
