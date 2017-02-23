package ua.training.domain.timeline;

import ua.training.domain.tweet.Message;

import java.util.List;

/**
 * Created by Volodymyr_Kara on 2/13/2017.
 */
public interface Timeline {

    Message tweet(String text);

    Message retweet(String text, Message includedTweet);

    Message mention(String text);

    void like(Message tweet);

    List<Message> getTimeline();
}
