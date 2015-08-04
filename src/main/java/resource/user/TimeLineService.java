package resource.user;

import hibernate.community.Account;
import hibernate.community.Group;
import hibernate.services.AccessControlParticle;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TimeLineService {
    private List<AccessControlParticle> accessControlParticleList;
    private Account account;

    private void findToBeOrNotToBe() {
        accessControlParticleList =
                account.getRootGroup().getAccountList()
                        .stream().map(
                        ref -> new AccessControlParticle(
                                account.getRootGroup().getAccessControl(), ref))
                        .collect(Collectors.toList());
        for (Group group : account.getGroups()) {
            accessControlParticleList.addAll(
                    group.getAccountList().stream().map(
                            ref -> new AccessControlParticle(
                                    group.getAccessControl(), ref))
                            .collect(Collectors.toList()));
        }
    }

    /**
     * @param sendAccount
     * @param receiveAccount
     * @return 测试是否能能把ShareItem推送给对方
     */
    public boolean isPushAccepted(Account sendAccount, Account receiveAccount) {
        List<Account> sendList = this.getSendAccountList();
        if (sendList.contains(receiveAccount)) {
            List<Account> receiveList = new TimeLineService(receiveAccount).getReceiveAccountList();
            if (receiveList.contains(sendAccount)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return 推送消息给这些名单，但不知道会不会被拒绝
     */
    public List<Account> getSendAccountList() {
        findToBeOrNotToBe();
        List<Account> result = accessControlParticleList.stream()
                .filter(accessControlParticle -> accessControlParticle
                        .getAccessControl().isSend())
                .map(AccessControlParticle::getAccount)
                .collect(Collectors.toList());
        return result;
    }

    /**
     * @return 允许接受消息的名单列表，但不知道他们会不会发送给我
     */
    public List<Account> getReceiveAccountList() {
        findToBeOrNotToBe();
        List<Account> result = accessControlParticleList.stream()
                .filter(accessControlParticle -> accessControlParticle
                        .getAccessControl().isReceive())
                .map(AccessControlParticle::getAccount)
                .collect(Collectors.toList());
        return result;
    }

    public TimeLineService(Account account) {
        this.account = account;
    }
}
