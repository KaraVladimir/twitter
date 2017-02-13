package ua.training.domain.user;

import ua.training.domain.tweet.Message;

import java.util.List;

/**
 * Created by Volodymyr_Kara on 2/13/2017.
 */
public class UserImpl implements User,Profile {
    String fullName;
    List<User> followings;
    List<User> followers;
    List<Message> messages;

    public void Follow(User anotherUser) {
        followings.add(anotherUser);
        anotherUser.addFollower(this);
    }

    public void UnFollow(User anotherUser) {
        followings.remove(anotherUser);
        anotherUser.removeFollower(this);
    }

    public List<User> getFollowing() {
        return followings;
    }

    public List<User> getFollower() {
        return followers;
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void removeFollower(User follower) {
        followers.remove(follower);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public String getFullName() {
        return fullName;
    }

}
