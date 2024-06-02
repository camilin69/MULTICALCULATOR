package co.edu.uptc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import co.edu.uptc.Hexa;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        Hexa h = new Hexa();
        String a = "2FFFF";
        String b = "321";
        System.out.println("División: " + h.division(a, b));
    }

}