package com.ldu.tabmaster.tab;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.ldu.tabmaster.tab.elements.*;

public class TournamentBuilder {

    private HashSet<ExperiencedJudge> judges;
    private HashSet<Wing>             wings;
    private HashSet<Team>             teams;

    private int                       expectedTeamNumber;
    private int                       expectedJudgeNumber;
    private int                       expectedWingNumber;
    private int                       expectedMotionNumber;

    private LinkedList<Motion>        motions;

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
    public TournamentBuilder(int judgeNumber, int wingNumber, 
            int teamNumber, int motionNumber)
            throws TournamentArgumentException {
        validateArgs(teamNumber, judgeNumber);

        this.expectedTeamNumber = teamNumber;
        this.expectedJudgeNumber = judgeNumber;
        this.expectedWingNumber = wingNumber;
        this.expectedMotionNumber = motionNumber;

        this.judges = new HashSet<ExperiencedJudge>();
        this.wings = new HashSet<Wing>();
        this.teams = new HashSet<Team>();
        this.motions = new LinkedList<Motion>();
    }

    public void addJudge(ExperiencedJudge j) {
        judges.add(j);
    }
    
    public void addWing(Wing w) {
        wings.add(w);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public void addMotion(Motion motion) {
        motions.add(motion);
    }

    public Set<ExperiencedJudge> judges() {
        return new HashSet<ExperiencedJudge>(judges);
    }
    
    public Set<Wing> wings() {
        return new HashSet<Wing>(wings);
    }

    public Set<Team> teams() {
        return new HashSet<Team>(teams);
    }

    public List<Motion> motions() {
        return new LinkedList<Motion>(motions);
    }

    public Tournament build() throws TournamentArgumentException {
        if (judges.size() != expectedJudgeNumber) {
            throw new UnmatchedJudgeNumberException(judges.size(),
                    expectedJudgeNumber);
        }
        if (teams.size() != expectedTeamNumber) {
            throw new UnmatchedTeamNumberException(teams.size(),
                    expectedTeamNumber);
        }
        if (motions.size() != expectedMotionNumber) {
            throw new UnmatchedMotionNumberException(motions.size(),
                    expectedMotionNumber);
        }
        if (wings.size() != expectedWingNumber) {
            throw new UnmatchedMotionNumberException(wings.size(),
                    expectedWingNumber);
        }

        return new Tournament(judges, wings, teams, motions);
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
