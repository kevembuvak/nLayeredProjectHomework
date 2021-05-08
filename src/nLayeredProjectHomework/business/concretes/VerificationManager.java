package nLayeredProjectHomework.business.concretes;

import nLayeredProjectHomework.business.abstracts.VerificationService;
import nLayeredProjectHomework.entities.concretes.Customer;

public class VerificationManager implements VerificationService {
    @Override
    public boolean verify(Customer customer) {
        System.out.println("Link tıklanıldı");
        customer.setIsVerified(true);
        return true;
    }

    @Override
    public boolean sendVerificationMail(Customer customer) {
        System.out.println("Doğrulama maili gönderildi linke tıklayın: " + customer.getEmail());
        return true;
    }
}
