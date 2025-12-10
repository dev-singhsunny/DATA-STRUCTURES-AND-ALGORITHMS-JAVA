class Solution {
  public int countPermutations(int[] complexity) {
    int d = 0;
    int n = complexity.length;
    for (int i = 1; i < complexity.length; i++) {
      if (complexity[0] < complexity[i])
        d++;
    }
    if (d < n - 1)
      return 0;
    int res = 1;
    for (int i = 1; i <= d; i++) {
      res = (int) ((long) res * i % 1000000007);
    }
    return res;
  }
}