package file.exercise.c;

import java.io.File;

/**
 * [练习] File类相关的API的练习题
 * <p>
 * 需求：
 * 删除一个多级文件夹
 */
public class DeleteMultiLevelDir {
    private static void solution(File src) {
        File[] files = src.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName() + "Deleted");
                    f.delete();
                } else {
                    solution(src);
                }
            }
        }
    }

    public static void main(String[] args) {
        File target = new File("E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day27-io-exception-file-comprehensive-case\\src\\main\\resources\\file.exercise.c\\deleteA");
        solution(target);
    }
}
