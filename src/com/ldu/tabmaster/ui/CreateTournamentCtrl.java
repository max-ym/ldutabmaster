package com.ldu.tabmaster.ui;

public class CreateTournamentCtrl {

    private final CreateTournament view;
    
    public CreateTournamentCtrl(CreateTournament view) {
        this.view = view;
    }
    
    public void cancel() {
        // TODO
    }
    
    public void create() {
        boolean valuesOk = checkValues();
        if (valuesOk) {
            // TODO
        }
    }
    
    private boolean checkValues() {
        if (view.judgeCount() * 4 < view.teamCount()) {
            // Not enough judges for all the teams.
            view.showNotEnoughJudges();
            return false;
        }
        
        return true;
    }
}
