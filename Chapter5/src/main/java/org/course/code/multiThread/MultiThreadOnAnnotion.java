package org.course.code.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
    @Test(invocationCount = 15,threadPoolSize = 3)
    public void test(){
        System.out.printf("当前线程ID为%s%n",Thread.currentThread().getId());
        System.out.println(1);
    }
}
