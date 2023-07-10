package org.course.code.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {

    @Test
    public void test1(){
        System.out.printf("test1线程ID为%s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("test2线程ID为%s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("test3线程ID为%s%n",Thread.currentThread().getId());
    }

}
