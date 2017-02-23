package ua.training.domain.user;

/**
 * Class-stub
 * @author kara.vladimir2@gmail.com.
 */
public class UsersStorage {

    public static User findUser(String name) {
        return new UserImpl();
    }
}
