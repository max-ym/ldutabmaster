package com.ldu.tabmaster.ui;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class JudgeSpinnerValueFactory extends IntegerSpinnerValueFactory {

    public JudgeSpinnerValueFactory() {
        super(1, 200);
    }
    
    public JudgeSpinnerValueFactory(int initialValue) {
        super(1, 200, initialValue);
    }

}
