package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise1_SingletonPattern;

public class Logger {

    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
