package nLayeredProjectHomework.dataAccess.abstracts;

import nLayeredProjectHomework.entities.concretes.Customer;

public interface CustomerDao {
    boolean signUp(Customer customer);
    boolean logIn(Customer customer);
    Customer get(int id);
    String getEmail(int id);
    String getPassword(int id);
    String getFirstName(int id);
    String getLastName(int id);
    boolean getIsVerified(int id);

}
