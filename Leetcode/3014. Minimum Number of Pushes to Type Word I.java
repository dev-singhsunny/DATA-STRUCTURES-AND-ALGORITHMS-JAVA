import java.util.*;

class Solution {
  public int minimumPushes(String word) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : word.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.addAll(freq.values());
    int ans = 0;
    int index = 0;
    while (!maxHeap.isEmpty()) {
      int frequency = maxHeap.poll();
      int presses = index / 8 + 1;
      ans += frequency * presses;
      index++;
    }
    return ans;
  }
}