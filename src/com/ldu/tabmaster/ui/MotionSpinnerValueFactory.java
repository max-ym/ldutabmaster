package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class MotionSpinnerValueFactory extends IntegerSpinnerValueFactory {

    public MotionSpinnerValueFactory() {
        super(1, 100);
    }
    
    public MotionSpinnerValueFactory(int initialValue) {
        super(1, 100, initialValue);
    }

}
