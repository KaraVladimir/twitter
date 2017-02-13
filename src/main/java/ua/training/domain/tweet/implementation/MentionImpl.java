package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Mention;
import ua.training.domain.tweet.Message;
import ua.training.domain.User;

import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class MentionImpl extends AbstractMessage implements Mention {
    private List<User> userList;

    public MentionImpl(List<User> userList,String text) {
        this.text = text;
        this.userList = userList;
    }

    public Message reply(String text) {
        return null;
    }
}
