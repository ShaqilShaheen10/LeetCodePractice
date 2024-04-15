1. Binary Tree PostOrder Traversal

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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans=new ArrayList<>();
    helper(root,ans);
    return ans;
    }
    private void helper(TreeNode node,List<Integer> ans){
        if(node==null) return;
        helper(node.left,ans);
        helper(node.right,ans);
        ans.add(node.val);
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Binary Tree PreOrder Traversal

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
 class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans=new ArrayList<>();
      helper(root,ans);
      return ans;
      }
      private void helper(TreeNode node,List<Integer> ans){
          if(node==null) return;
          ans.add(node.val);
          helper(node.left,ans);
          helper(node.right,ans);
      }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Remove Element

class Solution{
    public int removeElement(int[] nums, int val){
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Remove Duplicates From Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
    int j=1;
    for(int i=1;i<nums.length;i++){
        if(nums[i]!=nums[i-1]){
            nums[j]=nums[i];
            j++;
            }
        }
        return j;   
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Remove Duplicates From Sorted List

  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while(current!=null && current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return head;
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
