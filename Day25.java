1. Minimum Number of Changes to make the Binary String Beautiful

  public int minChanges(String s) {
        int c=0;
        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i)!=s.charAt(i+1)){
                c++;
            }
        }
        return c;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Largest Combination of Bitwise AND Greater than Zero

  public int largestCombination(int[] candidates) {
        int a=0;
        for(int i=0;i<32;i++){
            int c=0;
            for(int candidate:candidates){
                if((candidate&(1<<i))!=0) c++;
            }
            a=Math.max(a,c);
        }
        return a;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Check if a Word occurs as as Prefix of Any Word in the Sentence

   public int isPrefixOfWord(String sentence, String searchWord) {
        int i=0;
        for(String str:sentence.split(" ")){
            if(str.startsWith(searchWord)){
                return i+1;
            }
            i++;
        }
        return -1;
    }
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
