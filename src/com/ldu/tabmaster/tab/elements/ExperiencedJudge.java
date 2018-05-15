package com.ldu.tabmaster.tab.elements;

public class ExperiencedJudge extends Judge {

    public ExperiencedJudge(String name) {
        super(name);
    }

    @Override
    public boolean isExperienced() {
        return true;
    }

}
