package ua.training.domain.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.domain.tweet.Message;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author kara.vladimir2@gmail.com.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserImplTest {
    @Mock
    List<Message> messages;
    @Mock
    List<User> followings;
    @Mock
    List<User> followers;
    @Mock
    User anotherUser;

    @InjectMocks
    User currentUser = new UserImpl();

    @Before
    public void setup() {
    }

    @Test
    public void followTest() {
        currentUser.follow(anotherUser);
        verify(followings,times(1)).add(anotherUser);
        verify(anotherUser).addFollower(currentUser);
    }

    @Test
    public void unfollowTest() {
        currentUser.unfollow(anotherUser);
        verify(followings, times(1)).remove(anotherUser);
        verify(anotherUser).removeFollower(currentUser);
    }


}