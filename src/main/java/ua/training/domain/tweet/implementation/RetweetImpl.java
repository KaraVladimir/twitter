package ua.training.domain.tweet.implementation;

import ua.training.domain.user.User;
import ua.training.domain.tweet.Message;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class RetweetImpl extends AbstractMessage {
    private Message includedTweet;

    public RetweetImpl(User author, String text, Message includedTweet) {
        super(author);
        this.text = text;
        this.includedTweet = includedTweet;
    }

    protected Message getIncludedTweet() {
        return includedTweet;
    }

    protected Message getRootTweet() {
        return includedTweet;
    }


}
