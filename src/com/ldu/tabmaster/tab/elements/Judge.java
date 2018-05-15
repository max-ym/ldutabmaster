/**
 * 
 */
package com.ldu.tabmaster.tab.elements;

/**
 * @author max
 *
 */
public abstract class Judge extends Participant {
    
    public Judge(String name) {
        super(name);
    }
    
    public abstract boolean isExperienced();
}
