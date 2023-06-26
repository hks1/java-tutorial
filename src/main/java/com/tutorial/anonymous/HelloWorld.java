package com.tutorial.anonymous;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;



// https://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.htm

public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("Say 'Hello'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello!!");
            }
        });

        // lambda equivalent of above anonymous class expression
        // btn.setOnAction(actionEvent -> System.out.println("Hello!!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello!!");
        primaryStage.show();
    }
}
