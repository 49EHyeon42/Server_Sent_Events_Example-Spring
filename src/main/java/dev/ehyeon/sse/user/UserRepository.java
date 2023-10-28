package dev.ehyeon.sse.user;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private long id = 1;

    private final Map<Long, User> map = new HashMap<>();

    public User saveUser(String nickname) {
        User user = new User(id, nickname);

        map.put(id++, user);

        return user;
    }

    public User findUserById(long id) {
        User foundUser = map.get(id);

        if (foundUser == null) {
            throw new UserNotFoundException();
        }

        return foundUser;
    }
}
