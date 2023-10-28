package dev.ehyeon.sse.global;

import dev.ehyeon.sse.channel.FailedToSendMessageException;
import dev.ehyeon.sse.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userNotFoundExceptionHandler() {
        return "User Not Found";
    }

    @ExceptionHandler(FailedToSendMessageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String failedToSendMessageExceptionHandler() {
        return "Failed To Send Message";
    }
}
