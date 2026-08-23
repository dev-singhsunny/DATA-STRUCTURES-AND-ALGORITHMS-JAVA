class Solution {
  public boolean isPalindromic(String s) {
    StringBuilder binary = new StringBuilder();
    for (char ch : s.toCharArray()) {
      String b = Integer.toBinaryString(ch);
      while (b.length() < 8) {
        b = "0" + b;
      }
      binary.append(b);
    }
    int left = 0;
    int right = binary.length() - 1;
    while (left < right) {
      if (binary.charAt(left) != binary.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}