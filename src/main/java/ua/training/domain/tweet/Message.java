package ua.training.domain.tweet;

import ua.training.domain.user.User;

import java.util.List;

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

    List<User> getMentionedUsers(String text);
}
