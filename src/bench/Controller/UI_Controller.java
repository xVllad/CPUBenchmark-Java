package bench.Controller;

import javafx.scene.control.ChoiceBox;

public class UI_Controller {

    public ChoiceBox<String> choicebox1;

    public void initialize()
    {
        choicebox1.getItems().addAll("2000", "4000","6000","8000","10000","15000","20000");
    }


}
