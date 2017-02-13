package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.Tweet;
import ua.training.domain.User;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class TweetImpl extends AbstractMessage implements Tweet {

    public TweetImpl(String text) {
        this.text = text;
    }

    public Message reply(String text) {
        List<User> users = new LinkedList<User>();
        users.add(this.author);
        return new ReplyImpl(users, text, this);
    }
}
