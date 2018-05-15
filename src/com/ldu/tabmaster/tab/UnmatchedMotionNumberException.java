package com.ldu.tabmaster.tab;

public class UnmatchedMotionNumberException
        extends TournamentArgumentException {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4565173851748434809L;
    
    private int value;
    private int expectedValue;
    
    public UnmatchedMotionNumberException(int val, int exp) {
        this.value = val;
        this.expectedValue = exp;
    }
    
    public UnmatchedMotionNumberException(int val, int exp, String str) {
        super(str);
        this.value = val;
        this.expectedValue = exp;
    }
    
    public int motionNumber() {
        return value;
    }
    
    public int expectedMotionNumber() {
        return expectedValue;
    }
}
