package net.snortum.javafx.multiscenefxml;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.util.FxmlInfo;

/**
 * Sets all scene info into a Map and displays the main scene
 * 
 * @author Knute Snortum
 * @version 2018-05-24
 */
public class Main extends Application {
	
	private static final String MAIN_FXML = "/fxml/main-view.fxml";
	private static final String SCENE_ONE_FXML = "/fxml/scene-one.fxml";
	private static final String SCENE_TWO_FXML = "/fxml/scene-two.fxml";
	private static final String SCENE_THREE_FXML = "/fxml/scene-three.fxml";

	/** Holds the information for various scenes to switch between */
	private static Map<SceneName, FxmlInfo> scenes = new HashMap<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		
		scenes.put(SceneName.MAIN, new FxmlInfo(MAIN_FXML, SceneName.MAIN, stage));
		scenes.put(SceneName.SCENE1, new FxmlInfo(SCENE_ONE_FXML, SceneName.SCENE1, stage));
		scenes.put(SceneName.SCENE2, new FxmlInfo(SCENE_TWO_FXML, SceneName.SCENE2, stage));
		scenes.put(SceneName.SCENE3, new FxmlInfo(SCENE_THREE_FXML, SceneName.SCENE3, stage));
		
		// getScene() will load the FXML file the first time
		stage.setScene(scenes.get(SceneName.MAIN).getScene()); 
		stage.setTitle("Multi-Scene Demo");
		stage.show();
	}

	/** @return a Map of the {@link FxmlInfo} by {@link SceneName} */
	public static Map<SceneName, FxmlInfo> getScenes() {
		return scenes;
	}
	
	/**
	 * Update the scene Map with new FxmlInfo
	 * 
	 * @param name the {@link SceneName} that is the key to update
	 * @param info the {@link FxmlInfo} that is the data to update
	 */
	public static void updateScenes(SceneName name, FxmlInfo info) {
		scenes.put(name, info);
	}

}
