/**
 * 
 */
package com.ldu.tabmaster.tab;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import com.ldu.tabmaster.tab.elements.*;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author max
 *
 */
public class Tournament {

    private HashSet<ExperiencedJudge> judges;
    private HashSet<Wing>             wings;
    private HashSet<Team>             teams;
    private Motion                    motions[];
    private Tab                       tabs[];

    private int                       currentRound = -1;

    Tournament(HashSet<ExperiencedJudge> judges, HashSet<Wing> wings,
            HashSet<Team> teams, LinkedList<Motion> motions) {
        this.judges = judges;
        this.wings = wings;
        this.teams = teams;
        this.motions = motions.toArray(this.motions);

        this.tabs = new Tab[this.motions.length];
    }

    /**
     * Start new round for this tournament. New tab will be generated.
     * 
     * @throws IllegalStateException
     *             Raises when all rounds are already generated.
     */
    public void startNextRound() throws IllegalStateException {
        if (currentRound >= tabs.length - 1)
            throw new IllegalStateException(
                    "Cannot start round - all rounds already passed");

        currentRound++;

        tabs[currentRound] = generateTab();
    }

    /**
     * Current tab for the round.
     * 
     * @return Tab that was generated for current round.
     * @throws IllegalStateException
     *             No round wasn't yet created and there is no tab.
     */
    public Tab currentTab() throws IllegalStateException {
        if (currentRound < 0)
            throw new IllegalStateException("Round wasn't started and there"
                    + "is no tab but it was requested.");

        return tabs[currentRound];
    }

    /**
     * Number of parallel rooms in this tournament.
     * 
     * @return
     */
    public int roomCount() {
        return teams.size() / 4;
    }

    private Tab generateTab() {
        Judge judgeArr[][] = new Judge[roomCount()][];
        placeJudgesForRound(judgeArr);
        
        

        throw new NotImplementedException();
    }

    /**
     * Fill array with judges.
     * 
     * @param arr
     *            Array of judges per room. First dimension of array
     *            corresponds to rooms of the tournament. Second dimension
     *            stores
     *            actual list of judges in this room.
     */
    private void placeJudgesForRound(Judge arr[][]) {
        Iterator<ExperiencedJudge> experiencedIterator = judges.iterator();
        Iterator<Wing> wingIterator = wings.iterator();
        
        int experiencedPerRoom = judges.size() / roomCount();
        int expPerRoomReminder = judges.size() % roomCount();
        
        int wingsPerRoom = wings.size() / roomCount();
        int wingsPerRoomRem = wings.size() % roomCount();
        
        for (int i = 0; i < arr.length; i++) {
            int roomExpCount = experiencedPerRoom;
            if (expPerRoomReminder > 0) {
                roomExpCount++;
                expPerRoomReminder--;
            }
            
            int roomWingCount = wingsPerRoom;
            if (wingsPerRoomRem > 0) {
                roomWingCount++;
                wingsPerRoomRem--;
            }
            
            int roomJudgeCount = roomWingCount + roomExpCount;
            arr[i] = new Judge[roomJudgeCount];
            
            for (int a = 0; a < roomExpCount; a++) {
                arr[i][a] = experiencedIterator.next();
            }
            for (int a = roomExpCount; a < roomJudgeCount; a++) {
                arr[i][a] = wingIterator.next();
            }
        }
    }
}
