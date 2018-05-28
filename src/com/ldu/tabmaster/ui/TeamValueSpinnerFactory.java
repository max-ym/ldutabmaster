package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

class TeamValueSpinnerFactory extends IntegerSpinnerValueFactory {
    
    public TeamValueSpinnerFactory() {
        // Limit team number from 4 to 800.
        super(4, 800);
        this.setAmountToStepBy(4);
    }
    
}
