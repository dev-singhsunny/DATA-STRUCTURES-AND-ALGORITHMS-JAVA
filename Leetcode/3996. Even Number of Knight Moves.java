class Solution {
    public boolean canReach(int[] start, int[] target) {
       int start_color=(start[0] + start[1]) &1;
        int target_color=(target[0] + target[1]) &1;
        return start_color==target_color;
    }
}