package ua.training.domain.tweet.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.implementation.AbstractMessage;
import ua.training.domain.tweet.implementation.TweetImpl;
import ua.training.domain.user.User;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Volodymyr_Kara on 2/20/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class TweetImplTest {

    @Mock
    private Message rootTweet;
    @Mock
    User currentUser;
    @Mock
    Date date;
    @Mock
    protected List<User> usersLiked;
    @Mock
    protected List<User> usersRetweeted;
    @Mock
    protected List<Message> replies;
    @Mock
    User author;
    private String text = "aaa";
    @InjectMocks
    private TweetImpl tweet = new TweetImpl(author, text);


    @Test
    public void likeTest() {
        tweet.like(currentUser);
        verify(usersLiked, times(1)).add(currentUser);
    }

    @Test
    public void likeCountTest() {
        tweet.likesCount();
        verify(usersLiked, times(1)).size();
    }

    @Test
    public void retweetTest() {
        AbstractMessage msg = (AbstractMessage) tweet.retweet(currentUser,text);
        verify(usersRetweeted, times(1)).add(currentUser);
        Assert.assertEquals(msg.getIncludedTweet(),tweet);
    }

    @Test
    public void retweetCountTest() {
        tweet.retweetCount();
        verify(usersRetweeted, times(1)).size();
    }

    @Test
    public void replyTest() {
        AbstractMessage msg = (AbstractMessage) tweet.reply(currentUser, text);
        Assert.assertEquals(msg.text,text);
    }

    @Test
    public void replyCountTest() {
        tweet.replyCount();
        verify(replies, times(1)).size();
    }

    @Test
    public void getMentionedUsersTest() {
        List<User> users = tweet.getMentionedUsers("@name1 something withoutspace@name2");
        Assert.assertEquals(users.size(),2);
    }

}
