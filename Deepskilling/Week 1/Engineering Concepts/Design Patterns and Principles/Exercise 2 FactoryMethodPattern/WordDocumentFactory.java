package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise2_FactoryMethodPattern;

public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}