class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
       String[] start_time =startTime.split(":");
       String[] end_time=endTime.split(":");

        int start = Integer.parseInt(start_time[0])*3600 
                    + 
            Integer.parseInt(start_time[1]) * 60 
                    +
            Integer.parseInt(start_time[2]);

        int end= Integer.parseInt(end_time[0]) *3600  
                            + 
            Integer.parseInt(end_time[1]) * 60 
                            +
            Integer.parseInt(end_time[2]);
        return end-start;
    }
}