package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.user.User;

import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class MentionImpl extends AbstractMessage{
    private List<User> userList;

    public MentionImpl(User author, String text) {
        super(author);
        this.text = text;
        this.userList = getMentionedUsers(text);
    }

    protected Message getIncludedTweet() {
        return this;
    }

    protected Message getRootTweet() {
        return this;
    }
}
