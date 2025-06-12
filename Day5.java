1. Maximum Depth of a Binary Tree

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
    public int maxDepth(TreeNode root){
       if(root==null) return 0;  
       int l=maxDepth(root.left);
       int r=maxDepth(root.right);
       return Math.max(l,r)+1;
    } 
} 
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Merge Two Sorted Lists
 
   public class ListNode {
      int val;
      ListNode next; 
      ListNode() {}
      ListNode(int val) { this.val = val; } 
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }  
    
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1!=null && list2!=null){
            if(list1.val<list2.val){  
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            } 
            else{  
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
        return list2;
        return list1;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Binary Tree Inorder Traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res=new ArrayList<>();
      helper(root,res);
      return res;
    }
    public void helper(TreeNode root,List<Integer> res){
        if(root!=null){
            helper(root.left,res);
            res.add(root.val);
            helper(root.right,res); 
        }
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Minimum Depth of a Binary Tree

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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int l=minDepth(root.left);
        int r=minDepth(root.right);
        if(root.left==null && root.right==null)
        return 1;
        if(root.left==null)
        return r+1;
        if(root.right==null)
        return l+1;
        return Math.min(l,r)+1;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Convert Sorted Array to Binary Search Tree

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
    public TreeNode sortedArrayToBST(int[] nums) {
    return BST(nums,0,nums.length-1);
    }
    private TreeNode BST(int nums[],int l, int r){
        if(l>r){
            return null;
        }
        int m=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[m]);
        root.left=BST(nums,l,m-1);
        root.right=BST(nums,m+1,r);
        return root;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
