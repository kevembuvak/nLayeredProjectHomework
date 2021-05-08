package nLayeredProjectHomework.business.abstracts;

import nLayeredProjectHomework.entities.concretes.Customer;

public interface VerificationService {
    boolean verify(Customer customer);
    boolean sendVerificationMail(Customer customer);
}
