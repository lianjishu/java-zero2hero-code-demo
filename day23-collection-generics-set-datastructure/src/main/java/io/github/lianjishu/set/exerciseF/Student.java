package io.github.lianjishu.set.exerciseF;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private AcademicScores scores;

    public Student() {
    }

    public Student(String name, int age, AcademicScores scores) {
        this.name = name;
        this.age = age;
        this.scores = scores;
    }

    public Student(String name, int age, int chinese, int math, int english) {
        this.name = name;
        this.age = age;
        this.scores = new AcademicScores(chinese, math, english);
    }

    public int getTotalScore() {
        return this.scores.getTotalScores();
    }

    public int getChinese() {
        return this.scores.getChinese();
    }

    public int getMath() {
        return this.scores.getMath();
    }

    public int getEnglish() {
        return this.scores.getEnglish();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AcademicScores getScores() {
        return scores;
    }

    public void setScores(AcademicScores scores) {
        this.scores = scores;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + ((scores == null) ? 0 : scores.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        if (scores == null) {
            if (other.scores != null)
                return false;
        } else if (!scores.equals(other.scores))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", scores=" + scores.toString() + "]";
    }

    /**
     * <li>按照总分从高到低</li>
     * <li>如果总分一样，按照语文成绩排(从高到低)</li>
     * <li>如果语文一样，按照数学成绩排(从高到低)</li>
     * <li>如果数学成绩一样，按照英语成绩排(从高到低)</li>
     * <li>如果英语成绩一样，按照年龄排(从小到大)</li>
     * <li>如果年龄一样，按照姓名的字母顺序排</li>
     * <li>如果都一样，认为是同一个学生。</li>
     */
    @Override
    public int compareTo(Student o) {
        // 总分:降序 (o 在前 → o 大时返回负值 → o 排前面)
        int byTotal = Integer.compare(o.scores.getTotalScores(), this.scores.getTotalScores());
        if (byTotal != 0)
            return byTotal;
        // 语文:降序
        int byChinese = Integer.compare(o.scores.getChinese(), this.scores.getChinese());
        if (byChinese != 0)
            return byChinese;
        // 数学:降序
        int byMath = Integer.compare(o.scores.getMath(), this.scores.getMath());
        if (byMath != 0)
            return byMath;
        // 英语:降序
        int byEnglish = Integer.compare(o.scores.getEnglish(), this.scores.getEnglish());
        if (byEnglish != 0)
            return byEnglish;
        // 年龄:升序
        int byAge = Integer.compare(this.getAge(), o.getAge());
        if (byAge != 0)
            return byAge;
        // 姓名:字母序(忽略大小写)
        return this.name.compareToIgnoreCase(o.getName());
    }

}
