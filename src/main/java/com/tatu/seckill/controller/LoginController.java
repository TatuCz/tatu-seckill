package com.tatu.seckill.controller;

import com.tatu.seckill.response.ErrorCodeMsg;
import com.tatu.seckill.response.Response;
import com.tatu.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Response<String> doLogin(@RequestParam("nickname") String nickname,
                            @RequestParam("password") String password) {

        if (StringUtils.isEmpty(nickname)) {
            return Response.error(ErrorCodeMsg.NICKNAME_EMPTY);
        }
        if (StringUtils.isEmpty(password)) {
            return Response.error(ErrorCodeMsg.PASSWORD_EMPTY);
        }

        ErrorCodeMsg codeMsg = userService.login(nickname, password);
        if (codeMsg == null) {
            return Response.success("登陆成功");
        }

        return Response.error(codeMsg);
    }
}
