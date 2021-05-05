package logging;

public interface ILog {

    public void write (long);

    public void write (String);

    public void write (Object ... values);

    public void close();

}
