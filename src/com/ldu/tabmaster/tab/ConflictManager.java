package com.ldu.tabmaster.tab;

import java.util.HashMap;

import com.ldu.tabmaster.tab.elements.*;

/**
 * Manager for tournament conflicts.
 * 
 * @author max
 *
 */
public class ConflictManager {

    private HashMap<Judge, Team[]> judgeWithTeams;
    private HashMap<Team, Team[]>  teamWithTeams;
    private HashMap<Team, Judge[]> teamWithJudges;

    public ConflictManager() {
        judgeWithTeams = new HashMap<Judge, Team[]>();
        teamWithTeams = new HashMap<Team, Team[]>();
        teamWithJudges = new HashMap<Team, Judge[]>();
    }

    /**
     * Array containing all teams this judge is in conflict with.
     * 
     * @param judge
     *            Particular judge with whom teams are in conflict.
     * @return
     *         Array with all conflicting teams or NULL if any.
     */
    public Team[] judgeConflicts(Judge judge) {
        return judgeWithTeams.get(judge);
    }

    /**
     * Array containing all judges this team is in conflict with.
     * 
     * @param team
     *            Particular team with which judges are in conflict.
     * @return
     *         Array with all conflicting judges or NULL if any.
     */
    public Judge[] teamConflictsWithJudges(Team team) {
        return teamWithJudges.get(team);
    }

    /**
     * Array containing all teams this team is in conflict with.
     * 
     * @param team
     *            Particular team with which teams are in conflict.
     * @return
     *         Array with all conflicting teams or NULL if any.
     */
    public Team[] teamConflictsWithTeams(Team team) {
        return teamWithTeams.get(team);
    }

    // TODO adding new conflicts
}
