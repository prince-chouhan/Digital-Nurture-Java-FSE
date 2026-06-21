package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise10_MVCPattern;

import Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise10_MVCPattern.controller.StudentController;
import Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise10_MVCPattern.model.Student;
import Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise10_MVCPattern.view.StudentView;

public class MVCPatternDriver {

    public static void main(String[] args) {

        Student student = new Student("Rishabh", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        System.out.println();
        controller.setStudentName("Rishabh Dubey");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}