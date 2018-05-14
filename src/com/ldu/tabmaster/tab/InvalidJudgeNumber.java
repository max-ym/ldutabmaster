package com.ldu.tabmaster.tab;

public class InvalidJudgeNumber extends TournamentArgumentException {

    private int number;
    private int minimum;
    
    public InvalidJudgeNumber(int number, int minimum) {
        super("Judge number " + number + "is not enough to judge all "
                + "rooms in this tournament. Minimal value is " + minimum);
        
        this.number = number;
        this.minimum = minimum;
    }
    
    /**
     * Minimal required number of judges to judge the tournament.
     * @return
     */
    public int minimum() {
        return minimum;
    }
    
    /**
     * Current number of judges that was set to judge the tournament.
     * @return
     */
    public int currentNumber() {
        return number;
    }

    /**
     * 
     */
    private static final long serialVersionUID = -5382134396747964306L;

}
