package ua.training.domain.timeline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.domain.tweet.Message;
import ua.training.domain.tweet.implementation.RetweetImpl;
import ua.training.domain.tweet.implementation.TweetImpl;
import ua.training.domain.user.User;
import ua.training.domain.user.UserImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Volodymyr_Kara on 2/21/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TimelineImplTest {
    @Mock
    User currentUser;
    @Mock
    List<Message> messages;
    @Mock
    Message message;
    @InjectMocks
    TimelineImpl timeline;
    List<User> users;

    @Before
    public void setupTests() {
        users = new ArrayList<>();

        User user1 = new UserImpl();
        Timeline timeline1 = new TimelineImpl(user1);
        Message message11 = timeline1.tweet("tweet11");
        Message message12 = timeline1.tweet("tweet12");

        User user2 = new UserImpl();
        Timeline timeline2 = new TimelineImpl(user2);
        Message message21 = timeline2.tweet("tweet21");
        Message message22 = timeline2.retweet("tweet22",message11);

        users.add(user1);
        users.add(user2);
        System.out.println(users.size());
    }

    @Test
    public void tweetTest() {
        Message message = timeline.tweet("asd");
        verify(currentUser, times(1)).addMessage(message);
    }

    @Test
    public void retweetTest() {
        Message message = timeline.retweet("asd", this.message);
        verify(currentUser,times(1)).addMessage(message);
    }

    @Test
    public void likeTest() {
        timeline.like(message);
        verify(message,times(1)).like(currentUser);
    }

    @Test
    public void getTimeLineTest() {
        when(currentUser.getFollowing()).thenReturn(users);

        List<Message>messages =  timeline.getTimeline();
        Assert.assertEquals(4,messages.size());
    }
}
