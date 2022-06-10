package com.example.gamecollision;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 500);

        ImageView ship = createShip(scene);
        ImageView cloud = createCloud(scene);
        ImageView cloud2 = createCloud2(scene);
        root.getChildren().addAll(ship, cloud, cloud2);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = ship.getX();
            double y = ship.getY();

            switch (event.getCode()){
                case RIGHT -> ship.setX(x + 10);
                case LEFT -> ship.setX(x - 10);
                case UP -> ship.setY(y - 10);
                case DOWN -> ship.setY(y + 10);
            }
        });

        stage.setTitle("Collision Detection Game");
        stage.setScene(scene);
        stage.show();
    }

    private ImageView createShip(Scene scene) {
        int radius = 40;
        ImageView image = new ImageView(new Image("ship.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());

        return image;
    }
    private ImageView createCloud(Scene scene) {
        ImageView image1 = new ImageView(new Image("Cloud-001.jpg"));
        image1.setFitWidth(150);
        image1.setFitHeight(150);


        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), image1);
        int radius = 40;
        tt.setByX(scene.getWidth() - (radius * -14));
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.setAutoReverse(true);
        tt.play();

        return image1;
    }
    private ImageView createCloud2(Scene scene) {
        ImageView image2 = new ImageView(new Image("Cloud-001.jpg"));
        image2.setFitWidth(200);
        image2.setFitHeight(200);
        image2.setY(scene.getHeight() - image2.getFitHeight());

        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), image2);
        int radius = 40;
        tt.setByX(scene.getWidth() - (radius * 2));
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.setAutoReverse(true);
        tt.play();

        return image2;
    }
    public void checkCollision(){


    }

    public static void main(String[] args) {
        launch();
    }
}