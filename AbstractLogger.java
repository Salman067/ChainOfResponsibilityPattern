package LoggerAplication;

public abstract class AbstractLogger {
    public static int consoleLogger = 1;
    public static  int warningLogger = 2;
    public static int errorLogger = 3;


    protected  int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger (AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void  message(int level,String message){
        if (this.level<=level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.message(level, message);
        }
    }

    abstract protected void write(String message) ;
}
