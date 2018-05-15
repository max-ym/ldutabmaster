package com.ldu.tabmaster.tab;

import java.util.HashMap;
import java.util.HashSet;
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

    /**
     * Add new conflict between judge and team.
     * 
     * @param t
     *            Team that is in conflict.
     * @param j
     *            Judge that is in conflict.
     * @exception NullPointerException
     *                Raises when either team or judge argument is null.
     */
    public void addTeamConflictWithJudge(Team t, Judge j)
            throws NullPointerException {
        // Validate arguments.
        if (t == null)
            throw new NullPointerException("Team argument cannot be null");
        if (j == null)
            throw new NullPointerException("Judge argument cannot be null");

        // Check whether conflict set for this team exists.
        Set<Judge> setJ = teamConflictsWithJudges(t);
        if (setJ == null) {
            // Create new team entry.
            setJ = new HashSet<Judge>();
            teamWithJudges.put(t, setJ);
        }

        setJ.add(j);

        // Check whether set for this judge exists.
        Set<Team> set = judgeConflicts(j);
        if (set == null) {
            // Create new team entry.
            set = new HashSet<Team>();
            judgeWithTeams.put(j, set);
        }

        set.add(t);
    }

    /**
     * Add conflict between two teams. The result is the same if 'a' and 'b'
     * argument get swapped.
     * 
     * @param a
     *            First team in conflict.
     * @param b
     *            Second team in conflict.
     * @throws NullPointerException
     *             Raises when either team is null.
     */
    public void addTeamConflictWithTeam(Team a, Team b)
            throws NullPointerException {
        // Validate arguments.
        if (a == null)
            throw new NullPointerException("First team cannot be null");
        if (b == null)
            throw new NullPointerException("Second team cannot be null");

        Set<Team> setA = teamConflictsWithTeams(a);
        Set<Team> setB = teamConflictsWithTeams(b);

        if (setA == null) {
            // Create new team entry.
            setA = new HashSet<Team>();
            teamWithTeams.put(a, setA);
        }
        if (setB == null) {
            // Create new team entry.
            setA = new HashSet<Team>();
            teamWithTeams.put(b, setB);
        }

        setA.add(b);
        setB.add(a);
    }
}
