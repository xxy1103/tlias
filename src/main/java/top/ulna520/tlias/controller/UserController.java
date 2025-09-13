package top.ulna520.tlias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.ulna520.tlias.model.Result;
import top.ulna520.tlias.model.User;
import top.ulna520.tlias.service.UserService;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Result users(String name, Integer gender, Date begin, Date end, Integer page, Integer pageSize){
        List<User> res = userService.selectWithCondition(name,gender,begin,end,page,pageSize);
        return Result.success(res);
    }

    @DeleteMapping("users/{ids}")
    public Result deleteUser(@PathVariable("ids") List<Integer> ids){
        userService.deleteById(ids);
        return Result.success();
    }

    @PostMapping("/users")
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

    @GetMapping("/users/{id}")
    public Result getUser(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @PutMapping("/users")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

}
