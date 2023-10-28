package dev.ehyeon.sse.user;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private final long id;
    private final String nickname;
}
