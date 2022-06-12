package LoggerAplication;

public class LoggerAplication {

    public static AbstractLogger chainOfResponsibility(){
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.consoleLogger);
        AbstractLogger warningLogger = new WarningLogger(AbstractLogger.warningLogger);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.errorLogger);



        consoleLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);

        return consoleLogger;
    }
    public static void main(String[] args) {
       AbstractLogger abstractLogger = chainOfResponsibility();

       abstractLogger.message(AbstractLogger.consoleLogger,"This is a console information.");
       abstractLogger.message(AbstractLogger.warningLogger,"This is a warning.");
       abstractLogger.message(AbstractLogger.errorLogger,"You have an error in your code...!");

    }
}
