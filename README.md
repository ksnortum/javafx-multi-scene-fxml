# javafx-multi-scene-fxml
**javafx-multi-scene-fxml** is a demonstration how you can use one stage and many scenes when building a JavaFX application using FXML files.  The graphics are very simple, as the point of the demo is how to move from one to the other.  

## Intro
**javafx-multi-scene-fxml** uses a static Map in `SceneFxmlApp` with `FxmlInfo` as the value and the `SceneName` as the key.  `SceneName` is an Enum with the name of each Scene.  `FxmlInfo` is a class that holds all the data needed to load an FXML file into a Scene and holds that Scene once it's loaded.

Scenes are loaded lazily, that is, only when needed.  A Scene is built the first, then all subsequent calls load the built Scene.

The Stage is injected from `SceneFxmlApp` into each View and from there into each controller.  This combination of `FxmlInfo` Map and Stage provides all the control needed for each Scene.

## Requirements
**javafx-multi-scene-fxml** runs on Java 11 or above.  If you want to run on a version of Java lower that 11, checkout the `pre-javafx-11` branch (However, this branch is beginning to diverge).

## Launching
Launch **javafx-multi-scene-fxml** with [Maven](https://maven.apache.org/):

    mvn clean compile exec:java

Launching from an IDE can be tricky.  You will have to add the VM arguments

    --module-path /path/to/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml

to `SceneFxmlAppLauncher` or launch `SceneFxmlApp` directly. See [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/).

## What to notice
When the application launches, you are see the main view, with buttons for three separate scenes and a close button.  Press a scene button and you will go to one of three different scenes.  Each scene also has a close button, which is possible because the stage from `SceneFxmlApp` is injected into each.  On the console you can see that each scene is loaded only once and only when needed.

## Bugs, improvements
Fork the repository and submit a pull request, or email knute (at) snortum (dot) net.

## See Also
[Multi-scene demo](https://github.com/ksnortum/javafx-multi-scene) without FXML files.