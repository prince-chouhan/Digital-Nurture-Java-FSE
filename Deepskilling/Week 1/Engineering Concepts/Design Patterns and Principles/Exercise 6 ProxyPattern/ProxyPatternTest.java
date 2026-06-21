package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise6_ProxyPattern;

public class ProxyPatternTest {

    public static void main(String[] args) {

        Image image1 = new ProxyImage("profile.jpg");
        System.out.println("Image object created");

        image1.display();
        System.out.println();
        image1.display();
    }
}
