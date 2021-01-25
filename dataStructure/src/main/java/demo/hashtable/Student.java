package demo.hashtable;

import java.util.Objects;

public class Student {
    private final int grade;
    private final int cls;
    private final String firstName;
    private final String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        // 可能会存在整型溢出,但是不影响整体int数值输出
        int B = 31;
        int hash = 0;
        hash = hash * B + this.grade;
        hash = hash * B + this.cls;
        // 去除大小写的影响,根据实际情况定
        hash = hash * B + this.firstName.toLowerCase().hashCode();
        hash = hash * B + this.lastName.toLowerCase().hashCode();
        // java语言很根据对象的地址生成一个hash值,默认是使用Object的方法
        // 虽然使用了hashCode,但是还是会产生hash冲突,这时候就需要使用equals函数判断2个对象是否相等
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade &&
                cls == student.cls &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }
}
