package hibernate.services;

import hibernate.community.Account;
import hibernate.recommendation.Body;
import hibernate.recommendation.BodyStatus;
import org.apache.log4j.Logger;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
public class BodyManagementForNotNullAccountService {

    Body body = null;
    Account account = null;
    Logger logger = Logger.getLogger(BodyManagementForNotNullAccountService.class);

    public BodyManagementForNotNullAccountService(Account account) {
        this.account = account;
        this.body = account.getUser().getBody();
    }

    public void addNotNullBodyStatusTo(BodyStatus bodyStatus) {
        logger.debug("Add BodyStatus for account:" + account.getEmail());
        body.getBodyStatusList().add(bodyStatus);
    }

    public BodyStatus findLatestBodyStatus() {
        logger.debug("findLatestBodyStatusFromAccount:" + account.getEmail());
        body.getBodyStatusList().sort((BodyStatus oneBodyStatus, BodyStatus anotherBodyStatus) ->
                oneBodyStatus.getTimestamp().compareTo(anotherBodyStatus.getTimestamp())
        );
        return body.getBodyStatusList().get(0);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
