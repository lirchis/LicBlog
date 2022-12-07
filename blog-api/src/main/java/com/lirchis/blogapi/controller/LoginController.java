package com.lirchis.blogapi.controller;


import com.lirchis.blogapi.entity.User;
import com.lirchis.blogapi.model.vo.LoginReqVo;
import com.lirchis.blogapi.model.vo.R;
import com.lirchis.blogapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody LoginReqVo loginReqVo){

        User user = userService.getUserByUsernameAndPassword(loginReqVo.getUsername(),loginReqVo.getPassword());
        if (!"ROLE_admin".equals(user.getRole())) {
            return R.create(403, "无权限");
        }
        user.setPassword(null);
        return R.ok("登录成功",user);
    }
}
