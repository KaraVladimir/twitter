package ua.training.domain.user;

import ua.training.domain.tweet.Message;

import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface User {
    void Follow(User anotherUser);

    void UnFollow(User anotherUser);

    List<User> getFollowing();

    List<User> getFollower();

    void addFollower(User follower);

    void removeFollower(User follower);

    List<Message> getMessages();

    void addMessage(Message message);
}
