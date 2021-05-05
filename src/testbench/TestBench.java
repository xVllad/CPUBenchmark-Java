package testbench;

import bench.DemoSortingBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class TestBench {

    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new DemoSortingBenchmark();

        int n = 3000;
        bench.Initialize(n);
        timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished in",time,"ns");
        log.close();
        bench.clean();

    }



}
