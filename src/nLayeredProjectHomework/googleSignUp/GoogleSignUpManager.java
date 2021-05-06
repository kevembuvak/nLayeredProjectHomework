package nLayeredProjectHomework.googleSignUp;

import nLayeredProjectHomework.entities.concretes.Customer;

public class GoogleSignUpManager {
    public boolean signUpWithGoogle(Customer customer) {
        if (validate(customer)) {
            System.out.println("Google ile kayıt yapıldı");
            return true;
        }
        System.out.println("Google ile kayıt başarısız");
        return false;
    }

    private boolean validate(Customer customer) {
        return true;
    }
}
