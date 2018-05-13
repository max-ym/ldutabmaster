/**
 * 
 */
package com.ldu.tabmaster.tab;

/**
 * @author max
 *
 */
public class Speaker extends Participant implements Comparable<Speaker> {

    /** Speaker points. */
    public int points;
    
    public Speaker(String name) {
        super(name);
    }
    
    public int speakerPoints() {
        return points;
    }
    
    public void addSpeakerPoints(int count) {
        points += count;
    }

    @Override
    public int compareTo(Speaker o) {
        if (o.points < this.points)
            return -1;
        else if (o.points == this.points)
            return 0;
        else
            return 1;
    }
}
