package bench;

import java.util.Random;

public class DemoSortingBenchmark implements IBenchmark {

    private int n;
    private int arr[];
    private boolean running;

    public void Initialize(Object ... params)
    {
        Random rand = new Random();
        this.n = (Integer) params[0];
        this.arr = new int[n];

        for(int i=0;i< n;i++)
        {
            arr[i] = rand.nextInt(1000);
        }
    }

    public void warmUp()
    {

    }

    public void run()
    {
        running = true;

        double x = 0;
        for(int i=0;i<n && running; i++)
        {
            x = Math.pow(1,1);
        }
    }

    public void run(Object ... objects)
    {
        throw new UnsupportedOperationException("Use run() instead");
    }

    public void cancel()
    {
        running = false;
    }

    public void clean()
    {

    }

    public void getResult()
    {

    }

}
