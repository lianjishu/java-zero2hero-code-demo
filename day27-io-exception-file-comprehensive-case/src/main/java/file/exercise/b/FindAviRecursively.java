package file.exercise.b;

import java.io.File;
import java.text.Format;

/**
 * [练习] File类相关的API的练习题
 * <p>
 * 需求：
 * 找到电脑中所有以.avi结尾的电影。
 * （需要考虑子文件夹）
 * <p>
 * <p>
 * C:\\
 * <p>
 * C:\\aaa
 * <p>
 * C:\\bbb
 */
public class FindAviRecursively {
    private static void recur(File src) {
        File[] files = src.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    if (f.getName().endsWith(".mp4")) System.out.println(f.getName());
                } else {
                    recur(f);
                }
            }
        }
    }

    private static void solution(File drive) {
        recur(drive);
    }

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File r : roots)
            solution(r);
    }
}
