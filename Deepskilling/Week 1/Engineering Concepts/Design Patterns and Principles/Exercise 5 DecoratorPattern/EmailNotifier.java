package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise5_DecoratorPattern;

public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}
