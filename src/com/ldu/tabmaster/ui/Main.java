package com.ldu.tabmaster.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private MainCtrl ctrl;
    
    private Stage primaryStage;
    private VBox rootLayout;
    
    private Button createButton;
    private Button openButton;
    
    private final String idCreateTournament = "#createTournament";
    private final String idOpenTournament = "#openTournament";
    
	@Override
	public void start(Stage primaryStage) {
	    ctrl = new MainCtrl(this);
	    
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LDU Tabmaster");
		
		initRootLayout();
	}
	
	private void initRootLayout() {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("Initial.fxml"));
	        rootLayout = loader.load();
	        
	        Scene scene = new Scene(rootLayout);
	        
	        createButton = (Button) scene.lookup(idCreateTournament);
            openButton = (Button) scene.lookup(idOpenTournament);
            
            createButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent arg0) {
                    ctrl.createTournament();
                }
                
            });
            
            openButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    ctrl.openTournament();
                }
                
            });
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void closeWindow() {
	    primaryStage.close();
	}
	
	public Stage getPrimaryStage() {
	    return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
