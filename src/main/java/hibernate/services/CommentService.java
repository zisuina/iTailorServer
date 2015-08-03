package hibernate.services;

import hibernate.community.Comment;
import hibernate.community.ShareItem;
import util.ListSortUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class CommentService {
    public List<Comment> listCommentsByTime(ShareItem shareItem) {
        Collections.sort(shareItem.getComments(), new Comparator<Comment>() {
            public int compare(Comment arg0, Comment arg1) {
                return arg0.getCreatedTime().compareTo(arg1.getCreatedTime());
            }
        });
        return shareItem.getComments();
    }

    public List<Comment> listCommentsByThumbUp(ShareItem shareItem) {
        ListSortUtil<Comment> sortList = new ListSortUtil<>();
//        sortList.sort(shareItem.getComments(), "thumbNum", "asc");
        sortList.sort(shareItem.getComments(), "thumbNum", "desc");
        return shareItem.getComments();
    }

    public void addComment(ShareItem shareItem, Comment comment) {
        shareItem.getComments().add(comment);
    }

    public void removeComment(ShareItem shareItem, Comment comment) {
        if (shareItem.getComments().contains(comment)) {
            shareItem.getComments().remove(comment);
        }
    }

    public void starComment(ShareItem shareItem, Comment comment) {
        if (shareItem.getComments().contains(comment)) {
            comment.setThumbNum(comment.getThumbNum() + 1);
        }
    }

    public void commentFilter(Comment comment){
        //TO DO
    }
}
