class Solution {
  public int countNegatives(int[][] grid) {
    int rowCount = grid.length;
    int colCount = grid[0].length;
    int row = 0;
    int col = colCount - 1;
    int negativeTotal = 0;
    for (; row < rowCount && col >= 0;) {
      if (grid[row][col] < 0) {
        negativeTotal += rowCount - row;
        col--;
      } else {
        row++;
      }
    }
    return negativeTotal;
  }
}