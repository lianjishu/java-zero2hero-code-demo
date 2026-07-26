package methodrefs.exercise.common;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String text) {
        if (text == null || text.equals("")) {
            this.age = 0;
            this.name = "";
            return;
        }
        String[] split = text.split(",");
        this.name = split[0];
        this.age = Integer.parseInt(split[1]);
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getDescription() {
        return this.name + "-" + this.age;
    }
}
