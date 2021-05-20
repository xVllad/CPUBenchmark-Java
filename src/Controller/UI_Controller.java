package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class UI_Controller {

    public ChoiceBox<String> choicebox1;
    public Label label1;
    public Button bt;

    public void initialize()
    {
        choicebox1.getItems().addAll("2000", "4000","6000","8000","10000","15000","20000");
    }

    public void bt_start(ActionEvent actionEvent) {
        String str;
        str = choicebox1.getValue();
        label1.setText(str);
    }
}