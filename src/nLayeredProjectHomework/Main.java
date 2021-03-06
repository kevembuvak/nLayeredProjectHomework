package nLayeredProjectHomework;

import nLayeredProjectHomework.business.abstracts.CustomerService;
import nLayeredProjectHomework.business.concretes.CustomerManager;
import nLayeredProjectHomework.business.concretes.VerificationManager;
import nLayeredProjectHomework.core.GoogleSignUpManagerAdapter;
import nLayeredProjectHomework.dataAccess.concretes.HibernateCustomerDao;
import nLayeredProjectHomework.entities.concretes.Customer;

public class Main {

    public static void main(String[] args) {
        CustomerService manager = new CustomerManager(new HibernateCustomerDao(), new GoogleSignUpManagerAdapter(), new VerificationManager());
        manager.signUp(new Customer());
    }
}
