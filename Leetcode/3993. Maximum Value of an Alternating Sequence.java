class Solution {
    public long maximumValue(int n, int s, int m) {
        if (n==1) return s;
        long peaks=n/2;
        long ans=s;
        if(peaks>0){
             ans +=m;
            ans +=(peaks-1) * (m-1);
        }
        return ans;
    }
}