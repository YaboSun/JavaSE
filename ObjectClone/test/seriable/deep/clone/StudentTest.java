package seriable.deep.clone;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OptionalDataException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hadoop on 18-9-15
 */
class StudentTest {

    @Test
    void deepClone() throws OptionalDataException, ClassNotFoundException, IOException {
        Student s1 = new Student("zhangsan", 18);
        Student s2 = (Student) s1.clone();
        System.out.println("学生对象1年龄：" + s1.getStuAge() + "学生对象2年龄：" + s2.getStuAge());

        s1.setStuAge(20);

        assertTrue(s2.getStuAge() == 18);
        assertTrue(s2.getStuName().matches("zhangsan"));
        System.out.println("学生对象1年龄：" + s1.getStuAge() + "学生对象2年龄：" + s2.getStuAge());
    }
}