package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise11_DependencyInjection.impl;

import Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise11_DependencyInjection.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        if (id == 101) {
            return "Rishabh Dubey";
        }
        if (id == 102) {
            return "Rahul Sharma";
        }
        return "Customer Not Found";
    }
}
