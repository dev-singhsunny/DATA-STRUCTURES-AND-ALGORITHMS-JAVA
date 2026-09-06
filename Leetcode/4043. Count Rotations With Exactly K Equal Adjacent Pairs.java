class Solution {
  public int countRotations(String s, int k) {
    int n = s.length();
    if (n == 1) {
      return k == 0 ? 1 : 0;
    }
    int E = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == s.charAt((i + 1) % n)) {
        E++;
      }
    }
    if (k == E - 1) {
      return E;
    }
    if (k == E) {
      return n - E;
    }
    return 0;
  }
}