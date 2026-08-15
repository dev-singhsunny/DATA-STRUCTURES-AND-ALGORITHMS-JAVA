class Solution {
    public int elevatorRequests(int n, int[] requests) {
       int current=0;
        int time=0;
        for (int i=0; i<requests.length; i++)
            {
               time +=
                   Math.abs(current-requests[i]);
                current = requests[i];
            }
        return time;
    }
}