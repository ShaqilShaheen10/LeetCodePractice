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
5.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
