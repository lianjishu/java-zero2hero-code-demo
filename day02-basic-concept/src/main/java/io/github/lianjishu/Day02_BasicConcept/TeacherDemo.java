package io.github.lianjishu.Day02_BasicConcept;
class Teacher {
    String name;
    int age;
    char gender;
    double height;
    boolean marital_status;

    public Teacher(String name, int age, char gender, double height, boolean mari_status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        if(mari_status)
            this.marital_status = true;
        else
            this.marital_status = false;
    }

    public void show_info(){
        System.out.println("Name\t" + this.name);
        System.out.println("Age\t" + this.age);
        System.out.println("Gender\t" + this.gender);
        System.out.println("Height\t" + this.height);
        System.out.println("Marital Status\t" + this.marital_status);

        System.out.println("\n-----------------------\n");
    }
}

public class TeacherDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("张三", 26, '男', 172.0, true);
        teacher.show_info();
    }
}