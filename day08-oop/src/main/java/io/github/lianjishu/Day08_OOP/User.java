package io.github.lianjishu.Day08_OOP;

public class User {
    // 属性
    private String user_name;
    private String pass_word;
    private String e_mail;
    private String gender;
    private byte age;
    // 空参构造
    public User() {}
    // 有参构造
    public User(String u_name, String p_word, String e_mail, String gender, byte age) {
        this.user_name = u_name;
        this.pass_word = p_word;
        this.e_mail = e_mail;
        this.gender = gender;
        this.age = age;
    }
    // 方法
    public String getUname() {
        return this.user_name;
    }
    public String getPword() {
        return this.pass_word;
    }
    public String getE_mail() {
        return this.e_mail;
    }
    public String getGender() {
        return this.gender;
    }
    public int getAge() {
        return this.age;
    }

    public void setUname(String u_name) {
        this.user_name = u_name;
    }
    public void setPword(String p_word) {
        this.pass_word = p_word;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(byte age) {
        this.age = age;
    }
}
