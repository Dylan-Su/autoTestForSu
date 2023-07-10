package org.course.code.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data1")
    public void testDataProvider(String name,int age){
        System.out.println("name = " + name + ",age = " + age);
    }

    @DataProvider(name = "data1")
    public Object [][] providerData(){
        Object [][] o = new Object[][]{
                {"张三",10},
                {"李四",12}
        };
    return o;
    }

    @Test(dataProvider = "data2")
    public void test1(String name,int age){
        System.out.println("name = " + name + ",   age = " + age);
    }

    @Test(dataProvider = "data2")
    public void test2(String name,int age){
        System.out.println("name = " + name + ",   age = " + age);
    }

    @DataProvider(name = "data2")
    public Object[][] dataProvider2(Method method){
        Object[][] o = null;
        if (method.getName().equals("test1")){
            o = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",30}
        };}
        if (method.getName().equals("test2")) {
            o = new Object[][]{
                    {"王五",50},
                    {"赵六",60}
            };
            };
        return o;
    }
}
