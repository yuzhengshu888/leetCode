package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/11/4 14:08
 */
public class test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student a = new Student();
        a.setAge(1);
        a.setName("a");
        students.add(a);
        a= new Student();
        a.setName("b");
        a.setAge(2);
        students.add(a);
        System.out.println(students);
    }
}
