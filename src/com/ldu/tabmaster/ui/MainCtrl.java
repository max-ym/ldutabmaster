package com.ldu.tabmaster.ui;

public class MainCtrl {

    private Main main;
    
    public MainCtrl(Main main) {
        this.main = main;
    }
    
    public void createTournament() {
        main.closeWindow();
        new CreateTournament(main.getPrimaryStage()).start();
    }
    
    public void openTournament() {
        main.closeWindow();
    }
    
}
