package com.ldu.tabmaster.ui;

import com.ldu.tabmaster.tab.Motion;

import javafx.scene.control.TableView;

public class MotionTable {

    private final TableView<Motion> view;
    
    public MotionTable(TableView<Motion> view) {
        this.view = view;
    }
    
    public TableView<Motion> view() {
        return view;
    }
    
}
