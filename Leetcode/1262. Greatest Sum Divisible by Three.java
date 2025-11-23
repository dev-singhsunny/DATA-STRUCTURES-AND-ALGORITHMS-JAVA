class Solution {
    public int maxSumDivThree(int[] nums) {
              int dp[]=new int[3];
        for(int num:nums){
            int prev[]=dp.clone();
            for(int sum:prev){
                int newSum=sum+num;
                int remainder=newSum % 3;
                dp[remainder]= Math.max(dp[remainder],newSum);
            }
        }
        return dp[0];
    }
}