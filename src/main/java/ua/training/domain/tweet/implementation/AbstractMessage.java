package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.User;

import java.util.Date;

/**
 * @author kara.vladimir2@gmail.com.
 */
public abstract class AbstractMessage implements Message{
    protected User author;
    protected Date date;
    protected String text;
    protected Integer likesCount;
    protected Integer retweetCount;

    public void like() {
        likesCount = likesCount + 1;
    }

    public Message retweet(String text) {
        retweetCount = retweetCount + 1;
        return new RetweetImpl(text, this);
    }
}
