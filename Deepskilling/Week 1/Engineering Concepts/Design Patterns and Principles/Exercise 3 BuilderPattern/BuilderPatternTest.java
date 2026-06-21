package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise3_BuilderPattern;

public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer gamingPc = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam(32)
                .setStorage(1000)
                .setGpu("RTX 4090")
                .build();

        Computer officePc = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam(16)
                .setStorage(512)
                .build();

        System.out.println(gamingPc);
        System.out.println(officePc);
    }
}
