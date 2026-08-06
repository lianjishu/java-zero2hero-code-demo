package io.github.lianjishu.reflection.tryout.getconstructor;

/**
 * 用于演示反射获取成员方法的 User 类.
 * <p>
 * 故意提供多种修饰符 (public / private / static)、
 * 不同参数 (无参 / 有参 / 基本类型 / 引用类型 / 数组)、
 * 不同返回值 (void / 基本类型 / 对象 / 数组) 的方法,
 * 以便 {@link Way2GetMethod} 演示 {@code getMethods} /
 * {@code getDeclaredMethods} / {@code getMethod} /
 * {@code getDeclaredMethod} / {@code invoke} 等 API.
 */
public class User {

    // ==================== 字段 ====================

    private String id;
    private String name;
    private int age;
    private static String COMPANY = "传智教育";
    public static final String COUNTRY = "湖南";

    // ==================== 构造方法 ====================

    private User(String id) {
        this.id = id;
    }

    public User(String id, String name, int age) {
        this(id);
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    // ==================== Getter / Setter ====================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static String getCompany() {
        return COMPANY;
    }

    public static void setCompany(String company) {
        User.COMPANY = company;
    }

    // ==================== public 成员方法 (无参) ====================

    public void sayHello() {
        System.out.println("Hello, 我叫 " + name + ", 今年 " + age + " 岁");
    }

    public String introduce() {
        return "大家好, 我是 " + name + ", 工号 " + id;
    }

    public int getBirthYear() {
        return 2026 - age;
    }

    // ==================== public 成员方法 (有参) ====================

    public void work(String task) {
        System.out.println(name + " 正在 " + task);
    }

    public String greet(String who) {
        return name + " 向 " + who + " 打招呼: 你好呀!";
    }

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isAdult(int age) {
        return age >= 18;
    }

    public String[] splitName() {
        return name == null ? new String[0] : name.split("");
    }

    public User copyWithName(String newName) {
        return new User(this.id, newName, this.age);
    }

    // ==================== private 成员方法 (无参 / 有参) ====================

    private void privateDoNothing() {
        System.out.println("[private] 偷偷做点什么, 不想被外人知道");
    }

    private String privateSecret() {
        return "[private] id=" + id + " 的小秘密: 其实我很喜欢打王者";
    }

    private int privateCalculate(int a, int b, int c) {
        return a + b * c;
    }

    private boolean privateCheck(String s) {
        return s != null && !s.isEmpty();
    }

    // ==================== public static 方法 ====================

    public static void printLogo() {
        System.out.println("=== " + COMPANY + " LOGO ===");
    }

    public static String getCountry() {
        return COUNTRY;
    }

    public static int sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    public static User createGuest(String name) {
        return new User("GUEST-" + System.nanoTime(), name, 18);
    }

    // ==================== private static 方法 ====================

    private static String privateFormatId(String id) {
        return "[ID-" + id + "]";
    }

    private static void privateLog(String msg) {
        System.out.println("[private static log] " + msg);
    }

    // ==================== Object 方法 ====================

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}