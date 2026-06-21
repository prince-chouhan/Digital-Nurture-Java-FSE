package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise4_AdapterPattern;

public class StripeGateway {

    public void payAmount(double amount) {
        System.out.println("Payment of ₹" + amount + " processed through Stripe");
    }
}
