package testbench;

import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import java.util.Objects;

public class TestCPUDigitsOfPi extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/Bench_page.fxml"));
        primaryStage.setTitle("CPU Benchmark");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        /*
        bench.clean();
        log.close();
        System.out.println("Available processors (cores): " +
                Runtime.getRuntime().availableProcessors());


         */
        launch(args);
    }
}
