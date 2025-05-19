1. Move Zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                s++; 
            }
            else if(s>0){  
                int t=nums[i];
                nums[i]=0; 
                nums[i-s]=t;
            } 
        }
    } 
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Count Complete Tree Nodes
 
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
    public int countNodes(TreeNode root) { 
    return root==null?0:1+countNodes(root.left)+countNodes(root.right);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Find The Difference

class Solution {
    public char findTheDifference(String s, String t) {
       char c=0;
       for(char cs:s.toCharArray()) c^=cs;
       for(char ct:t.toCharArray()) c^=ct;
       return c;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Power of Three

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;  
        }
        if(n==0 || n%3!=0){
            return false;
        }
        return isPowerOfThree(n/3);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Power of Four
 
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1){
            return true; 
        } 
        if(n==0 || n%4!=0){
            return false;
        }
        return isPowerOfFour(n/4);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
