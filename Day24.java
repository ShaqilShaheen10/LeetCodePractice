1. Pass the Pillow

  public int passThePillow(int n, int time) {
        int chunks=time/(n-1);
        return chunks%2==0 ? (time%(n-1)+1) : (n-time%(n-1));
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.Find the Winner of the Circular Game

  public int findTheWinner(int n, int k) {
     int winner=0;
     for(int i=1;i<=n;i++){
        winner=(winner+k)%i;
     } 
     return winner+1;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Number of Senior Citizens

  class Solution {
    public int countSeniors(String[] details) {
        int a=0;
        for(var x: details){
            int b=Integer.parseInt(x.substring(11,13));
            if(b>60) ++a;
        }
        return a;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. 2(Two) Key Keyboard

  public int minSteps(int n) {
        if(n==1) return 0;
        int steps=0;
        int factor=2;
        while(n>1){
            while(n%factor==0){
                steps+=factor;
                n/=factor; 
            }
            factor++;
        }
        return steps;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Find The Missing Observations

  public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int totalSum=mean*(n+m);
        int oldSum=0;
        for(int roll:rolls){
            oldSum+=roll;
        }
        int missingSum=totalSum-oldSum;
        if(missingSum<n || missingSum>6*n){
            return new int[0];
        }
        int base=missingSum/n;
        int remainder=missingSum%n;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=base+(i<remainder?1:0);
        }
        return result;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Linked List in a Binary Tree

  public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head,head,root);
    }

    boolean dfs(ListNode head,ListNode cur,TreeNode root){
        if(cur==null) return true;
        if(root==null) return false;
        if(cur.val==root.val)cur=cur.next;
        else if(head.val==root.val)head=head.next;
        else cur=head;
        return dfs(head,cur,root.left)|| dfs(head,cur,root.right);
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Insert Greatest Common Divisors in a Linked List

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
  class Solution {
    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var p=head;
        while(p.next!=null){
            var newNode=new ListNode(gcd(p.val,p.next.val),p.next);
            p.next=newNode;
            p=newNode.next;
        }
        return head;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
