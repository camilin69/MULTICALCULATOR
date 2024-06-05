package co.edu.uptc.control;

import co.edu.uptc.model.Binary;
import co.edu.uptc.model.Expression;
import co.edu.uptc.model.Hexa;
import co.edu.uptc.model.Octal;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class CalculatorView {
    private String ON_MOUSE_ENTERED_COLOR = "#937bbc";
    private String ON_MOUSE_EXITED_COLOR = "#c5b8da";

    @FXML
    private AnchorPane griddys;

    @FXML
    private Label operationField;
    @FXML
    private Label resultField;
    
    @FXML
    private StackPane binaryStack;
    @FXML
    private StackPane octalStack;
    @FXML
    private StackPane hexaStack;

    @FXML
    private GridPane binaryGrid;
    @FXML
    private GridPane octalGrid;
    @FXML
    private GridPane hexaGrid;


    @FXML
    void griddysEffect(MouseEvent event) {
        for(Node grid: griddys.getChildren()){
            if(grid instanceof GridPane){
                for(Node stack : ((GridPane) grid).getChildren()){
                    if(stack instanceof StackPane){
                        highlightGrids((StackPane) stack);
                    }
                }
            }
        }
        griddys.setOnMouseEntered(null);
    }

    private void highlightGrids(StackPane n){
        Circle c = (Circle) n.getChildren().get(0);
        if(n.getChildren().get(1) instanceof Label){
            Label l = (Label) n.getChildren().get(1);
            l.setOnMouseEntered(e ->{
                c.setFill(Color.web(ON_MOUSE_ENTERED_COLOR));
            });
            l.setOnMouseExited(e ->{
                c.setFill(Color.web(ON_MOUSE_EXITED_COLOR));
            });
        }else if(n.getChildren().get(1) instanceof ImageView){
            ImageView iv = (ImageView) n.getChildren().get(1);
            iv.setOnMouseEntered(e ->{
                c.setFill(Color.web(ON_MOUSE_ENTERED_COLOR));
            });
            iv.setOnMouseExited(e ->{
                c.setFill(Color.web(ON_MOUSE_EXITED_COLOR));
            });
        }
        c.setOnMouseEntered(e ->{
            c.setFill(Color.web(ON_MOUSE_ENTERED_COLOR));
        });
        c.setOnMouseExited(e ->{
            c.setFill(Color.web(ON_MOUSE_EXITED_COLOR));
        });
    }


    @FXML
    void binaryOp(MouseEvent event) {
        binaryStack.setStyle("-fx-background-color: " + ON_MOUSE_ENTERED_COLOR + ";");
        binaryGrid.setVisible(true);
        octalStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + ";");
        octalGrid.setVisible(false);
        hexaStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + ";");
        hexaGrid.setVisible(false);
        operationField.setText(""); 
        resultField.setText("=");
    }


    @FXML
    void octalOp(MouseEvent event) {
        binaryStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + ";");
        binaryGrid.setVisible(false);
        octalStack.setStyle("-fx-background-color: " + ON_MOUSE_ENTERED_COLOR + ";");
        octalGrid.setVisible(true);
        hexaStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + ";");
        hexaGrid.setVisible(false);
        operationField.setText(""); 
        resultField.setText("=");
    }
    
    @FXML
    void hexaOp(MouseEvent event) {
        binaryStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + ";");
        binaryGrid.setVisible(false);
        octalStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + ";");
        octalGrid.setVisible(false);
        hexaStack.setStyle("-fx-background-color: " + ON_MOUSE_ENTERED_COLOR + ";");
        hexaGrid.setVisible(true);
        operationField.setText(""); 
        resultField.setText("=");
    }

    @FXML
    void addOperationField(MouseEvent event){
        StackPane stack = (StackPane) event.getSource();
        if(operationField.getText().length() >= 32 && operationField.getFont().getSize() > 30){
            operationField.setFont(new Font("Gill Sans MT", operationField.getFont().getSize() - 2));
        }
        
        if(operationField.getText().length() < 90){
            operationField.setText(operationField.getText() + ((Label) stack.getChildren().get(1)).getText());
        }

    }
//18 result
    @FXML
    void remove(MouseEvent event){
        if(operationField.getText().length() <= 40 && operationField.getFont().getSize() < 66){
            operationField.setFont(new Font("Gill Sans MT", operationField.getFont().getSize() + 2));
        }
        if(operationField.getText().length() > 0){
            operationField.setText(operationField.getText().substring(0, operationField.getText().length() - 1));  
        }
    }

    @FXML
    void calculate(MouseEvent event){
        Expression expression;
        if(binaryGrid.isVisible()){
            expression = new Binary();
        }else if(octalGrid.isVisible()){
            expression = new Octal();
        }else{
            expression = new Hexa();
        }
        try{
            resultField.setFont(new Font("Gill Sans MT", 60));
            String result = HandlingCalculator.evaluate(expression, operationField.getText());
            if(result.length() > 18 && result.length() < 30 ){
                resultField.setFont(new Font("Gill Sans MT", 40));
            }else if(result.length() >= 30 && result.length() < 50 ){
                resultField.setFont(new Font("Gill Sans MT", 30));
            }else if(result.length() >= 50 && result.length() < 70 ){
                resultField.setFont(new Font("Gill Sans MT", 20));
            }else if(result.length() >= 70 && result.length() < 100 ){
                resultField.setFont(new Font("Gill Sans MT", 15));
            }
            resultField.setText("= " + result);
            
        }catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); 
            operationField.setStyle("-fx-background-color: #ff8b8b;");
            Timeline error = new Timeline(new KeyFrame(Duration.millis(250), k ->{
                operationField.setStyle("-fx-background-color: transparent;");
            }));
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(250), operationField);
            fadeTransition.setFromValue(1); 
            fadeTransition.setToValue(0);   
            fadeTransition.setAutoReverse(true); 
            fadeTransition.setCycleCount(2); 
            TranslateTransition earthquake = new TranslateTransition(Duration.millis(5), operationField);
            earthquake.setByX(3);
            earthquake.setFromX(0);
            earthquake.setAutoReverse(true);
            earthquake.setCycleCount(100);
            earthquake.play();
            error.play();
            fadeTransition.play();
        }
    }
}
