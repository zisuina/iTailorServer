package hibernate.services;

import hibernate.community.Account;
import hibernate.community.Comment;
import hibernate.community.ShareItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 03/08/2015 0003.
 * Group iTailor.hunters.neu.edu.cn
 */
public class CommentServiceTest {
    CommentService commentService;
    ShareItem shareItem;
    Account sender;
    Comment comment;
    Comment comment2;
    Comment comment3;

    @Before
    public void setUp() throws Exception {
        commentService = new CommentService();
        shareItem = new ShareItem();
        sender = new Account("liker.xu@foxmail.com", "888888");
        comment = new Comment("hello world", sender);
        Thread.sleep(1000);
        comment2 = new Comment("hello nerd", sender);
        Thread.sleep(1000);
        comment3 = new Comment("hello2 nerd", sender);
    }

    @Test
    public void testListCommentsByTime() throws Exception {
        commentService.addComment(shareItem, comment3);
        commentService.addComment(shareItem, comment2);
        commentService.addComment(shareItem, comment);
        commentService.listCommentsByTime(shareItem);
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment2);
        comments.add(comment3);
        assertEquals(comments, shareItem.getComments());
    }

    @Test
    public void testListCommentsByThumbUp() throws Exception {
        commentService.addComment(shareItem, comment3);
        commentService.addComment(shareItem, comment2);
        commentService.addComment(shareItem, comment);

        commentService.starComment(shareItem, comment);
        commentService.starComment(shareItem, comment2);
        commentService.starComment(shareItem, comment3);
        commentService.starComment(shareItem, comment3);
        commentService.starComment(shareItem, comment3);

        commentService.listCommentsByThumbUp(shareItem);
        assertEquals(3, shareItem.getComments().get(0).getThumbNum());
        assertEquals(1, shareItem.getComments().get(1).getThumbNum());
        assertEquals(1, shareItem.getComments().get(2).getThumbNum());
    }

    @Test
    public void testAddComment() throws Exception {
        assertEquals(0, shareItem.getComments().size());
        commentService.addComment(shareItem, comment);
        assertEquals(1, shareItem.getComments().size());
    }

    @Test
    public void testRemoveComment() throws Exception {
        assertEquals(0, shareItem.getComments().size());
        commentService.addComment(shareItem, comment);
        assertEquals(1, shareItem.getComments().size());
        commentService.removeComment(shareItem, comment);
        assertEquals(0, shareItem.getComments().size());
    }

    @Test
    public void testStarComment() throws Exception {
        commentService.addComment(shareItem, comment);
        assertEquals(0, comment.getThumbNum());
        commentService.starComment(shareItem, comment);
        assertEquals(1, comment.getThumbNum());
    }
}