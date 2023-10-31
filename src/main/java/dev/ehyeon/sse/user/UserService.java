package dev.ehyeon.sse.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(String nickname) {
        return userRepository.saveUser(nickname);
    }

    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }
}
