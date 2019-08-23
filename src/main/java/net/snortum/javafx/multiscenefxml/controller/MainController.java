package net.snortum.javafx.multiscenefxml.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import net.snortum.javafx.multiscenefxml.SceneFxmlApp;
import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.Stageable;

/**
 * Pressing a button displays the different scenes.
 * 
 * @author Knute Snortum
 * @version 2018-05-24
 */
public class MainController implements Stageable {

	private Stage stage;
	
	/** Close application */
	@FXML private void handleOnActionClose(ActionEvent event) {
		stage.close();
	}

	/** Display the first scene */
	@FXML private void handleOnActionSceneOne(ActionEvent event) {
		stage.setScene(SceneFxmlApp.getScenes().get(SceneName.SCENE1).getScene());
	}
	
	/** Display the second scene */
	@FXML private void handleOnActionSceneTwo(ActionEvent event) {
		stage.setScene(SceneFxmlApp.getScenes().get(SceneName.SCENE2).getScene());
	}
	
	/** Display the third scene */
	@FXML private void handleOnActionSceneThree(ActionEvent event) {
		stage.setScene(SceneFxmlApp.getScenes().get(SceneName.SCENE3).getScene());
	}
	
	/** 
	 * Needed by the close button 
	 * 
	 * @param stage primary stage to set 
	 */
	@Override
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
