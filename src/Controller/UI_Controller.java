package Controller;

import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class UI_Controller {

    public ChoiceBox<String> choicebox1;
    public Label label1;
    public Button bt;
    public ChoiceBox<String> choiceboxtest;

    public void initialize()
    {
        choicebox1.getItems().addAll("1000","2000", "4000","6000","8000","10000","15000","20000");
        choiceboxtest.getItems().addAll("1","10","25","50","100","1000");
        choiceboxtest.setValue("1");
        choicebox1.setValue("1000");
    }

    public void bt_start(ActionEvent actionEvent) {

        int str;
        str = Integer.parseInt(choicebox1.getValue());
        int tst = 1;
        tst = Integer.parseInt(choiceboxtest.getValue());
        long avgTime=0;
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Sec;
        IBenchmark bench = new CPUDigitsOfPi();
        bench.initialize(str);
        bench.warmUp();

        for(int i=0;i<tst;++i) {
            timer.start();
            bench.run();
            long time = timer.stop();
            avgTime = avgTime + time;

            log.writeTime("Finished in", time, timeUnit);
            System.out.println(i);
        }
        avgTime = avgTime/tst;


        label1.setText(String.valueOf(TimeUnit.toTimeUnit(avgTime,TimeUnit.Sec)));

    }
}