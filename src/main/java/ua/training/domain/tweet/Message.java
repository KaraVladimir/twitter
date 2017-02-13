package ua.training.domain.tweet;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface Message {

    void like();

    Message retweet(String text);

    Message reply(String text);
}
