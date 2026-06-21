package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise1_SingletonPattern;

public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");

        System.out.println(logger1 == logger2);
        System.out.println(logger1.hashCode());
        System.out.println(logger2.hashCode());

        Printer p1 = Printer.getInstance();
        Printer p2 = Printer.getInstance();

        p1.print("Hello");
        p2.print("World");

        System.out.println(p1 == p2);
    }
}