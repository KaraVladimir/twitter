package ua.training.domain.tweet;

import ua.training.domain.user.User;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface Message {

    void like(User currentUser);

    int likesCount();

    Message retweet(User currentUser, String text);

    int retweetCount();

    Message reply(User currentUser, String text);

    int replyCount();

    void addReply(Message reply);
}
