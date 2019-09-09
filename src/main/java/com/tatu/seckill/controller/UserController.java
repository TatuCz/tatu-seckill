package com.tatu.seckill.controller;

import com.tatu.seckill.domain.User;
import com.tatu.seckill.response.ErrorCodeMsg;
import com.tatu.seckill.response.Response;
import com.tatu.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Response<User> getUserById(@PathVariable("id") int id) {
        User user = userService.getById(id);
        if (user != null) {
            return Response.success(user);
        }

        return Response.error(ErrorCodeMsg.USER_NOT_FOUNT);
    }

    @GetMapping("/reg")
    public Response<Boolean> reg(@RequestParam("nickname") String nickname,
                                 @RequestParam("password") String password) {
        return Response.success(userService.addUser(nickname, password));
    }
}
