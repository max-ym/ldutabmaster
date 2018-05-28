package com.ldu.tabmaster.ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateTournament {

    private final CreateTournamentCtrl ctrl;
    
    private Stage primaryStage;
    private Scene primaryScene;
    private HBox  rootLayout;
    
    private Spinner<Integer> motionNumber;
    private Spinner<Integer> teamNumber;
    private Spinner<Integer> judgeNumber;
    private Spinner<Integer> wingNumber;
    private Button           cancel;
    private Button           create;
    
    public void start() {
        primaryStage.setTitle("Create Tournament - LDU Tabmaster");
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "CreateTournament.fxml"));
            rootLayout = loader.load();
            primaryScene = new Scene(rootLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        motionNumber = (Spinner<Integer>) primaryScene.lookup("#motionNumber");
        teamNumber   = (Spinner<Integer>) primaryScene.lookup("#teamNumber");
        judgeNumber  = (Spinner<Integer>) primaryScene.lookup("#judgeNumber");
        wingNumber   = (Spinner<Integer>) primaryScene.lookup("#wingNumber");
        cancel       = (Button)  primaryScene.lookup("#cancel");
        create       = (Button)  primaryScene.lookup("#create");
        
        motionNumber.setValueFactory(new MotionValueSpinnerFactory());
        teamNumber.setValueFactory(new TeamValueSpinnerFactory());
        judgeNumber.setValueFactory(new JudgeValueSpinnerFactory());
        wingNumber.setValueFactory(new WingValueSpinnerFactory());
        
        cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                ctrl.cancel();
            }
            
        });
        
        create.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ctrl.create();
            }
            
        });
        
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    
    public CreateTournament(Stage primaryStage) {
        this.primaryStage = primaryStage;
        ctrl = new CreateTournamentCtrl(this);
    }
    
    public int judgeCount() {
        return judgeNumber.getValue().intValue();
    }
    
    public int teamCount() {
        return teamNumber.getValue().intValue();
    }
    
    public void showNotEnoughJudges() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(primaryStage);
        alert.initModality(Modality.APPLICATION_MODAL);
        
        alert.setContentText(
                "There are not enough judges to judge the rooms. "
                + "There are " + teamCount() + " teams and minimal required "
                + "number of judges is " + teamCount() / 4 + " but "
                + judgeCount() + " was set. To create the tournament correct"
                + " the number of teams or judges.");
        
        alert.setHeaderText("Invalid number of judges or teams");
        alert.setTitle("Tournament Settings Error");
        
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        
        alert.showAndWait();
    }
    
    public void closeView() {
        primaryStage.close();
    }

}
