import java.util.ArrayList;
import java.util.Scanner;

public class StudentMS {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> data = new ArrayList<>();

    public StudentMS() {}

    private static void ui() {
        System.out.println("<--------- 欢迎使用学生管理系统 --------->");
        System.out.println("<---------- [1] 添加学生 -------------->");
        System.out.println("<---------- [2] 删除学生 -------------->");
        System.out.println("<---------- [3] 修改学生 -------------->");
        System.out.println("<---------- [4] 查询学生 -------------->");
        System.out.println("<---------- [5] 展示所有学生 ----------->");
        System.out.println("<---------- [0] 退出系统 -------------->");
        System.out.println("<------------------------------------->");
    }

    private static int find(String id) {
        for (int i = 0; i < data.size(); ++i) {
            if(data.get(i).getSid() == id)
                return i;
        }
        return -1;
    }

    public static void core() {
        while(true) {
            ui();
            System.out.println("请输入你的选择");
            int selection = sc.nextInt();
            switch (selection) {
                case 1 -> addStudent();
                case 2 -> delStudent();
                case 3 -> updateStudent();
                case 4 -> findStudent();
                case 5 -> showAll();
                case 0 -> exit();
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private static void addStudent() {
        System.out.println("----------- 添加学生 --------------");
        System.out.println("请输入学生ID");
        String id = sc.next();
        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生地址");
        String address = sc.next();
        System.out.println("添加成功！");
        Student stu = new Student(id, name, age, address);
        data.add(stu);
    }

    private static void delStudent() {
        System.out.println("----------- 删除学生 --------------");
        if(data.isEmpty()) {
            System.out.println("当前暂无学生数据");
            return;
        }
        System.out.println("请输入所要删除学生的ID");
        String id = sc.next();
        int idx = find(id);
        int count = 1;
        while (count <= 3) {
            if(idx<0) {
                System.out.println("查无此人，请重新输入ID");
                idx = find(sc.next());
                ++ count;
            }else{
                System.out.println("确定要删除吗? [Y/n]");
                String response = sc.next();
                if(response.equals("Y") || response.equals("y") || response.equals("yes") || response.equals("YES"))
                    data.remove(idx);
                else if(response.equals("N") || response.equals("n") || response.equals("NO") || response.equals("no"))
                    System.out.println("取消成功! ");
                break;
            }
        }
    }

    private static void updateStudent() {
        System.out.println("----------- 更新学生 --------------");
        if(data.isEmpty()) {
            System.out.println("当前暂无学生数据");
            return;
        }
        System.out.println("请输入所要更改的学生的ID");
        String id = sc.next();
        int idx = find(id);
        int count = 1;
        while (count <= 3) {
            if(idx<0) {
                System.out.println("查无此人，请重新输入ID");
                idx = find(sc.next());
                count ++;
            }else{
                System.out.println("请输入新的姓名(若此项无需修改, 输入0跳过)");
                String name = sc.next();
                if(!name.equals("0")) {
                    data.get(idx).setName(name);
                }
                System.out.println("请输入新的年龄(若此项无需修改, 输入0跳过)");
                int age = sc.nextInt();
                if(age != 0)
                    data.get(idx).setAge(age);
                break;
            }
        }

    }

    private static void findStudent() {
        System.out.println("----------- 查找学生 --------------");
        if(data.isEmpty()) {
            System.out.println("当前暂无学生数据");
            return;
        }
        System.out.println("请输入所要查找的学生的ID");
        String id = sc.next();
        int idx = find(id);
        int count = 1;
        while (count <= 3) {
            if(idx<0) {
                System.out.println("查无此人，请重新输入ID");
                idx = find(sc.next());
                count ++;
            }else{
                data.get(idx).showSelf();
                break;
            }
        }
    }

    private static void showAll() {
        if(data.isEmpty()) {
            System.out.println("当前暂无学生数据");
            return;
        }
        for (Student datum : data) {
            datum.showSelf();
            System.out.println("--------------------------");
        }
    }

    private static void exit() {
        System.out.println("退出");
        //break loop;
        System.exit(0);//停止虚拟机运行
    }
}