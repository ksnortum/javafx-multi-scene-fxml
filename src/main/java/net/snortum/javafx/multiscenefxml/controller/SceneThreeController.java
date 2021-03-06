package net.snortum.javafx.multiscenefxml.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import net.snortum.javafx.multiscenefxml.SceneFxmlApp;
import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.Stageable;

/**
 * Controller for Scene Three.  Handles close and back to main buttons.
 * 
 * @author Knute Snortum
 * @version 2018-06-11
 */
public class SceneThreeController implements Stageable {
	private Stage stage;

	/** Close application */
	@FXML private void handleOnActionClose(ActionEvent event) {
		stage.close();
	}
	
	/** Back to the main scene */
	@FXML private void handleOnActionBackButton(ActionEvent event) {
		stage.setScene(SceneFxmlApp.getScenes().get(SceneName.MAIN).getScene());
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
