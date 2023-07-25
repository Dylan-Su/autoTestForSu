package org.course.code.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@Api(value = "/")
public class MygetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以对cookies赋值",httpMethod = "get")
    public String getCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }
    /*
    要求客户端携带cookies信息访问
    这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息请求";
        }
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "cookies信息正确，可以访问";
            }
        }
        return "你必须携带cookies信息请求";
    }

    /**
     * 第一种方式，使用@RequestParam
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/getWithParam",method = RequestMethod.GET)
    @ApiOperation(value = "携带参数才能访问的get请求的第一种实现",httpMethod = "GET")
    public Map<String,Integer> getWithParam(@RequestParam Integer start,
                                            @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("shoes",100);
        myList.put("noodles",10);
        myList.put("shirt",50);
        return myList;
    }


    /**
     * 第二种方式，使用@PathVariable
     * url:ip:port/get/with/param/10/20
     */

    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "携带参数才能访问的get请求的第二种实现",httpMethod = "GET")
    public Map<String,Integer> getWithParameter(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("shoes",120);
        myList.put("noodles",14);
        myList.put("shirt",52);
        return myList;
    }
}
