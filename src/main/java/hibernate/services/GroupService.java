package hibernate.services;

import hibernate.community.Account;
import hibernate.community.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class GroupService {

    public List<Account> getUniqueAccountsFor(Account account) {
        List<Account> one = new ArrayList<>();
        one.addAll(account.getRootGroup().getAccountList().stream().collect(Collectors.toList()));
        for (Group group : account.getGroups()) {
            one.addAll(group.getAccountList().stream().collect(Collectors.toList()));
        }
        List<Account> two = new ArrayList<>();
        one.stream().filter(ref -> !two.contains(ref)).forEach(two::add);
        return two;
    }

    public List<Account> getUniqueAccountsFor(Group group) {
        List<Account> one = new ArrayList<>();
        group.getAccountList().stream().filter(ref -> !one.contains(ref)).forEach(one::add);
        return one;
    }


}
