package nLayeredProjectHomework.core;

import nLayeredProjectHomework.entities.concretes.Customer;
import nLayeredProjectHomework.googleSignUp.GoogleSignUpManager;

public class GoogleSignUpManagerAdapter implements SignUpService{
    @Override
    public boolean signUpUsingGoogle(Customer customer) {
        GoogleSignUpManager manager = new GoogleSignUpManager();

        return manager.signUpWithGoogle(customer);
    }
}
