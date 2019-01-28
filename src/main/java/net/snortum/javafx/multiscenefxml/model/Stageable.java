package net.snortum.javafx.multiscenefxml.model;

import javafx.stage.Stage;

/**
 * Marks the ability of a controller to set a stage.
 * 
 * @author Knute Snortum
 * @version 2018-05-29
 */
public interface Stageable {
	
	/** @param stage the stage to set */
	void setStage(Stage stage);
}
