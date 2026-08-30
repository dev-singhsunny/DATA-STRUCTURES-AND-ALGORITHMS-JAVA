import java.util.*;

class Solution {
  public int countSpecialIntegers(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }
    }
    int ans = 0;
    for (int value : map.values()) {
      if (value == 1) {
        ans++;
      }
    }
    return ans;
  }
}