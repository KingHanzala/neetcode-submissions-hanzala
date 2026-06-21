class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] c1 = new int[26];
        int [] c2 = new int[26];
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1>l2) return false;
        int r=0;
        while(r<=l2){
            if(r<l1) {
                c1[s1.charAt(r) - 'a']++;
                c2[s2.charAt(r) - 'a']++;
                r++;
                continue;
            }
            if(check(c1,c2)) return true;
            c2[s2.charAt(r-l1) - 'a']--;
            if(r<l2){
                c2[s2.charAt(r) - 'a']++;
            }
            r++;

        }
        return false;
    }

    public boolean check(int[] c1, int[] c2){
        for(int i=0; i<26; i++){
            if(c1[i]!=c2[i]) return false;
        }
        return true;
    }
}
