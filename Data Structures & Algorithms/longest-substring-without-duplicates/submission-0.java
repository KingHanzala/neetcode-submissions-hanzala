class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int l=0, r=0;
        int size = 0;
        while(r<n){
            if(!map.containsKey(ch[r]) || map.get(ch[r]) == 0){
                map.put(ch[r], map.getOrDefault(ch[r],0)+1);
                r++;
                size = Math.max(size, r-l);
            } else {
                map.put(ch[l], map.get(ch[l])-1);
                l++;
            }
        }
        return size;
    }
}
