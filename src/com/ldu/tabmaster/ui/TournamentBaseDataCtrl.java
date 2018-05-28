package com.ldu.tabmaster.ui;

public class TournamentBaseDataCtrl {

    private final TournamentBaseData view;
    
    private MotionTable motionTable;
    
    public TournamentBaseDataCtrl(TournamentBaseData view) {
        this.view = view;
        
        this.motionTable = new MotionTable(view.motionTable);
    }
    
}
