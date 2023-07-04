package org.course.code;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试方法2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在测试方法运行之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试方法运行之后运行的");
    }

}
