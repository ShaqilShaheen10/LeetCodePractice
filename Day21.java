1. Repeated Substring Pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                StringBuilder p=new StringBuilder(); 
                for(int j=0;j<n/i;j++){
                    p.append(s.substring(0,i));
                }
                if(s.equals(p.toString())){ 
                    return true; 
                }
            }
        } 
        return false;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Middle of The Linked List

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode f=head;
        ListNode s=head;
        while(f!=null){
            f=f.next;
            if(f!=null){ 
                f=f.next;
                s=s.next;
            } 
        } 
        return s;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Array Partition

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length;i+=2){
            ans+=nums[i];
        }
        return ans;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Most Common Value

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Reshape the Matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] s=new int[r][c];
        int x=0;
        int y=0;
        if(mat.length*mat[0].length==r*c){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(y==c){
                        x++;
                        y=0;
                    }
                    s[x][y]=mat[i][j];
                    y++;
                }
            }
            return s;
        }
        return mat;
    } 
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Distribute Candies

class Solution {
    public int distributeCandies(int[] candyType) {
     Set<Integer> set=new HashSet<>();
     for(int i:candyType){
        set.add(i);
     }
     return Math.min(candyType.length/2,set.size());
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Binary Subarrays with Sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int r=0;
       for(int s=0;s<nums.length;s++){
        int sum=0;
        for(int e=s;e<nums.length;e++){
            sum+=nums[e];
            if(sum==goal)
            r++;
        }
       }
       return r;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. Reverse Linked List

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode nextNode=null;
        while(curr!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. Existence of a Substring in a String and it's Reverse

class Solution {
    public boolean isSubstringPresent(String s) {
        String r="";
        for(char t:s.toCharArray()) r=t+r;
        for(int i=0;i<s.length()-1;i++){
            if(r.contains(s.substring(i,i+2))) return true;
        }
        return false;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. Find the Duplicate Number

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
