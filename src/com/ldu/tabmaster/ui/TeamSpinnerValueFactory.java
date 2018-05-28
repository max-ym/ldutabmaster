package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

class TeamSpinnerValueFactory extends IntegerSpinnerValueFactory {
    
    public TeamSpinnerValueFactory() {
        // Limit team number from 4 to 800.
        super(4, 800);
        this.setAmountToStepBy(4);
    }
    
    public TeamSpinnerValueFactory(int initialValue) {
        super(4, 800, initialValue, 4);
    }
    
}
