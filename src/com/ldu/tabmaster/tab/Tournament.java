/**
 * 
 */
package com.ldu.tabmaster.tab;

import java.util.HashSet;
import java.util.LinkedList;

import com.ldu.tabmaster.tab.elements.*;

/**
 * @author max
 *
 */
public class Tournament {

    private HashSet<ExperiencedJudge> judges;
    private HashSet<Wing>             wings;
    private HashSet<Team>             teams;
    private LinkedList<Motion>        motions;

    private int                       currentRound = 0;

    Tournament(HashSet<ExperiencedJudge> judges, HashSet<Wing> wings,
            HashSet<Team> teams, LinkedList<Motion> motions) {
        this.judges = judges;
        this.wings = wings;
        this.teams = teams;
        this.motions = motions;
    }

}
