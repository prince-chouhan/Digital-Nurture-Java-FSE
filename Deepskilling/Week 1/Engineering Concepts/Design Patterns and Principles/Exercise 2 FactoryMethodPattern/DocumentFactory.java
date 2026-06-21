package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise2_FactoryMethodPattern;


public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void openDocument() {
        Document document = createDocument();
        document.open();
    }
}