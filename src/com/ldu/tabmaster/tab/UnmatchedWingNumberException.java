package com.ldu.tabmaster.tab;

public class UnmatchedWingNumberException
        extends TournamentArgumentException {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4842371160209362340L;
    
    private int value;
    private int expectedValue;
    
    public UnmatchedWingNumberException(int val, int exp) {
        this.value = val;
        this.expectedValue = exp;
    }
    
    public UnmatchedWingNumberException(int val, int exp, String str) {
        super(str);
        this.value = val;
        this.expectedValue = exp;
    }
    
    public int wingNumber() {
        return value;
    }
    
    public int expectedWingNumber() {
        return expectedValue;
    }
}
