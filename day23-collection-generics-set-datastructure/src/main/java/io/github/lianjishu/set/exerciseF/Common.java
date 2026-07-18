package io.github.lianjishu.set.exerciseF;

import java.util.Comparator;

public final class Common {
    private Common() {
    }

    //封装比较器
    /**
     * 总分从高到低
     */
    public static final Comparator<Student> BY_TOTAL = Comparator.comparingInt(Student::getTotalScore).reversed();
    /**
     * 语文从高到低
     */
    public static final Comparator<Student> BY_CHINESE = Comparator.comparingInt(Student::getChinese).reversed();
    /**
     * 数学从高到低
     */
    public static final Comparator<Student> BY_MATH = Comparator.comparingInt(Student::getMath).reversed();
    /**
     * 英语从高到低
     */
    public static final Comparator<Student> BY_ENGLISH = Comparator.comparingInt(Student::getEnglish).reversed();
    /**
     * 年龄从低到高
     */
    public static final Comparator<Student> BY_AGE = Comparator.comparingInt(Student::getAge);
    /**
     * 姓名按字母序(忽略大小写)
     */
    public static final Comparator<Student> BY_NAME = Comparator.comparing(Student::getName, String::compareToIgnoreCase);
}
