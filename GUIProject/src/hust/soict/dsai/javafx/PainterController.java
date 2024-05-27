package GUIProject.src.hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
public class PainterController {
    private Color currentColor = Color.BLACK;

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private void clearButtonPressed(ActionEvent event)
    {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    private void drawingAreaMouseDragged(MouseEvent event)
    {
        Circle newCircle = new Circle(event.getX(),event.getY(),4,currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    private void onEraserPress(MouseEvent event)
    {
        currentColor = Color.WHITE;
    }
    @FXML
    private void onPenPressed(MouseEvent event)
    {
        currentColor = Color.BLACK;
    }
}
