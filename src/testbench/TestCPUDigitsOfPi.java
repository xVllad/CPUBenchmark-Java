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

public class TestCPUDigitsOfPi extends Application{
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;
        IBenchmark bench = new CPUDigitsOfPi();
        bench.initialize(4);
        bench.warmUp();
        timer.start();
        bench.run();
        long time = timer.stop();
        log.writeTime("Finished in",time,timeUnit);
        log.write(bench.getResult());

        bench.clean();
        log.close();
        System.out.println("Available processors (cores): " +
                Runtime.getRuntime().availableProcessors());

        String os = System.getProperty("os.name");
        String os_version = System.getProperty("os.version");
        String arch = System.getProperty("os.arch");
        System.out.println(os + " " + os_version + " " + arch);
        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Bench_page.fxml"));
        primaryStage.setTitle("CPU Benchmark");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
