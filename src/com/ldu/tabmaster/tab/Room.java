/**
 * 
 */
package com.ldu.tabmaster.tab;

/**
 * @author max
 *
 */
public class Room {

    private Judge judges[];

    private Team  ooTeam;
    private Team  ogTeam;
    private Team  coTeam;
    private Team  cgTeam;
    
    private Places places = null;

    public Room(Judge judges[], Team oo, Team og, Team co, Team cg)
            throws InvalidJudgeListException {
        validateJudgeArray(judges);
        validateTeams(oo, og, co, cg);

        this.judges = judges;
        ooTeam = oo;
        coTeam = co;
        ogTeam = og;
        cgTeam = cg;
    }

    private static void validateJudgeArray(Judge judges[])
            throws InvalidJudgeListException {
        if (judges.length == 0) {
            throw new EmptyJudgeListException();
        }

        boolean hasExperienced = false;

        for (int i = 0; i < judges.length; i++) {
            hasExperienced |= judges[i].isExperienced();
        }

        if (!hasExperienced) {
            throw new NoExperiencedJudgeException();
        }
    }
    
    private static void validateTeams(Team oo, Team og, Team co, Team cg) {
        if (oo == null) {
            throw new NullPointerException("Opening Opposition is Null");
        }
        if (og == null) {
            throw new NullPointerException("Opening Government is Null");
        }
        if (co == null) {
            throw new NullPointerException("Closing Opposition is Null");
        }
        if (cg == null) {
            throw new NullPointerException("Closing Government is Null");
        }
    }
    
    public Judge[] judges() {
        return judges.clone();
    }
    
    public Team openingOpposition() {
        return ooTeam;
    }
    
    public Team closingOpposition() {
        return coTeam;
    }
    
    public Team openingGovernment() {
        return ogTeam;
    }
    
    public Team closingGovernment() {
        return cgTeam;
    }
    
    public void setPlaces(Places places) {
        this.places = places;
    }
    
    public Places places() {
        return places;
    }
}
