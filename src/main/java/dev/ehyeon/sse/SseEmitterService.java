package dev.ehyeon.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Slf4j
@Service
public class SseEmitterService {

    private final SseEmitter sseEmitter;

    public SseEmitterService() {
        sseEmitter = new SseEmitter(60 * 1000L);
        sseEmitter.onCompletion(() -> log.info("Completion"));
        sseEmitter.onTimeout(() -> log.info("Time Out"));
    }

    public SseEmitter getSseEmitter() {
        sendMessage("Welcome!"); // 503 방지

        return sseEmitter;
    }

    public void sendMessage(String message) {
        try {
            sseEmitter.send(message);
        } catch (IOException ignored) {

        }
    }
}
