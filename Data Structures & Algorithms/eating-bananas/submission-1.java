class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l=1, r=0;
        for(int pile: piles){
            r = Math.max(r, pile);
        }
        int ans = r;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(canEat(piles, mid, h)){
                ans = mid;
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return ans;
    }

    public boolean canEat(int[] piles, int mid, int h){
        int k = 0;
        for(int p: piles){
            k += (p+mid-1)/mid;
        }
        return k<=h;
    }
}
