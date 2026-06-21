package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise7_OberverPattern;

public interface Stock {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
