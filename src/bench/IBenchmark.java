package bench;

public interface IBenchmark {
    public void Initialize(Object ... params);

    public void warmUp();

    public void run();

    public void cancel();

    public void clean();

    public void getResult();

}
