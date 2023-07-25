package org.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.course.code.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1")
@RequestMapping("v1")
public class Demo {
    //首先取一个执行sql语句的对象

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return  template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息",httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户信息",httpMethod = "POST")
    public int deleteUser(@RequestParam int id){
       return template.delete("deleteUser",id);
    }
}
