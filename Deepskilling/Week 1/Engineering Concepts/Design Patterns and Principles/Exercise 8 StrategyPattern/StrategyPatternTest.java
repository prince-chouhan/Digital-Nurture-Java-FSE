package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise8_StrategyPattern;

public class StrategyPatternTest {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext(new CreditCardPayment());

        context.makePayment(5000);
        context.setPaymentStrategy(new PayPalPayment());
        context.makePayment(3000);
    }
}