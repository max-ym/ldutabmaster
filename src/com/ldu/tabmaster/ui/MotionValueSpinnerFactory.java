package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class MotionValueSpinnerFactory extends IntegerSpinnerValueFactory {

    public MotionValueSpinnerFactory() {
        super(1, 100);
    }

}
