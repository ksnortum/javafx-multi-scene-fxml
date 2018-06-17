package net.snortum.javafx.multiscenefxml.util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import org.apache.log4j.Logger;

import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.Stageable;

/**
 * Deals with loading FXML files and updating the scenes MAP in {@link Main}.
 * 
 * @author Knute Snortum
 * @version 2018-06-06
 */
public class FxmlLoad {
	
	private static Logger LOG = Logger.getLogger(FxmlLoad.class);

	/**
	 * Either builds the scene from {@link FxmlInfo} or loads the built scene.<br>
	 * <br>
	 * Uses this class's ClassLoader to find the URL of the FXML file.  If the URL 
	 * is {@code null} then the FXML file could not be found.
	 * 
	 * @param fxmlInfo the FXML file info to load the scene with
	 * @return the built scene, or {@code null} if there was an error
	 */
	public Scene load(FxmlInfo fxmlInfo) {
		
		if (fxmlInfo.hasScene()) {
			return fxmlInfo.getScene();
		}

		URL url = getClass().getResource(fxmlInfo.getResourceName());

		if (url == null) {
			String message = "The URL for the resource \""
					+ fxmlInfo.getResourceName()
					+ "\" was not found";
			LOG.error(message);
			debugInfo(fxmlInfo.getResourceName()); // not required
			Platform.exit();
			return null;
		}

		FXMLLoader loader = new FXMLLoader(url);
		Scene scene;

		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
			Platform.exit();
			return null;
		}
		
		// Write back the updated FxmlInfo to the scenes Map in Main
		fxmlInfo.setScene(scene);
		Main.updateScenes(fxmlInfo.getSceneName(), fxmlInfo);
		
		Stageable controller = loader.getController();
		if (controller != null) {
			controller.setStage(fxmlInfo.getStage());
		}
		
		return scene;
	}

	// This method isn't required, but it can help figure out why an FXML file isn't loading
	private void debugInfo(String resourceName) {
		LOG.error("Working Directory = " + System.getProperty("user.dir"));
		LOG.error("Resources for " + resourceName);
		try {
			Enumeration<URL> urls = ClassLoader.getSystemClassLoader().getResources(resourceName);
			while (urls.hasMoreElements()) {
				LOG.error(urls.nextElement());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
