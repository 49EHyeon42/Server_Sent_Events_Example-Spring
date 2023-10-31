package dev.ehyeon.sse.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody SaveUserRequest request) {
        return userService.saveUser(request.getNickname());
    }

    @GetMapping("/user")
    public User findUserById(long id) {
        return userService.findUserById(id);
    }
}
