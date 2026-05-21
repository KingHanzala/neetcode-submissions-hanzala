class Solution {
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int max = 1;
        int st=0, en=0;
        for(int i=0; i<=n; i++){
            dp[i][i] = true;
        }
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = ch[i]==ch[i+1] ? true: false;
            if(dp[i][i+1]){
                max = 2;
                st=i;
                en=i+1;
            }
        }
        for(int gap=2; gap<n; gap++){
            for(int i=0; i<n-gap; i++){
                int j = i+gap;
                if(ch[i] == ch[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if(gap + 1 > max){
                        max = gap + 1;
                        st=i;
                        en=j;
                    }
                }
            }
        }
        return s.substring(st, en+1);
    }
}
