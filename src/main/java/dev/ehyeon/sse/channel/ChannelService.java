package dev.ehyeon.sse.channel;

import dev.ehyeon.sse.user.User;
import dev.ehyeon.sse.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class ChannelService {

    private final SseEmitter sseEmitter;
    private final UserRepository userRepository;

    // 사용자마다 sseEmitter를 만들어야 한다, 실패한 동작

    public ChannelService(UserRepository userRepository) {
        sseEmitter = new SseEmitter();
        this.userRepository = userRepository;
    }

    public SseEmitter subscribe(long userId) {
        User foundUser = userRepository.findUserById(userId);

        sendMessage("system", "Connected " + foundUser.getNickname());

        return sseEmitter;
    }

    public void sendMessage(long userId, String message) {
        User foundUser = userRepository.findUserById(userId);

        sendMessage(foundUser.getNickname(), message);
    }

    private void sendMessage(String nickname, String message) {
        try {
            sseEmitter.send(nickname + " : " + message);
        } catch (IOException exception) {
            throw new FailedToSendMessageException();
        }
    }
}
