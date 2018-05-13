/**
 * 
 */
package com.ldu.tabmaster.tab;

/**
 * @author max
 *
 */
public class Judge extends Participant {
    
    private JudgeType type;
    
    public Judge(String name, JudgeType type) {
        super(name);
        this.type = type;
    }
    
    public boolean isWing() {
        return type == JudgeType.WING;
    }
    
    public boolean isHeadJudge() {
        return type == JudgeType.HEAD;
    }
}
