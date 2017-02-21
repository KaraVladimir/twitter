package ua.training.domain.tweet.implementation;

import ua.training.domain.tweet.Message;
import ua.training.domain.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    List<User> mentionedUsers;

    AbstractMessage(User author) {
        this.author = author;
        this.date = new Date();
        usersLiked = new ArrayList<>();
        usersRetweeted = new ArrayList<>();
        replies = new ArrayList<>();
        mentionedUsers = new ArrayList<>();
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
        List<User> users = getMentionedUsers();
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

    public List<User> getMentionedUsers() {
        return mentionedUsers;
    }

    protected abstract Message getRootTweet();

    protected abstract Message getIncludedTweet();
}
