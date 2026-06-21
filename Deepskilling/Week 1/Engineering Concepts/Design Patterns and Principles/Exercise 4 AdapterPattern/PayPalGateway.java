package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise4_AdapterPattern;

public class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed through PayPal");
    }
}
