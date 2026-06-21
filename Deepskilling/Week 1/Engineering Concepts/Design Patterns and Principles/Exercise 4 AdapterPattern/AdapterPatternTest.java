package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise4_AdapterPattern;

public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor payPal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        payPal.processPayment(1000);

        stripe.processPayment(2500);
    }
}
