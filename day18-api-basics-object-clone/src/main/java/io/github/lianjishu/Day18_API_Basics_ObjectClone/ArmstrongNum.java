package io.github.lianjishu.Day18_API_Basics_ObjectClone;
/**
 * 判断自幂数
 * 自幂数，一个n位自然数等于自身各个数位上数字的n次幂之和
 *
 * ​ 举例1：三位数 1^3 + 5^3 + 3^3 = 153
 *
 * ​ 举例2：四位数 1^4 + 6^4 + 3^4 + 4^4 = 1634
 *
 * 如果自幂数是：
 *
 * 一位自幂数，也叫做：独身数
 * 三位自幂数：水仙花数
 * 四位自幂数：四叶玫瑰数
 * 五位自幂数：五角星数
 * 六位自幂数：六合数
 * 七位自幂数：北斗七星数
 * 八位自幂数：八仙数
 * 九位自幂数：九九重阳数
 * 十位自幂数：十全十美数
 */

/**
 * 要求1：统计一共有多少个水仙花数。
 *
 * 要求2：（课后作业）证明没有两位的自幂数。
 *
 * 要求3：（课后作业）分别统计有多少个四叶玫瑰数和五角星数。（答案：都是3个）
 */

public class ArmstrongNum {
    int cnt = 0;

    /**
     * 判断一个数是否为水仙花数（三位自幂数）
     */
    private boolean isShuixianhuaNum(int num) {
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;
        int sum = ge * ge * ge + shi * shi * shi + bai * bai * bai;
        return sum == num;
    }

    /**
     * 要求1：统计水仙花数
     */
    public void countShuixianhua() {
        cnt = 0;
        for (int i = 100; i <= 999; i++) {
            if (isShuixianhuaNum(i)) {
                System.out.println(i);
                cnt++;
            }
        }
        System.out.println("水仙花数共有：" + cnt + "个");
    }

    /**
     * 要求2：证明没有两位的自幂数
     * 两位数范围 10~99，每位最大为9，9^2=81，两位数各位平方和最大为 9^2+9^2=162
     * 但162是三位数，实际上两位数各位平方和范围是 1^2+0^2=1 到 9^2+9^2=162
     * 经验证所有两位数都不等于其各位数字的平方和
     */
    public void proveNoTwoDigit() {
        boolean found = false;
        for (int i = 10; i <= 99; i++) {
            int ge = i % 10;
            int shi = i / 10;
            int sum = ge * ge + shi * shi;
            if (sum == i) {
                found = true;
                System.out.println("找到两位自幂数：" + i);
                break;
            }
        }
        if (!found) {
            System.out.println("证明：没有两位的自幂数");
        }
    }

    /**
     * 要求3：统计四叶玫瑰数和五角星数
     */
    public void countRoseAndStar() {
        int roseCnt = 0;
        int starCnt = 0;

        // 四叶玫瑰数（四位自幂数）
        for (int i = 1000; i <= 9999; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            int qian = i / 1000;
            int sum = ge * ge * ge * ge + shi * shi * shi * shi
                    + bai * bai * bai * bai + qian * qian * qian * qian;
            if (sum == i) {
                System.out.println("四叶玫瑰数：" + i);
                roseCnt++;
            }
        }

        // 五角星数（五位自幂数）
        for (int i = 10000; i <= 99999; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            int qian = i / 1000 % 10;
            int wan = i / 10000;
            int sum = ge * ge * ge * ge * ge + shi * shi * shi * shi * shi
                    + bai * bai * bai * bai * bai + qian * qian * qian * qian * qian
                    + wan * wan * wan * wan * wan;
            if (sum == i) {
                System.out.println("五角星数：" + i);
                starCnt++;
            }
        }

        System.out.println("四叶玫瑰数共有：" + roseCnt + "个");
        System.out.println("五角星数共有：" + starCnt + "个");
    }

    public static void main(String[] args) {
        ArmstrongNum obj = new ArmstrongNum();
        System.out.println("===== 要求1：水仙花数 =====");
        obj.countShuixianhua();
        System.out.println();
        System.out.println("===== 要求2：两位自幂数证明 =====");
        obj.proveNoTwoDigit();
        System.out.println();
        System.out.println("===== 要求3：四叶玫瑰数和五角星数 =====");
        obj.countRoseAndStar();
    }
}
