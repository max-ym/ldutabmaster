package com.ldu.tabmaster.tab;

public class InvalidTeamNumber extends TournamentArgumentException {

    private int number;
    
    public InvalidTeamNumber(int number) {
        super("Team number " + number + " cannot be split into valid rooms");
        
        this.number = number;
    }
    
    public int number() {
        return number;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 5832377951427139139L;

}
