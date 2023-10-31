package dev.ehyeon.sse.channel;

import dev.ehyeon.sse.user.User;
import dev.ehyeon.sse.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;

    public SseEmitter subscribe(long userId) {
        User foundUser = userRepository.findUserById(userId);

        SseEmitter sseEmitter = new SseEmitter(60 * 1000L);
        sseEmitter.onCompletion(() -> channelRepository.deleteChannelByUserId(userId));
        sseEmitter.onTimeout(() -> channelRepository.deleteChannelByUserId(userId));

        channelRepository.saveChannel(userId, sseEmitter);

        sendMessage("system", "Hi, " + foundUser.getNickname());

        return sseEmitter;
    }

    public void sendMessage(long userId, String message) {
        User foundUser = userRepository.findUserById(userId);

        sendMessage(foundUser.getNickname(), message);
    }

    private void sendMessage(String nickname, String message) {
        for (SseEmitter sseEmitter : channelRepository.findAllSseEmitter()) {
            try {
                sseEmitter.send(nickname + " : " + message);
            } catch (IOException exception) {
                throw new FailedToSendMessageException();
            }
        }
    }
}
