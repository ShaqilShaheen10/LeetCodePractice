1. Set Mismatch

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int[] v=new int[n+1];
        int dup=0,mis=0;
        for(int i=0;i<n;i++){
            v[nums[i]]++;
        }
        for(int i=1;i<v.length;i++){
            if(v[i]==2){
                dup=i;
            }
            if(v[i]==0){
                mis=i;
            }
        }
        return new int[]{dup,mis};
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Contains Duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Pseudo-Palindromic Path in a Binary Tree

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
    public int pseudoPalindromicPaths (TreeNode root) {
      return countP(root,0);
    }
    public int countP(TreeNode node,int path){
        if(node==null){
            return 0;
        }
        path^=(1<<node.val);
        if(node.left==null && node.right==null){
            return (path&(path-1))==0?1:0;
        }
        return countP(node.left,path)+countP(node.right,path);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count=new int[26];
        for(char x:s.toCharArray()){
            count[x-'a']++;
        }
        for(char x:t.toCharArray()){
            count[x-'a']--;
        }
        for(int val:count){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Missing Number

class Solution {
    public int missingNumber(int[] nums) {
     int sum=0;
     int n=nums.length;
     Arrays.sort(nums);
     for(int i=0;i<nums.length;i++){
         sum+=nums[i];
     }
     int t=(n*(n+1))/2;
     int r=t-sum;
     return r;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
