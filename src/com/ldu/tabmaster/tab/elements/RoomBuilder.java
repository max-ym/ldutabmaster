package com.ldu.tabmaster.tab.elements;

public class RoomBuilder {

    private Judge judges[];

    private Team  oo;
    private Team  co;
    private Team  og;
    private Team  cg;

    public RoomBuilder() {}

    public RoomBuilder setJudges(Judge judges[]) {
        this.judges = judges;
        return this;
    }

    public RoomBuilder setOpeningOpposition(Team team) {
        this.oo = team;
        return this;
    }

    public RoomBuilder setClosingOpposition(Team team) {
        this.co = team;
        return this;
    }

    public RoomBuilder setOpeningGovernment(Team team) {
        this.og = team;
        return this;
    }

    public RoomBuilder setClosingGovernment(Team team) {
        this.cg = team;
        return this;
    }

    public Room build() throws InvalidJudgeListException {
        return new Room(judges, oo, og, co, cg);
    }
}
