package exception.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 键盘录入数据
 *
 * <p>需求：
 * <ul>
 *   <li>键盘录入自己心仪的女朋友姓名和年龄。</li>
 *   <li>姓名的长度在3~10之间，</li>
 *   <li>年龄的范围为 18 - 40岁，</li>
 *   <li>超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。</li>
 * </ul>
 *
 * <p>提示：
 * <ul>
 *   <li>需要考虑用户在键盘录入时的所有情况。</li>
 *   <li>比如：录入年龄时超出范围，录入年龄时录入了abc等情况</li>
 * </ul>
 */
public class InputInfo {
    private static Scanner sc = new Scanner(System.in);

    public static Girlfriend input() {
        Girlfriend gf = new Girlfriend();
        while (true) {
            try {
                System.out.println("输入心仪女生的姓名: ");
                String name = sc.nextLine();
                gf.setName(name);
                System.out.println("输入心仪女生的年龄: ");
                String strAge = sc.nextLine();
                gf.setAge(Integer.parseInt(strAge));
                break;
            } catch (NumberFormatException e) {
                System.err.println("年龄格式有误, 请输入数字");
            } catch (IllegalArgumentException e) {
                System.err.println("姓名的长度或年龄的范围有误");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return gf;
    }

    public static void main(String[] args) {
        System.out.println(input());
    }
}
