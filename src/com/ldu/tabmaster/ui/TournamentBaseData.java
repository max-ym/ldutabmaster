package com.ldu.tabmaster.ui;

import java.io.IOException;
import java.util.LinkedList;

import com.ldu.tabmaster.tab.Motion;
import com.ldu.tabmaster.tab.elements.Judge;
import com.ldu.tabmaster.tab.elements.Team;
import com.ldu.tabmaster.tab.elements.Wing;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TournamentBaseData {
    
    private final TournamentBaseDataCtrl ctrl;
    
    private Stage stage;
    private VBox rootLayout;
    
    private Spinner<Integer> motionNumberSpn;
    private Spinner<Integer> teamNumberSpn;
    private Spinner<Integer> judgeNumberSpn;
    private Spinner<Integer> wingNumberSpn;
    
    private Label motionAmountLbl;
    private Label wingAmountLbl;
    private Label judgeAmountLbl;
    private Label teamAmountLbl;
    
    TableView<Motion> motionTable;
    TableView<Team> teamTable;
    TableView<Judge> judgeTable;
    TableView<Wing> wingTable;
    
    public TournamentBaseData(Stage stage, int judges, int wings, int motions,
            int teams) {
        this.stage = stage;
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("TournamentBaseData.fxml"));
        try {
            rootLayout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(rootLayout);
        stage.setScene(scene);

        Button applySettingsBtn  = (Button) scene.lookup("#applySettingsBtn");
        Button revertSettingsBtn = (Button) scene.lookup("#revertSettingsBtn");
        Button revertAllBtn      = (Button) scene.lookup("#revertAllBtn");
        Button saveBtn           = (Button) scene.lookup("#saveBtn");
        motionNumberSpn = (Spinner<Integer>) scene.lookup("#motionNumberSpn");
        teamNumberSpn   = (Spinner<Integer>) scene.lookup("#teamNumberSpn");
        judgeNumberSpn  = (Spinner<Integer>) scene.lookup("#judgeNumberSpn");
        wingNumberSpn   = (Spinner<Integer>) scene.lookup("#wingNumberSpn");
        motionAmountLbl = (Label) scene.lookup("#motionAmountLbl");
        wingAmountLbl   = (Label) scene.lookup("#wingAmountLbl");
        judgeAmountLbl  = (Label) scene.lookup("#judgeAmountLbl");
        teamAmountLbl   = (Label) scene.lookup("#teamAmountLbl");
        motionTable     = (TableView<Motion>) scene.lookup("#motionTable");
        teamTable       = (TableView<Team>)   scene.lookup("#teamTable");
        judgeTable      = (TableView<Judge>)  scene.lookup("#judgeTable");
        wingTable       = (TableView<Wing>)   scene.lookup("#wingTable");
        
        motionNumberSpn.setValueFactory(new MotionSpinnerValueFactory(
                motions));
        teamNumberSpn.setValueFactory(new TeamSpinnerValueFactory(teams));
        judgeNumberSpn.setValueFactory(new JudgeSpinnerValueFactory(judges));
        wingNumberSpn.setValueFactory(new WingSpinnerValueFactory(wings));
        
        motionTable.setItems(FXCollections.observableList(
                new LinkedList<Motion>()));
        teamTable.setItems(FXCollections.observableList(
                new LinkedList<Team>()));
        judgeTable.setItems(FXCollections.observableList(
                new LinkedList<Judge>()));
        wingTable.setItems(FXCollections.observableList(
                new LinkedList<Wing>()));
        
        updateAllInfoLabels();
        
        ctrl = new TournamentBaseDataCtrl(this);
    }
    
    public void updateMotionAmountLabel() {
        Label label = motionAmountLbl;
        label.setText("Contain " + enteredMotionCount() + " motions of "
                + expectedMotionCount() + " expected.");
    }
    
    public void updateTeamAmountLabel() {
        Label label = teamAmountLbl;
        label.setText("Contain " + enteredTeamCount() + " teams of "
                + expectedTeamCount() + " expected.");
    }
    
    public void updateJudgeAmountLabel() {
        Label label = judgeAmountLbl;
        label.setText("Contain " + enteredJudgeCount() + " judges of "
                + expectedJudgeCount() + " expected.");
    }
    
    public void updateWingAmountLabel() {
        Label label = wingAmountLbl;
        label.setText("Contain " + enteredWingCount() + " wings of "
                + expectedWingCount() + " expected.");
    }
    
    public void updateAllInfoLabels() {
        updateMotionAmountLabel();
        updateTeamAmountLabel();
        updateJudgeAmountLabel();
        updateWingAmountLabel();
    }
    
    public int enteredMotionCount() {
        return 0;
    }
    
    public int enteredTeamCount() {
        return 0;
    }

    public int enteredJudgeCount() {
        return 0;
    }
    
    public int enteredWingCount() {
        return 0;
    }
    
    public int expectedMotionCount() {
        return motionNumberSpn.getValue().intValue();
    }
    
    public int expectedTeamCount() {
        return teamNumberSpn.getValue().intValue();
    }
    
    public int expectedJudgeCount() {
        return judgeNumberSpn.getValue().intValue();
    }
    
    public int expectedWingCount() {
        return wingNumberSpn.getValue().intValue();
    }
    
}
