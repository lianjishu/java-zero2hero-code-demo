package tastelib.hutool;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;

/**
 * FileUtil类：
 * file: 根据参数创建一个file对象
 * touch: 根据参数创建文件
 * <p>
 * writeLines: 把集合中的数据写出到文件中，覆盖模式。
 * appendLines: 把集合中的数据写出到文件中，续写模式。
 * readLines: 指定字符编码，把文件中的数据，读到集合中。
 * readUtf8Lines: 按照UTF-8的形式，把文件中的数据，读到集合中
 * <p>
 * copy: 拷贝文件或者文件夹
 */
public class TasteHutoolFileUtil {
    public static void main(String[] args) {
        File f = FileUtil.file(
                "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\",
                "day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool",
                "src",
                "main",
                "resources",
                "tasteHutool",
                "a.txt"
        );
        FileUtil.touch(f);
        System.out.println(f);


        ArrayList<String> list = new ArrayList<>();
        FileUtil.writeLines(list, f, "UTF-8", true);
        FileUtil.appendLines(list, f, "UTF-8");

    }
}
