package dev.ehyeon.sse.channel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping("/channel/subscribe")
    public SseEmitter subscribe(@RequestBody SubscribeRequest request) {
        return channelService.subscribe(request.getUserId());
    }

    @PostMapping("/channel/message")
    public void sendMessage(@RequestBody SendMessageRequest request) {
        channelService.sendMessage(request.getUserId(), request.getMessage());
    }
}
