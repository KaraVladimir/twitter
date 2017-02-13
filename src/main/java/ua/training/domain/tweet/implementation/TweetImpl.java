package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.user.User;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class TweetImpl extends AbstractMessage {

    public TweetImpl(User author, String text) {
        super(author);
        this.text = text;
    }

    protected Message getRootTweet() {
        return this;
    }

    protected Message getIncludedTweet() {
        return this;
    }
}
