package file.exercise.a;

import java.io.File;
import java.util.Arrays;

/**
 * [练习] File类相关的API的练习题
 * <p>
 * 需求：
 * 定义一个方法找某一个文件夹中，是否有以avi结尾的电影。
 * （暂时不需要考虑子文件夹）
 * <p>
 * <p>
 * D:\\aaa
 * <p>
 * D:\\aaa\\bbb
 * <p>
 * D:\\aaa\\ccc
 */
public class FindAvi {
    private static boolean solution(String targetPath) {
        File targetFile = new File(targetPath);
        File[] files = targetFile.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".avi")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var res = solution("E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day27-io-exception-file-comprehensive-case\\src\\main\\resources\\file\\exercise\\a");
        System.out.println(res);
    }
}
