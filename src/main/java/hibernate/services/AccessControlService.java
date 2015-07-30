package hibernate.services;

import exception.HibernateFailException;
import hibernate.community.AccessControl;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccessControlService {
    private AccessControl[] accessControls = {
            new AccessControl(1, true, true),
            new AccessControl(2, true, false),
            new AccessControl(3, false, true),
            new AccessControl(4, false, false)
    };

    HibernateServiceInterface hibernateService = (session) -> {
        session.createSQLQuery("delete from access_control").executeUpdate();
        for (int i = 0; i < accessControls.length; i++) {
            session.persist(accessControls[i]);
        }
    };

    public void settleIntoDB() throws HibernateFailException {
        if (!this.hibernateService.doHibernate())
            throw new HibernateFailException();
    }

    public AccessControl getSpecificAccessControl(boolean receive, boolean send) {
        for (int i = 0; i < accessControls.length; i++) {
            if (receive == accessControls[i].isReceive() && send == accessControls[i].isSend()) {
                return accessControls[i];
            }
        }
        return accessControls[0];
    }


}
