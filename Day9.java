10. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target=0;
        Arrays.sort(nums);
        Set<List<Integer>> s=new HashSet<>();
        List<List<Integer>> output=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                 s.add(Arrays.asList(nums[i],nums[j],nums[k]));
                 j++;
                 k--;   
                }
                else if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Range Sum of BST

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int c=(root.val>=low && root.val<=high)?root.val:0;
        int l=rangeSumBST(root.left,low,high);
        int r=rangeSumBST(root.right,low,high);
        return c+l+r;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Leaf-Similar Trees

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> Leaf1=new ArrayList<>();
        List<Integer> Leaf2=new ArrayList<>();
        collectLeaf(root1,Leaf1);
        collectLeaf(root2,Leaf2);
        return Leaf1.equals(Leaf2);
    }
    private void collectLeaf(TreeNode root,List<Integer> Leaf){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            Leaf.add(root.val);
        }
        collectLeaf(root.left,Leaf);
        collectLeaf(root.right,Leaf);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
