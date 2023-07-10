package org.course.code.groups;


import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {

    public void student1(){
        System.out.println("这是stu1中的学生1");

    }public void student2(){
        System.out.println("这是stu1中的学生2");
    }

}
