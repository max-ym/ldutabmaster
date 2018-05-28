package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class WingSpinnerValueFactory extends IntegerSpinnerValueFactory {

    public WingSpinnerValueFactory() {
        super(0, 800);
    }
    
    public WingSpinnerValueFactory(int initialValue) {
        super(0, 800, initialValue);
    }
}
