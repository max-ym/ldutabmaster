package com.ldu.tabmaster.tab;

public class UnmatchedJudgeNumberException
        extends TournamentArgumentException {

    private int value;
    private int expectedValue;
    
    public UnmatchedJudgeNumberException(int val, int exp) {
        this.value = val;
        this.expectedValue = exp;
    }
    
    public UnmatchedJudgeNumberException(int val, int exp, String str) {
        super(str);
        this.value = val;
        this.expectedValue = exp;
    }
    
    public int judgeNumber() {
        return value;
    }
    
    public int expectedJudgeNumber() {
        return expectedValue;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 2802902677571647323L;

}
