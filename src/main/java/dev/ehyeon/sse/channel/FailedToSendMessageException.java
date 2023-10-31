package dev.ehyeon.sse.channel;

public class FailedToSendMessageException extends RuntimeException {

    public FailedToSendMessageException() {
        super();
    }

    public FailedToSendMessageException(String message) {
        super(message);
    }

    public FailedToSendMessageException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public FailedToSendMessageException(Throwable throwable) {
        super(throwable);
    }
}
