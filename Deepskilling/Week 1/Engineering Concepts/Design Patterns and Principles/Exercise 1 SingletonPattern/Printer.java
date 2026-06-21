package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise1_SingletonPattern;

public class Printer {

    private static Printer instance;

    private Printer() {
        System.out.println("Printer Created");
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void print(String message) {
        System.out.println("Printing: " + message);
    }
}