package com.ldu.tabmaster.tab;

import java.util.LinkedList;

import com.ldu.tabmaster.tab.elements.*;

public class TournamentBuilder {

    private LinkedList<Judge> judges;
    private LinkedList<Team>  teams;

    private int               teamNumber;
    private int               judgeNumber;
    
    private ConflictManager   conflicts;

    /**
     * Create new builder for tournament with predefined number of
     * teams and judges.
     * 
     * @param teamNumber
     *            Number of teams that joined the tournament.
     * @param judgeNumber
     *            Number of judges in the tournament.
     */
    public TournamentBuilder(int teamNumber, int judgeNumber) {
        validateArgs(teamNumber, judgeNumber);

        this.teamNumber = teamNumber;
        this.judgeNumber = judgeNumber;
    }

    /**
     * Validate that defined amount of teams and judges is valid to
     * create the tournament.
     * 
     * @param teamNumber
     *          Number of teams joined the tournament.
     * @param judgeNumber
     *          Number of experienced judges of the tournament.
     * @throws TournamentArgumentException
     *          Exception occurs when team number cannot be split into
     *          rooms with 4 teams. Also, it occurs when minimal calculated
     *          amount of judges is above the given number of judges of the
     *          tournament.
     *          tournament.
     */
    private static void validateArgs(int teamNumber, int judgeNumber)
            throws TournamentArgumentException {
        if (teamNumber % 4 != 0) {
            throw new InvalidTeamNumber(teamNumber);
        }

        int minimalJudgeNumber = teamNumber / 4;
        if (minimalJudgeNumber > judgeNumber) {
            throw new InvalidJudgeNumber(judgeNumber, minimalJudgeNumber);
        }
    }
}
