package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise2_FactoryMethodPattern;

public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}