package com.ldu.tabmaster.tab;

import java.util.Comparator;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TeamComparator implements Comparator<Team> {

    private Comparator<Team> comparator;
    
    public TeamComparator(TeamComparisonType type) {
        switch (type) {
        case COMPARE_SPEAKER_POINTS:
            comparator = new CompareWithPoints();
        case IGNORE_SPEAKER_POINTS:
            comparator = new CompareIgnoringPoints();
        default:
            throw new NotImplementedException();
        }
    }

    @Override
    public int compare(Team o1, Team o2) {
        return comparator.compare(o1, o2);
    }
}

class CompareIgnoringPoints implements Comparator<Team> {

    @Override
    public int compare(Team arg0, Team arg1) {
        int score0 = arg0.score();
        int score1 = arg1.score();
        
        if (score0 > score1) {
            return 1;
        } else if (score0 == score1) {
            return 0;
        } else {
            return -1;
        }
    }
    
}

class CompareWithPoints implements Comparator<Team> {

    @Override
    public int compare(Team arg0, Team arg1) {
        int score0 = arg0.score();
        int score1 = arg1.score();
        
        if (score0 > score1) {
            return 1;
        } else if (score0 == score1) {
            return compareSpeakers(arg0, arg1);
        } else {
            return -1;
        }
    }
    
    private int compareSpeakers(Team t0, Team t1) {
        int s0 = t0.sumOfSpeakerPoints();
        int s1 = t1.sumOfSpeakerPoints();
        
        if (s0 > s1) {
            return 1;
        } else if (s0 == s1) {
            return 0;
        } else {
            return -1;
        }
    }
    
}
