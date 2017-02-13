package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.user.User;

import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class ReplyImpl extends AbstractMessage {
    private List<User> userList;
    private Message rootTweet;

    public ReplyImpl(User author, List<User> userList, String text, Message rootTweet) {
        super(author);
        this.userList = userList;
        this.rootTweet = rootTweet;
        this.text = text;
    }

    protected Message getIncludedTweet() {
        return this;
    }

    protected Message getRootTweet() {
        return rootTweet;
    }
}
