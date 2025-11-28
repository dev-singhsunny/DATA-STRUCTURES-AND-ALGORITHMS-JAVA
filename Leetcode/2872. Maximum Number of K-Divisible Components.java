import java.util.*;

class Solution {
  boolean vis[];

  int[] solve(int par, List<Integer>[] g, int val[], int k) {
    this.vis[par] = true;
    int cur = val[par], breaks = 0;
    for (int x : g[par]) {
      if (this.vis[x])
        continue;
      int child[] = solve(x, g, val, k);
      breaks += child[1];
      if ((child[0] % k) == 0)
        breaks++;
      else
        cur = (cur + child[0]) % k;
    }
    return new int[] { cur, breaks };
  }

  public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
    this.vis = new boolean[n];
    List<Integer>[] g = new ArrayList[n];
    for (int i = 0; i < n; i++)
      g[i] = new ArrayList<>();
    for (int x[] : edges) {
      g[x[0]].add(x[1]);
      g[x[1]].add(x[0]);
    }
    return solve(0, g, values, k)[1] + 1;
  }
}
