package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.Reply;
import ua.training.domain.User;

import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class ReplyImpl extends AbstractMessage implements Reply {
    private List<User> userList;
    private Message rootTweet;

    public ReplyImpl(List<User> userList,String text, Message rootTweet) {
        this.userList = userList;
        this.rootTweet = rootTweet;
        this.text = text;
    }

    public Message reply(String text) {
        return null;
    }
}
