package org.course.code.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class suiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite运行开始");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite运行开始");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test运行开始了");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test运行开始了");
    }
}
