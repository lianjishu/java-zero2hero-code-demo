package bufferedstream.exercise.c;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 软件运行次数验证小程序
 * <p>需求说明：限制软件免费使用次数，最多允许免费运行3次</p>
 * <ul>
 *     <li>第1次运行：控制台输出 欢迎使用本软件,第1次使用免费~</li>
 *     <li>第2次运行：控制台输出 欢迎使用本软件,第2次使用免费~</li>
 *     <li>第3次运行：控制台输出 欢迎使用本软件,第3次使用免费~</li>
 *     <li>第4次以及后续运行：控制台输出 本软件只能免费使用3次,欢迎您注册会员后继续使用~</li>
 * </ul>
 * <p>实现原理：通过文件持久化存储累计运行次数，程序启动读取次数，执行完成后更新次数保存到文件</p>
 */
public class softwareRunLimitDemo {
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        File f = new File("day29-buffered-io/src/main/java/exercise/c/.env");
        int cnt = 1;

        cnt = configLoader();
        if (cnt < 4) System.out.println("欢迎使用本软件,第" + cnt + "次使用免费~");
        else {
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
        }
        configUpdater("count=" + cnt + ";");
    }

    private static void initConfig() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("day29-buffered-io/src/main/java/exercise/c/.env"));

        try (bw) {
            bw.write("config=0");
        }
    }

    private static int configLoader() throws IOException {
        var br = new BufferedReader(new FileReader("day29-buffered-io/src/main/java/exercise/c/.env"));
        String config;
        int cnt = 0;
        try (br) {
            while ((config = br.readLine()) != null) {
                Pattern p = Pattern.compile("count=(\\d+);");
                Matcher m = p.matcher(config);
                if (m.find())
                    cnt = Integer.valueOf(m.group(1));
            }
        }
        return cnt;
    }

    private static void configUpdater(String str) throws IOException {
//        String str = "count=0;";
        Pattern p = Pattern.compile("(count=)(\\d+)(;)");
        Matcher m = p.matcher(str);
        String result = null;
        if (m.find()) {
            int num = Integer.valueOf(m.group(2)); // 取出数字
            num = num + 1;                         // 递增
            result = m.group(1) + num + m.group(3); // 拼接：count= + 新数字 + ;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("day29-buffered-io/src/main/java/exercise/c/.env"));

        try (bw) {
            bw.write(result);
        }
    }

}