class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        List<Integer> points = new ArrayList<>();
        int n = nums.size();

        for (int i = 1; i < n - 1; i++) {
            if (
                nums.get(i) > nums.get(i - 1) &&
                nums.get(i) > nums.get(i + 1)
            ) {
                points.add(i);
            } else if (
                nums.get(i) < nums.get(i - 1) &&
                nums.get(i) < nums.get(i + 1)
            ) {
                points.add(i);
            }
        }

        int m = points.size();

        if (m < 2) {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;
        int maxDist = points.get(m - 1) - points.get(0);

        for (int i = 1; i < m; i++) {
            minDist = Math.min(
                minDist,
                points.get(i) - points.get(i - 1)
            );
        }

        return new int[]{minDist, maxDist};
    }
}