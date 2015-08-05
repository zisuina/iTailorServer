package hibernate.services;

import hibernate.community.Account;
import hibernate.community.ShareItem;
import resource.service.TimeLineService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ShareItemService {
    public void pushShareItem(Account account, ShareItem shareItem) {
        account.getShareItems().add(shareItem);
        account.getTimeLine().getShareItems().add(shareItem);
        TimeLineService timeLineService = new TimeLineService(account);
        timeLineService.getSendAccountList().stream().filter(ref ->
                timeLineService.isPushAccepted(account, ref)).forEach(ref -> {
            ref.getTimeLine().getShareItems().add(shareItem);
        });
    }

    public void pushShareItemInclude(Account account, ShareItem shareItem, List<Account> accounts) {
        account.getShareItems().add(shareItem);
        account.getTimeLine().getShareItems().add(shareItem);
        TimeLineService timeLineService = new TimeLineService(account);
        List<Account> result = timeLineService.getSendAccountList().stream().collect(Collectors.toList());
        result.addAll(accounts.stream().collect(Collectors.toList()));
        result.stream().filter(ref -> new TimeLineService(ref).getReceiveAccountList().contains(account)).forEach(ref -> {
            ref.getTimeLine().getShareItems().add(shareItem);
        });
    }

    public void pushShareItemExcept(Account account, ShareItem shareItem, List<Account> accounts) {
        account.getShareItems().add(shareItem);
        account.getTimeLine().getShareItems().add(shareItem);
        TimeLineService timeLineService = new TimeLineService(account);
        List<Account> result = timeLineService.getSendAccountList();
        accounts.stream().filter(ref -> result.contains(ref)).forEach(result::remove);
        result.stream().filter(ref ->
                timeLineService.isPushAccepted(account, ref)).forEach(ref -> {
            ref.getTimeLine().getShareItems().add(shareItem);
        });
    }

}
