class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int [] cnt = new int[1001];
        for(int h: hand){
            cnt[h]++;
        }
        boolean inProcess = false;
        int group=0;
        int i=0;
        int restartInd = -1;
        while(i<1001){
            if(cnt[i]==0 && inProcess){
                return false;
            } else if(cnt[i]!=0){
                group++;
                cnt[i]-=1;
                if(cnt[i] > 0 && restartInd == -1){
                    restartInd = i;
                }
                inProcess = true;
                i++;
                if(group == groupSize){
                    group = 0;
                    inProcess = false;
                    i = (restartInd!=-1) ? restartInd : i;
                }
            } else {
                i++;
            }
        }
        return group == 0;

    }
}
