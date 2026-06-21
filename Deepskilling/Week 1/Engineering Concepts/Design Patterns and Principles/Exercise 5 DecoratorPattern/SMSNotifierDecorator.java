package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise5_DecoratorPattern;

public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notification: " + message);
    }
}