package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise11_DependencyInjection;

import Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise11_DependencyInjection.impl.CustomerRepositoryImpl;

public class DependencyInjectionTest {

    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        System.out.println(customerService.getCustomer(101));
        System.out.println(customerService.getCustomer(102));
        System.out.println(customerService.getCustomer(103));
    }
}
