1. Boats To Save People

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats=0;
        Arrays.sort(people); 
        int i=0,j=people.length-1;
        while(i<=j){
            if((people[j]+people[i])<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Delete Node in a Linked List

    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Maximize Happiness of Selected Children
    class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long r=0;
        int n=happiness.length,j=0;
        for(int i=n-1;i>=n-k;--i){
            happiness[i]=Math.max(happiness[i]-j++,0);
            r+=happiness[i];
        }
        return r;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Delete Leaves with a Given Value

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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;
        root.left=removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);
        if(root.left==null && root.right==null && root.val==target)
            return null;
        return root;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Special Array with X Elements Greater than or Equal X

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[0]>=n) return n;
        for(int i=0;i<=n;i++){
            if(nums[n-1]>i&&(n-i-1<i||nums[n-i-1]<i)){
                return i;
            }
        }
        return -1;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Number of Steps to Reduce a Number in Binary Representation to One

 public int numSteps(String s) {
        int count=0;
        int carry=0;
        for(int i=s.length()-1;i>=1;i--){
            int num=s.charAt(i)-'0';
            if(num==0 && carry==0){
                count++;
            }else if(num==1 && carry==1){
                count++;
                carry=1;
            }else{
                count+=2;
                carry=1;
            }
        }
        if(carry==1)count++;
        return count;
    }
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Score of a String

class Solution {
    public int scoreOfString(String s) {
    int total=0;
    for(int i=0;i<s.length()-1;i++){
        total+=Math.abs(s.charAt(i)-s.charAt(i+1));
    }
    return total;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
