package testbench;
import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUDigitsOfPi {
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
    }
}
