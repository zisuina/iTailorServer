package hibernate.services;

import hibernate.community.Account;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AuthenticationService {
    Account account = null;
    String authenticate = "";

    public AuthenticationService(String email, String authenticate) {
//        this.account = AccountService.getAccountByEmail(email);
        this.authenticate = authenticate;
    }

    public boolean isValidAccount() {
        return account.isLogIn() && account.getAuthenticate().equals(authenticate);
    }
}
