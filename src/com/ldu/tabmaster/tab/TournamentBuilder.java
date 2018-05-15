package com.ldu.tabmaster.tab;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.ldu.tabmaster.tab.elements.*;

public class TournamentBuilder {

    private HashSet<Judge>     judges;
    private HashSet<Team>      teams;

    private int                expectedTeamNumber;
    private int                expectedJudgeNumber;
    private int                expectedMotionNumber;

    private LinkedList<Motion> motions;

    /**
     * Create new builder for tournament with predefined number of
     * teams and judges.
     * 
     * @param teamNumber
     *            Number of teams that joined the tournament.
     * @param judgeNumber
     *            Number of judges in the tournament.
     * @param motionNumber
     *            Number of motions of this tournament.
     * @throws TournamentArgumentException
     *             Exception occurs when team number cannot be split into
     *             rooms with 4 teams. Also, it occurs when minimal calculated
     *             amount of judges is above the given number of judges of the
     *             tournament.
     *             tournament.
     */
    public TournamentBuilder(int teamNumber, int judgeNumber, int motionNumber)
            throws TournamentArgumentException {
        validateArgs(teamNumber, judgeNumber);

        this.expectedTeamNumber = teamNumber;
        this.expectedJudgeNumber = judgeNumber;
        this.expectedMotionNumber = motionNumber;

        this.judges = new HashSet<Judge>();
        this.teams = new HashSet<Team>();
        this.motions = new LinkedList<Motion>();
    }

    public void addJudge(Judge j) {
        judges.add(j);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public void addMotion(Motion motion) {
        motions.add(motion);
    }

    public Set<Judge> judges() {
        return new HashSet<Judge>(judges);
    }
    
    public Set<Team> teams() {
        return new HashSet<Team>(teams);
    }
    
    public List<Motion> motions() {
        return new LinkedList<Motion>(motions);
    }

    /**
     * Validate that defined amount of teams and judges is valid to
     * create the tournament.
     * 
     * @param teamNumber
     *            Number of teams joined the tournament.
     * @param judgeNumber
     *            Number of experienced judges of the tournament.
     * @throws TournamentArgumentException
     *             Exception occurs when team number cannot be split into
     *             rooms with 4 teams. Also, it occurs when minimal calculated
     *             amount of judges is above the given number of judges of the
     *             tournament.
     *             tournament.
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
