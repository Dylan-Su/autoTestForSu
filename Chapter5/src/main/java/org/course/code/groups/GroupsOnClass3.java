package org.course.code.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("这是teacher中的老师1");
    }
    public void teacher2(){
        System.out.println("这是teacher中的老师2");
    }
}
