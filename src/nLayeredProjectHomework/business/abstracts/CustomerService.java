package nLayeredProjectHomework.business.abstracts;

import nLayeredProjectHomework.entities.concretes.Customer;

public interface CustomerService {
    boolean signUp(Customer customer);
    boolean logIn(Customer customer);
}
