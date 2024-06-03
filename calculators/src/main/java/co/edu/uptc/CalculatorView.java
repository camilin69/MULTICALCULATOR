package co.edu.uptc;

import java.lang.reflect.Field;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
        System.out.println("NIGGAAAAA GRIDDYS");
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
        binaryStack.setStyle("-fx-background-color: " + ON_MOUSE_ENTERED_COLOR + "; -fx-background-radius: 50px;");
        binaryGrid.setVisible(true);
        octalStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + "; -fx-background-radius: 50px;");
        octalGrid.setVisible(false);
        hexaStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + "; -fx-background-radius: 50px;");
        hexaGrid.setVisible(false);
        operationField.setText(""); 
        resultField.setText("=");
    }


    @FXML
    void octalOp(MouseEvent event) {
        binaryStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + "; -fx-background-radius: 50px;");
        binaryGrid.setVisible(false);
        octalStack.setStyle("-fx-background-color: " + ON_MOUSE_ENTERED_COLOR + "; -fx-background-radius: 50px;");
        octalGrid.setVisible(true);
        hexaStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + "; -fx-background-radius: 50px;");
        hexaGrid.setVisible(false);
        operationField.setText(""); 
        resultField.setText("=");
    }
    
    @FXML
    void hexaOp(MouseEvent event) {
        binaryStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + "; -fx-background-radius: 50px;");
        binaryGrid.setVisible(false);
        octalStack.setStyle("-fx-background-color: " + ON_MOUSE_EXITED_COLOR + "; -fx-background-radius: 50px;");
        octalGrid.setVisible(false);
        hexaStack.setStyle("-fx-background-color: " + ON_MOUSE_ENTERED_COLOR + "; -fx-background-radius: 50px;");
        hexaGrid.setVisible(true);
        operationField.setText(""); 
        resultField.setText("=");
    }

    @FXML
    void addOperationField(MouseEvent event){
        StackPane stack = (StackPane) event.getSource();
        if(operationField.getText().length() < 44){
            operationField.setText(operationField.getText() + ((Label) stack.getChildren().get(1)).getText());
        }
    }

    @FXML
    void remove(MouseEvent event){
        if(operationField.getText().length() > 0){
            operationField.setText(operationField.getText().substring(0, operationField.getText().length() - 1));  
        }
    }

    @FXML
    void calculate(MouseEvent event){
        System.out.println("CALCULATING");
    }



}
