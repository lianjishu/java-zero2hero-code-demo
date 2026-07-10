package io.github.lianjishu.FiveExercises.SortExercise;

public class GirlFriend {
    private String name; // 姓名
    private int age; // 年龄
    private double height; // 身高
    private double bust; // 胸围
    private double waist; // 腰围
    private double hips; // 臀围

    public GirlFriend() {
    }

    public GirlFriend(String name, int age, double height, double bust, double waist, double hips) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBust(double bust) {
        this.bust = bust;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getBust() {
        return bust;
    }

    public double getWaist() {
        return waist;
    }

    public double getHips() {
        return hips;
    }

    // 重写 toString 方法，方便打印输出看结果
    @Override
    public String toString() {
        return "Girlfriend{name='" + name + "', age=" + age + ", height=" + height +
                ", bust=" + bust + ", waist=" + waist + ", hips=" + hips + "}";
    }
}