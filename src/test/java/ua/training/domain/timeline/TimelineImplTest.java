package ua.training.domain.timeline;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.domain.tweet.Message;
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
        User user2 = new UserImpl();
        users.add(new UserImpl());
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

    }
}
