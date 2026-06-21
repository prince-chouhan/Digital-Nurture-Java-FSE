package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise5_DecoratorPattern;

public class DecoratorPatternTest {

    public static void main(String[] args) {

        Notifier notifier = new SlackNotifierDecorator(new SMSNotifierDecorator(
                                new EmailNotifier()));

        notifier.send("Order Placed Successfully");
    }
}
