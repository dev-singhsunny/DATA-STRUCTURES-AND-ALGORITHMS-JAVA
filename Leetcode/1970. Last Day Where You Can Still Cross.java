class Solution {
  int[] parent, rank;
  int rows, cols;
  int top, bottom;

  public int latestDayToCross(int row, int col, int[][] cells) {
    rows = row;
    cols = col;
    int n = row * col;

    parent = new int[n + 2];
    rank = new int[n + 2];

    top = n;
    bottom = n + 1;

    for (int i = 0; i < n + 2; i++)
      parent[i] = i;

    boolean[][] land = new boolean[row][col];

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int day = cells.length - 1; day >= 0; day--) {
      int r = cells[day][0] - 1;
      int c = cells[day][1] - 1;
      land[r][c] = true;

      int idx = r * col + c;

      if (r == 0)
        union(idx, top);
      if (r == row - 1)
        union(idx, bottom);

      for (int[] d : dirs) {
        int nr = r + d[0], nc = c + d[1];
        if (nr >= 0 && nc >= 0 && nr < row && nc < col && land[nr][nc]) {
          union(idx, nr * col + nc);
        }
      }

      if (find(top) == find(bottom)) {
        return day;
      }
    }
    return 0;
  }

  int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b)
      return;

    if (rank[a] < rank[b])
      parent[a] = b;
    else if (rank[a] > rank[b])
      parent[b] = a;
    else {
      parent[b] = a;
      rank[a]++;
    }
  }
}
