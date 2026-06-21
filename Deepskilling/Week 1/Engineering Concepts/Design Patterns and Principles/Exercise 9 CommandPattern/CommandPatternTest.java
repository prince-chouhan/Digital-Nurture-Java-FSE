package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise9CommandPattern;

public class CommandPatternTest {

    public static void main(String[] args) {

        Light light = new Light();

        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();
    }
}
