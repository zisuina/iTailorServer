package hibernate.recommendation;

import hibernate.community.*;
import hibernate.elements.Color;
import hibernate.recommendation.favors.FavorColor;
import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 28/07/2015 0028.
 * Group iTailor.hunters.neu.edu.cn
 */
public class UserTest {
    @Test
    public void testUserHibernateBasic() {
        new BaseDAO<User>().create(new User());
        new BaseDAO<User>().create(new User("liker"));
    }
    @Test
    public void testUserHibernateFinal() {
        AccessControl accessControl = new AccessControl(1,false,false);

        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setIp("192.168.0.108");
        loginRecord.setUDID("4567654345677654456");

        Account account = new Account("liker.xu@foxmail.com","66666");
        Account account2 = new Account("thea.zhu@foxmail.com","88888");

        account.getLoginRecords().add(loginRecord);

        Group group = new Group();
        group.setAccessControl(accessControl);
        group.getAccountList().add(account2);
        account.getGroups().add(group);

        TimeLine timeLine = new TimeLine();
        account.setTimeLine(timeLine);

        ShareItem shareItem = new ShareItem();
        account.getShareItems().add(shareItem);

        timeLine.getShareItems().add(shareItem);

        Message message = new Message("message",account2);
        account.getMessageList().add(message);

        Comment comment = new Comment("comment",account);
        shareItem.getComments().add(comment);

        Feedback feedback = new Feedback("feedback",account2);
        account.getFeedbacks().add(feedback);

        User user = new User();
        account.setUser(user);

        PreferenceMatrix preferenceMatrix = new PreferenceMatrix();

        FavorColor favorColor = new FavorColor();
        Color color = new Color("red");
        favorColor.setColor(color);
        favorColor.setFavorDegree(100);

        FavorColor favorColor2 = new FavorColor();
        Color color2 = new Color("red");
        favorColor2.setColor(color2);
        favorColor2.setFavorDegree(90);

        FavorColor favorColor3 = new FavorColor();
        Color color3 = new Color("red");
        favorColor3.setColor(color3);
        favorColor3.setFavorDegree(80);

        preferenceMatrix.getColorPreference().add(favorColor);
        preferenceMatrix.getColorPreference().add(favorColor2);
        preferenceMatrix.getColorPreference().add(favorColor3);
        user.setPreferenceMatrix(preferenceMatrix);

        Wardrobe rootWardrobe = new Wardrobe();
        Wardrobe subWardrobe = new Wardrobe();
        rootWardrobe.getSubWardrobeList().add(subWardrobe);
        Resource rootResource = new Resource();
        rootResource.setDescription("hello");
        Resource subResource = new Resource();
        subResource.setDescription("world");
        rootWardrobe.getResources().add(rootResource);
        subWardrobe.getResources().add(subResource);
        subWardrobe.setIsPublic(true);
        user.setRootWardrobe(rootWardrobe);
        new BaseDAO<Account>().create(account);



    }
}