package org.course.code.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"name","age","sno"})
    public void parameterTest(String age1,String name1,String snumber){
        System.out.println(age1 + "今年" + name1 + "岁了,学号是" + snumber);
    }
}
