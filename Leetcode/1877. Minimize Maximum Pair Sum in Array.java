import java.util.*;

class Solution {
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < n / 2; i++) {
      int temp = nums[i] + nums[n - i - 1];
      sum = Math.max(temp, sum);
    }
    return sum;
  }
}