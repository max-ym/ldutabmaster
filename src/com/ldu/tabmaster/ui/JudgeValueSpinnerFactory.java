package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class JudgeValueSpinnerFactory extends IntegerSpinnerValueFactory {

    public JudgeValueSpinnerFactory() {
        super(1, 200);
    }

}
