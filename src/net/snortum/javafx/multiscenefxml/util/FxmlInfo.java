package net.snortum.javafx.multiscenefxml.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

import net.snortum.javafx.multiscenefxml.model.SceneName;

/**
 * Holds FXML information:<br>
 * <ul>
 *   <li>the resource name for the FXML file</li>
 *   <li>the {@link SceneName}</li>
 *   <li>the primary stage, if needed by the controller</li>
 *   <li>the scene for this FXML, iff it has been loaded and set</li>
 * </ul>
 * 
 * The scenes are loaded lazily, that is, only the first time they are called.
 * After that, the loaded scene is looked and returned.
 * 
 * @author Knute Snortum
 * @version 2018-05-28
 */
public class FxmlInfo {
	
	private static Logger LOG = Logger.getLogger(FxmlInfo.class);
	
	private String resourceName;
	private SceneName sceneName;
	private Stage stage;
	private Scene scene;
	
	/**
	 * Construct an FxmlInfo object
	 * 
	 * @param resourceName the resource name for this FXML
	 * @param sceneName the {@link SceneName} for this FXML
	 * @param stage the primary stage that the scene will be set to
	 */
	public FxmlInfo(String resourceName, SceneName sceneName, Stage stage) {
		this.resourceName = resourceName;
		this.sceneName = sceneName;
		this.stage = stage;
	}
	
	/** @return the resource name for this FXML file */
	public String getResourceName() {
		return resourceName;
	}
	
	/** @return the {@link SceneName} for this FXML file */
	public SceneName getSceneName() {
		return sceneName;
	}
	
	/** @param scene the scene to set, loaded from this FxmlInfo */
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * Builds the scene iff {@code scene} is {@code null}.  Then it returns the scene to the caller.
	 * 
	 *  @return the scene 
	 */
	public Scene getScene() {
		if (scene == null) {
			scene = new FxmlLoad().load(this);
			if (LOG.isInfoEnabled()) {
				LOG.info(sceneName + " has been built");
			}
		}
		return scene;
	}
	
	/** @return {@code true} if the scene has been built, otherwise {@code false} */
	public boolean hasScene() {
		return scene != null;
	}
	
	/** @return the primary stage for this Scene */
	public Stage getStage() {
		return stage;
	}
	
}
