package nLayeredProjectHomework.business.concretes;

import nLayeredProjectHomework.business.abstracts.CustomerService;
import nLayeredProjectHomework.core.SignUpService;
import nLayeredProjectHomework.dataAccess.abstracts.CustomerDao;
import nLayeredProjectHomework.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

    CustomerDao dao;
    SignUpService service;

    public CustomerManager(CustomerDao dao, SignUpService service) {
        this.dao = dao;
        this.service = service;
    }

    @Override
    public boolean signUp(Customer customer) {
        if (validateCustomer(customer)) {
            System.out.println("Kayıt olma işlemi başarılı");
            return dao.signUp(customer);
        }

        System.out.println("Kayıt olma işlemi başarısız");
        return false;
    }

    @Override
    public boolean logIn(Customer customer) {
        int id = customer.getId();

        if (dao.getEmail(id).equals(customer.getEmail()) && dao.getPassword(id).equals(customer.getPassword())) {
            System.out.println("Giriş yapma işlemi başarılı");
            return dao.logIn(customer);
        }

        System.out.println("Giriş yapma işlemi başarısız");
        return false;
    }

    private boolean validateCustomer(Customer customer) {
        // iş kuralları
        return true;
    }
}
