package nLayeredProjectHomework.dataAccess.concretes;

import nLayeredProjectHomework.dataAccess.abstracts.CustomerDao;
import nLayeredProjectHomework.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {
    @Override
    public boolean signUp(Customer customer) {
        System.out.println("Hibernate ile kayıt olundu: " + customer.getFirstName());
        return true;
    }

    @Override
    public boolean logIn(Customer customer) {
        System.out.println("Hibernate ile giriş yapıldı: " + customer.getFirstName());
        return true;
    }

    @Override
    public Customer get(int id) {
        return null;
    }

    @Override
    public String getEmail(int id) {
        return null;
    }

    @Override
    public String getPassword(int id) {
        return null;
    }

    @Override
    public String getFirstName(int id) {
        return null;
    }

    @Override
    public String getLastName(int id) {
        return null;
    }

    @Override
    public boolean getIsVerified(int id) {
        return false;
    }
}
