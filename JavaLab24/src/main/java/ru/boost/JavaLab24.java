package ru.boost;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;

public class JavaLab24 extends Application {

    private Image getMainIcon(){
        InputStream iconStream = getClass().getResourceAsStream("/ru/boost/icon32.png");
        return new Image(iconStream);
    }

    private EpicBattle loadModel(MainSceneController controller){
        EpicBattle battle = new EpicBattle(controller);
        return battle;
    }

    private MainSceneController startView(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/ru/boost/mainScene.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        MainSceneController controller = loader.getController();
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(getMainIcon());
        primaryStage.setTitle("JavaLab24 Epic Battle");
        primaryStage.setOnCloseRequest(event -> {
            controller.stopBattle();
            Platform.exit();
        });
        primaryStage.show();

        return controller;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainSceneController viewController = startView(primaryStage);
        EpicBattle modelController = loadModel(viewController);
        viewController.setBattle(modelController);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
