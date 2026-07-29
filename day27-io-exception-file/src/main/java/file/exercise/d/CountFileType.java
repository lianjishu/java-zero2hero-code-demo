package file.exercise.d;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * [练习] File类相关的API的练习题
 * <p>
 * 需求：
 * 统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
 * <p>
 * ①  打印格式如下：
 * <p>
 * ②          txt:3个
 * <p>
 * ③          doc:4个
 * <p>
 * ④          jpg:6个
 */
public class CountFileType {
    static HashMap<String, Integer> hm = new HashMap<>();

    private static void solution(File file) {
        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (File f : fileList) {
                if (f.isFile()) {
                    String extension = getExtension(f.getName());
                    if (hm.containsKey(extension)) {
                        hm.put(extension, hm.get(extension) + 1);
                    } else {
                        hm.put(extension, 1);
                    }
                } else {
                    solution(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        String TARGET = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo";
        solution(new File(TARGET));
        Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();
        System.out.println(entrySet);
    }

    private static String getExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf(".");
        if (i > 0 && i < fileName.length() - 1) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
}
