class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        int l=0, r=0;
        char [] arr = s.toCharArray();
        int n = arr.length;
        int ans = 0;
        while(r<n){
            freq[arr[r]-'A']++;
            while((r-l+1)-getMax(freq)>k){
                freq[arr[l]-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;

        }
        return ans;
    }

    public int getMax(int[] freq){
        int max = 0;
        for(int i=0; i<26; i++){
            max = Math.max(max, freq[i]);
        }
        return max;
    }
}
