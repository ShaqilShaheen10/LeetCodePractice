1.Divide Two Integers

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==-2147483648 && divisor==-1){
            return Integer.MAX_VALUE;
        }
        return dividend/divisor;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Integer to Hexadecimal

class Solution{
    public String toHex(int num){
        rreturn Integer.toHexString(num);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Arrange Coins

class Solution{
    public int arrangeCoins(int n){
        return (int)((Math.sqrt(1+8L *(long)n)-1)/2);
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Construct the Rectangle

class Solution {
    public int[] constructRectangle(int area) {
        int i=(int)Math.sqrt(area);
        for(;i>=1;i--){
            if(area%i==0){{
                return new int[]{area/i,i};
            }}
        }
        return new int[]{area,1};
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Summary Ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i]+1==nums[i+1])i++;
            if(start!=nums[i]){
                al.add(""+start+"->"+nums[i]);
            }
            else{
                al.add(""+start);
            }
        }
        return al;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
