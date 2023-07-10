package org.course.code.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的测试方法1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的测试方法2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端的测试方法1");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端的测试方法2");
    }

    @BeforeGroups("client")
    public void beforeGroups(){
        System.out.println("这是服务端组运行之前的测试方法");
    }

    @AfterGroups("client")
    public void afterGroups(){
        System.out.println("这是服务端组运行之后的测试方法");
    }
}
