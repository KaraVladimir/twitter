package ua.training.domain.timeline;

import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.implementation.RetweetImpl;
import ua.training.domain.tweet.implementation.TweetImpl;
import ua.training.domain.user.User;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Volodymyr_Kara on 2/13/2017.
 */
public class TimelineImpl implements Timeline{
    User currentUser;
    List<Message> timeline;

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

    public void like(Message tweet) {
        tweet.like(currentUser);
    }

    public List<Message> getTimeline() {
        currentUser.getFollowing();
//        Stream.builder().add()
//        currentUser.getMessages().stream().
        return timeline;
    }
}
