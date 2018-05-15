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

    private HashSet<Judge>     judges;
    private HashSet<Team>      teams;
    private LinkedList<Motion> motions;

    Tournament(HashSet<Judge> judges, HashSet<Team> teams,
            LinkedList<Motion> motions) {
        this.judges = judges;
        this.teams = teams;
        this.motions = motions;
    }

}
