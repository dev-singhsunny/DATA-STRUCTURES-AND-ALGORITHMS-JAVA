import java.util.Arrays;
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b)->{
            if(a[1]==b[1])return b[0]-a[0];
            return a[1]-b[1];
        });
        int max = -1, secMax = -1;
        int res = 0;
        for(var it: intervals){
            int start = it[0];
            int end = it[1];
            if(max>=start && secMax>=start)continue;
            if(max>=start){
                secMax = max;
                max = end;
                res++;
            }else{
                max = end;
                secMax = end-1;
               res += 2;
            }
        }
        return res;
    }
}

