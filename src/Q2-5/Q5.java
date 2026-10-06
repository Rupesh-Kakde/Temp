class LoggerService {

    private static LoggerService instance;

    private LoggerService() {
    }

    public static synchronized LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Q5 {
    public static void main(String[] args) {
        LoggerService logger1 = LoggerService.getInstance();
        LoggerService logger2 = LoggerService.getInstance();

        logger1.log("Application started");
        System.out.println("Same instance: " + (logger1 == logger2));
    }
}
