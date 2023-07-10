package org.course.code.groups;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();//真实测试时可以换成代码中的异常
    }
}
