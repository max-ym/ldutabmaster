package com.ldu.tabmaster.tab;

import java.util.HashMap;
import java.util.Set;

import com.ldu.tabmaster.tab.elements.*;

/**
 * Manager for tournament conflicts.
 * 
 * @author max
 *
 */
public class ConflictManager {

    private HashMap<Judge, Set<Team>> judgeWithTeams;
    private HashMap<Team, Set<Team>>  teamWithTeams;
    private HashMap<Team, Set<Judge>> teamWithJudges;

    public ConflictManager() {
        judgeWithTeams = new HashMap<Judge, Set<Team>>();
        teamWithTeams = new HashMap<Team, Set<Team>>();
        teamWithJudges = new HashMap<Team, Set<Judge>>();
    }

    /**
     * Array containing all teams this judge is in conflict with.
     * 
     * @param judge
     *            Particular judge with whom teams are in conflict.
     * @return
     *         Set with all conflicting teams.
     */
    public Set<Team> judgeConflicts(Judge judge) {
        return judgeWithTeams.get(judge);
    }

    /**
     * Array containing all judges this team is in conflict with.
     * 
     * @param team
     *            Particular team with which judges are in conflict.
     * @return
     *         Set with all conflicting judges.
     */
    public Set<Judge> teamConflictsWithJudges(Team team) {
        return teamWithJudges.get(team);
    }

    /**
     * Array containing all teams this team is in conflict with.
     * 
     * @param team
     *            Particular team with which teams are in conflict.
     * @return
     *         Array with all conflicting teams.
     */
    public Set<Team> teamConflictsWithTeams(Team team) {
        return teamWithTeams.get(team);
    }

    // TODO adding new conflicts
}
