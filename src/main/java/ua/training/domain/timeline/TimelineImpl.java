package ua.training.domain.timeline;

import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.implementation.MentionImpl;
import ua.training.domain.tweet.implementation.RetweetImpl;
import ua.training.domain.tweet.implementation.TweetImpl;
import ua.training.domain.user.User;
import ua.training.domain.user.UsersStorage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Volodymyr_Kara on 2/13/2017.
 */
public class TimelineImpl implements Timeline{
    User currentUser;
    List<Message> timeline;

    public TimelineImpl(User currentUser) {
        this.currentUser = currentUser;
    }

    public Message tweet(String text) {
        Message message = new TweetImpl(currentUser, text);
        currentUser.addMessage(message);
        return message;
    }

    public Message retweet(String text, Message includedTweet) {
        Message message = includedTweet.retweet(currentUser, text);
        currentUser.addMessage(message);
        return message;
    }

    public Message mention(String text) {
        Message message = new MentionImpl(currentUser,text);
        currentUser.addMessage(message);
        return message;
    }

    public void like(Message tweet) {
        tweet.like(currentUser);
    }

    public List<Message> getTimeline() {
        List<User>users = currentUser.getFollowing();
        users.add(currentUser);
        timeline = users.stream().flatMap(u -> u.getMessages().stream()).collect(Collectors.toList());
        return timeline;
    }
}
