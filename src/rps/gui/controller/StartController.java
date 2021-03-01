package rps.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StartController {
    public void startGame(ActionEvent ae) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/GameView.fxml"));
            Stage thisStage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            thisStage.setScene(new Scene(root));
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
    }
}
