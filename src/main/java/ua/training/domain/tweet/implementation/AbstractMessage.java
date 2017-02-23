package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.user.User;
import ua.training.domain.user.UsersStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public abstract class AbstractMessage implements Message{
    protected User author;
    protected Date date;
    protected String text;
    protected List<User> usersLiked;
    protected List<User> usersRetweeted;
    protected List<Message> replies;

    AbstractMessage(User author) {
        this.author = author;
        this.date = new Date();
        usersLiked = new ArrayList<>();
        usersRetweeted = new ArrayList<>();
        replies = new ArrayList<>();
    }

    public void like(User currentUser) {
        usersLiked.add(currentUser);
    }

    public int likesCount() {
        return usersLiked.size();
    }

    public Message retweet(User currenUser, String text) {
        usersRetweeted.add(currenUser);
        return new RetweetImpl(currenUser, text, getIncludedTweet());
    }

    public int retweetCount() {
        return usersRetweeted.size();
    }

    public Message reply(User currentUser, String text) {
        List<User> users = getMentionedUsers(text);
        users.add(this.author);
        Message rootTweet = getRootTweet();
        Message reply = new ReplyImpl(currentUser, users, text, getRootTweet());
        rootTweet.addReply(reply);
        return reply;
    }

    public int replyCount() {
        return replies.size();
    }

    public void addReply(Message reply) {
        replies.add(reply);
    }

    public List<User> getMentionedUsers(String text) {
        List<User> users = new ArrayList<>();
        Pattern pattern = Pattern.compile("(@{1})([^\\s]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            users.add(UsersStorage.findUser(matcher.group(2)));
        }
        return users;
    }

    protected abstract Message getRootTweet();

    protected abstract Message getIncludedTweet();
}
