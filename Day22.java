1. Find All the Duplicates in an Array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     List<Integer> ans=new ArrayList<Integer>(); 
     int[] count=new int[nums.length+1];
     for(int freq:nums) count[freq]++; 
     for(int i=1;i<=nums.length;i++){
        if(count[i]==2){ 
            ans.add(i); 
        } 
     }
     return ans;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. To Lower Case

class Solution {
    public String toLowerCase(String s) {
       char[] arr=s.toCharArray();
       for(int i=0;i<arr.length;i++){ 
        if('A'<=arr[i] && arr[i]<='Z'){
            arr[i]=(char)(arr[i]-'A'+'a');
            }
         }
       return new String(arr); 
    } 
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Subarray Poduct Less Than K

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0) return 0;
        int l=0,r=0,c=0,p=1;
        int n=nums.length; 
        while(r<n){ 
            p*=nums[r];
            while(p>=k) p/=nums[l++]; 
            c+=1+(r-l);
            r++;
        }
        return c;
    }
} 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Maximum Nesting Depth of the Parentheses

class Solution {
    public int maxDepth(String s) {
        int c=0,m=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') c++;
            m=Math.max(c,m);
            if(s.charAt(i)==')') c--; 
        }
        return m; 
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Valid Parenthesis String

class Solution {
    public boolean checkValidString(String s) {
        int min=0,max=0; 
        for(char c:s.toCharArray()){
            if(c=='('){
                min++; 
                max++;
            }
            else if(c==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            } 
            if(max<0) return false; 
            if(min<0)min=0;
        }
        return min==0;
    }
} 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Number of Students Unable to Eat Lunch

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count=new int[2];
        for(int student:students){
            count[student]++;
        }
        for(int sandwich:sandwiches){
            if(count[sandwich]==0){
                break;
            }
            count[sandwich]--;
        }
        return count[0]+count[1];
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. Time Needed to Buy Tickets

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total=0;
        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                total+=Math.min(tickets[i],tickets[k]);
            }
            else{
                total+=Math.min(tickets[i],tickets[k]-1);
            }
        }
        return total;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. Island Perimeter

class Solution {
    public int islandPerimeter(int[][] grid) {
        int island=0;
        int neighbours=0;
        for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++)
        if(grid[i][j]==1){
            ++island;
            if(i-1>=0 && grid[i-1][j]==1) ++neighbours;
            if(j-1>=0 && grid[i][j-1]==1) ++neighbours;
        }
        return 4*island-2*neighbours;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. Tribonnaci Number

public int tribonacci(int n) {
        int a=0,b=1,c=1;
        for(int i=3;i<=n+2;i++){
            c+=a+b;
            b=c-a-(a=b);
        }
        return a;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. Reverse Prefix of Word

    class Solution {
    public String reversePrefix(String word, char ch) {
        int f=word.indexOf(ch);
        if(f==-1){
            return word;
        }
        StringBuilder p=new StringBuilder(word.substring(0,f+1));
        return p.reverse().toString()+word.substring(f+1);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
