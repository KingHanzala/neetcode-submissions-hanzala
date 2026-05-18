class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)){
            return 0;
        }
        Set<String> used = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Queue<Integer> cnt = new LinkedList<>();
        q.offer(beginWord);
        cnt.offer(1);
        used.add(beginWord);
        while(q.size()>0){
            String curr = q.poll();
            int count = cnt.poll();
            if(curr.equals(endWord)){
                return count;
            }
            for(int i=0; i<n; i++){
                char[] near = curr.toCharArray();
                for(int j=0; j<26; j++){
                    near[i] = (char) ('a' + j);
                    String next = new String(near);
                    if(words.contains(next) && !used.contains(next)){
                        q.offer(next);
                        cnt.offer(count + 1);
                        used.add(next);
                    }
                }
            }
        }
        return 0;
    }

    // public int diff(String w1, String w2){
    //     int cnt =0;
    //     for(int i=0; i<w1.length; i++){
    //         if(w1.charAt(i)!=w2.charAt(i)) cnt++;
    //     }
    //     return cnt;
    // }
}
