import java.util.Scanner;
public class If_Demo2 {
    public static void main(String[] args) {
        /* if的第二种格式 */
        // 需求
        // 键盘录入一个整数, 表示身上所带的钱(元)
        // 如果大于100元, 就吃网红餐厅
        // 否则吃经济实惠的沙县小吃
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        if (money >= 100)
            System.out.println("去吃网红餐厅");
        else
            System.out.println("去吃经济实惠的沙县小吃");
    }
}
