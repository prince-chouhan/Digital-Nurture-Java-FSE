package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise7_OberverPattern;

public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp("Rishabh");
        Observer webApp = new WebApp("Admin");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        stockMarket.setStockPrice("Cognizant", 3850);
        System.out.println();
        stockMarket.setStockPrice("Cognizant", 3925);
    }
}
