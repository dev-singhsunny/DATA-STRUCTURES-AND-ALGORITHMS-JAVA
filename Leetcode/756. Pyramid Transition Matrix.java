import java.util.*;

class Solution {
  Map<String, Set<Character>> jump = new HashMap<>();
  Map<String, Boolean> memo = new HashMap<>();

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    for (String s : allowed) {
      String key = "" + s.charAt(0) + s.charAt(1);
      jump.computeIfAbsent(key, k -> new HashSet<>())
          .add(s.charAt(2));
    }
    return dfs(bottom);
  }

  private boolean dfs(String level) {
    if (level.length() == 1)
      return true;
    if (memo.containsKey(level))
      return memo.get(level);
    List<String> upperLevels = new ArrayList<>();
    buildNext(level, 0, new StringBuilder(), upperLevels);
    for (String up : upperLevels) {
      if (dfs(up)) {
        memo.put(level, true);
        return true;
      }
    }
    memo.put(level, false);
    return false;
  }

  private void buildNext(String curr, int idx,
      StringBuilder temp,
      List<String> result) {
    if (idx == curr.length() - 1) {
      result.add(temp.toString());
      return;
    }
    String pair = curr.substring(idx, idx + 2);
    if (!jump.containsKey(pair))
      return;
    for (char ch : jump.get(pair)) {
      temp.append(ch);
      buildNext(curr, idx + 1, temp, result);
      temp.deleteCharAt(temp.length() - 1);
    }
  }
}