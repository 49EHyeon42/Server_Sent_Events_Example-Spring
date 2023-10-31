package dev.ehyeon.sse.channel;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ChannelRepository {

    private final Map<Long, SseEmitter> map = new HashMap<>();

    public void saveChannel(long userId, SseEmitter sseEmitter) {
        map.put(userId, sseEmitter);
    }

    public Collection<SseEmitter> findAllSseEmitter() {
        return map.values();
    }

    public void deleteChannelByUserId(long userId) {
        map.remove(userId);
    }
}
