package nLayeredProjectHomework.business.concretes;

import nLayeredProjectHomework.business.abstracts.CustomerService;
import nLayeredProjectHomework.business.abstracts.VerificationService;
import nLayeredProjectHomework.core.SignUpService;
import nLayeredProjectHomework.dataAccess.abstracts.CustomerDao;
import nLayeredProjectHomework.entities.concretes.Customer;

import java.util.List;
import java.util.regex.Pattern;

public class CustomerManager implements CustomerService {

    CustomerDao dao;
    SignUpService signUpService;
    VerificationService verificationService;

    public CustomerManager(CustomerDao dao, SignUpService service, VerificationService verificationService) {
        this.dao = dao;
        this.signUpService = service;
        this.verificationService = verificationService;
    }

    @Override
    public boolean signUp(Customer customer) {
        if (checkEmail(customer) && checkName(customer) && checkPassword(customer)){
            System.out.println("Kayıt başarılı");
            return true;
        }

        System.out.println("Kayıt olma işlemi başarısız");
        return false;
    }

    @Override
    public boolean logIn(Customer customer) {
        int id = customer.getId();

        if (!customer.getIsVerified()) {
            System.out.println("Hesabınız doğrulanmamış. Lütfen doğrulayın");
            return false;
        }

        if (!(dao.getEmail(id).equals(customer.getEmail()) && dao.getPassword(id).equals(customer.getPassword()))) {
            System.out.println("Giriş yapma işlemi başarısız");
            return false;
        }

        System.out.println("Giriş yapma işlemi başarılı");
        return dao.logIn(customer);
    }

    private boolean checkPassword(Customer customer) {
        if (customer.getPassword().length() < 6) {
            System.out.println("Şifreniz 6 karakterden fazla olmalı");
            return false;
        }

        return false;
    }

    private boolean checkEmail(Customer customer) {
        if (!isValidEmail(customer.getEmail())) {
            System.out.println("Emailiniz email formatına uymuyor");
            return false;
        }

        List<Customer> customers = dao.getAll();

        for (Customer value : customers) {
            if (customer.getEmail().equals(value.getEmail())) {
                System.out.println("Bu email zaten kullanılmış");
                return false;
            }
        }

        return true;
    }

    private boolean checkName(Customer customer) {
        if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2) {
            System.out.println("Adınız ve soyadınız en az 2 karakter olmalı ");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            System.out.println("Email boş");
            return false;
        }
        return pat.matcher(email).matches();
    }
}
