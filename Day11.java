1. Intersection of Two Linked Lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
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
4.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
