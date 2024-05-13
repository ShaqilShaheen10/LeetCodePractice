1. Pascal's Triangle

class Solution {
    public List<Integer> generator(int r){
        long a=1;
        List<Integer> ar=new ArrayList<>();
        ar.add(1);
        for(int c=1;c<r;c++){
            a=a*(r-c);
            a=a/c;
            ar.add((int)a);
        }
        return ar;
    }
    public List<List<Integer>> generate(int n){
        List<List<Integer>> a=new ArrayList<>();
        for(int r=1;r<=n;r++){
            a.add(generator(r));
        }
        return a;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Pascal's Triangle 2

public class Solution{
    public List<Integer> getRow(int R){
        List<Integer> r=new ArrayList<>();
        r.add(1);
        long p=1;
        for(int k=1;k<=R;k++){
            long n=p*(R-k+1)/k; 
            r.add((int)n);
            p=n;
        }
        return r;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Same Tree

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null || p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Symmetric Tree
 
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
   public boolean isSymmetric(TreeNode root){
       if(root==null){
           return true;
       }
       return isMirror(root.left,root.right);
   }
   public boolean isMirror(TreeNode node1,TreeNode node2){
       if(node1==null && node2==null){
           return true;
       }
       if(node1==null || node2==null){
           return false;
       }
       return node1.val==node2.val && isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
   }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Climbing Stairs

class Solution{
    public int climbStairs(int n){
        if(n==0 || n==1){
            return 1;
        }
        int p=1,c=1;
        for(int i=2;i<=n;i++){
            int t=c;
            c=c+p;
            p=t;
        }
        return c;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
