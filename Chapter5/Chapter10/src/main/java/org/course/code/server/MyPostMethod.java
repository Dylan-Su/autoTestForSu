package org.course.code.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.course.code.bean.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/")
@RequestMapping(value = "/v1")
public class MyPostMethod {
    private static Cookie cookie;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个登录请求的接口",httpMethod = "POST")
    public String login(@RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password,
                        HttpServletResponse response){
        if (username.equals("huhansan")&&password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功";
        }
        return "用户名或密码错误";

    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
        User user;
        //获取传入的cookie信息
        Cookie[] cookies = request.getCookies();
        //比对输入的账号密码
        for (Cookie c:cookies){
            if (c.getName().equals("login")&&c.getValue().equals("true")&&u.getUsername().equals("zhangsan")&&u.getPassword().equals("123456")){
                user = new User();
                user.setName("lisi");
                user.setAge("20");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
