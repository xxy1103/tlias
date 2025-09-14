package top.ulna520.tlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.ulna520.tlias.model.Result;
import top.ulna520.tlias.model.User;
import top.ulna520.tlias.service.UserService;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户信息{}", user);
        String jwt = userService.login(user);
        return jwt != null ? Result.success(jwt) : Result.error("用户名或密码错误");
    }
}
