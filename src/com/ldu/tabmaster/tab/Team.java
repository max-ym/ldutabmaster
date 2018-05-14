package com.ldu.tabmaster.tab;

public class Team {

    private String name;
    
    private Speaker speaker0;
    private Speaker speaker1;
    
    private int score;
    
    public Team(String name, Speaker s0, Speaker s1, int score) {
        this.name = name;
        this.speaker0 = s0;
        this.speaker1 = s1;
        this.score = score;
    }
    
    public String name() {
        return name;
    }
    
    public Speaker speaker0() {
        return speaker0;
    }
    
    public Speaker speaker1() {
        return speaker1;
    }
    
    public int score() {
        return score;
    }
    
    public void addScore(int s) {
        score += s;
    }
    
    public int sumOfSpeakerPoints() {
        return speaker0.speakerPoints() + speaker1.speakerPoints();
    }
}
