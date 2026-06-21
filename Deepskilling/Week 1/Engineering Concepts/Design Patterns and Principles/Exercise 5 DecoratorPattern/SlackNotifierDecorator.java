package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise5_DecoratorPattern;

public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Slack Notification: " + message);
    }
}
