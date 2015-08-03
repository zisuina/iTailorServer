package hibernate.services;

import hibernate.community.Account;
import hibernate.community.Group;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class FeedbackService {
    private static Account system = new Account();
    private static Group rootGroup = new Group();

    public FeedbackService() {
        system.setEmail("liker.xu@foxmail.com");
        system.setLogIn(true);
        system.setRootGroup(rootGroup);
    }

//    public void feedback(Feedback feedback) {
//        system.getMessageList().add(feedback);
//        if (!system.isAFriendOf(feedback.getSenderAccount())) {
//            system.getRootGroup().getAccountList().add(feedback.getSenderAccount());
//        }
//    }

//    public void reply(Feedback feedback, String context) {
//        feedback.setAccepted(true);
//        Message message = new Message();
//        message.setSenderAccount(system);
//        message.setContext(context);
//        feedback.getSenderAccount().getMessageList().add(message);
//    }

}
