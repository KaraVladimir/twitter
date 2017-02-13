package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.Retweet;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class RetweetImpl extends AbstractMessage implements Retweet {
    private Message includedTweet;

    public RetweetImpl(String text, Message includedTweet) {
        this.text = text;
        this.includedTweet = includedTweet;
    }

    public Message reply(String text) {
        return null;
    }
}
