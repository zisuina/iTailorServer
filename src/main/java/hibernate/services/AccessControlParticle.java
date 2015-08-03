package hibernate.services;

import hibernate.community.AccessControl;
import hibernate.community.Account;

/**
 * Created by liker on 03/08/2015 0003.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccessControlParticle {
    private AccessControl accessControl;
    private Account account;

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccessControlParticle(AccessControl accessControl, Account account) {
        this.accessControl = accessControl;
        this.account = account;
    }
}
