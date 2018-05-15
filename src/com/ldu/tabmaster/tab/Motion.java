package com.ldu.tabmaster.tab;

/**
 * The subject of the round.
 * 
 * @author max
 *
 */
public class Motion {

    private String motion;
    private String infoslide;
    
    public Motion(String motion) {
        this.motion = motion;
    }
    
    public Motion(String motion, String infoslide) {
        this.motion = motion;
        this.infoslide = infoslide;
    }
    
    public String motion() {
        return motion;
    }
    
    public String infoslide() {
        return infoslide;
    }
    
    public boolean hasInfoslide() {
        return infoslide != null;
    }
}
