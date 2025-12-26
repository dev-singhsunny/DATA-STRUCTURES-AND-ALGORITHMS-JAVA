class Solution {
    public int bestClosingTime(String customers) {
        int currpenalty=0, minpenalty=0;
        for(int i=0; i<customers.length(); i++)
        {
            if(customers.charAt(i)=='Y')
                currpenalty++;
        }
        minpenalty=currpenalty;
        int hour=0;
        for(int i=0; i<customers.length(); i++)
        {
            char ch=customers.charAt(i);
            if(ch=='Y')
            {
               currpenalty--;                 
            }
            else currpenalty++;
            if(currpenalty<minpenalty)
            {
                hour=i+1;
                minpenalty=currpenalty;
            }
        }
        return hour;
    }
}