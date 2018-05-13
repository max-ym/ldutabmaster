/**
 * 
 */
package com.ldu.tabmaster.tab;

/**
 * @author max
 *
 */
public class Places {

    private TeamRole first;
    private TeamRole second;
    private TeamRole third;
    private TeamRole fourth;
    
    public Places(TeamRole first, TeamRole second, TeamRole third, 
            TeamRole fourth) throws AmbiguousPlaceException {
        validatePlaces(first, second, third, fourth);
        
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
    
    private static void validatePlaces(TeamRole first, TeamRole second,
            TeamRole third, TeamRole fourth) 
            throws AmbiguousPlaceException {
        if (first == null) {
            throw new NullPointerException("First place is Null");
        }
        if (second == null) {
            throw new NullPointerException("Second place is Null");
        }
        if (third == null) {
            throw new NullPointerException("Third place is Null");
        }
        if (fourth == null) {
            throw new NullPointerException("Fourth place is Null");
        }
        
        if (first == second || first == third || first == fourth) {
            throw new AmbiguousPlaceException();
        }
        if (second == third || first == fourth) {
            throw new AmbiguousPlaceException();
        }
        if (third == fourth) {
            throw new AmbiguousPlaceException();
        }
    }
    
    public TeamRole first() {
        return first;
    }
    
    public TeamRole second() {
        return second;
    }
    
    public TeamRole third() {
        return third;
    }
    
    public TeamRole fourth() {
        return fourth;
    }
}
