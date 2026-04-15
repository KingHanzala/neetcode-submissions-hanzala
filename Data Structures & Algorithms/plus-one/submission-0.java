class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i=n-1; i>=0; i--){
            int curr = digits[i] + carry;
            digits[i] = curr>9 ? 0 : curr;
            carry = curr>9? 1 : 0;
        }
        if(carry==1){
            int[] res = new int[n+1];
            res[0] = 1;
            for(int i=0; i<n; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
