package com.ldu.tabmaster.tab;

public class UnmatchedTeamNumberException
        extends TournamentArgumentException {

    /**
     * 
     */
    private static final long serialVersionUID = -6992689143929852884L;
    
    private int value;
    private int expectedValue;
    
    public UnmatchedTeamNumberException(int val, int exp) {
        this.value = val;
        this.expectedValue = exp;
    }
    
    public UnmatchedTeamNumberException(int val, int exp, String str) {
        super(str);
        this.value = val;
        this.expectedValue = exp;
    }
    
    public int teamNumber() {
        return value;
    }
    
    public int expectedTeamNumber() {
        return expectedValue;
    }
}
