package exercise.b;

import javax.annotation.processing.Filer;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * 修改文本顺序练习
 * <p>需求：读取顺序打乱的《出师表》文本文件，按照序号恢复文章正确顺序，将整理完成的内容写入全新文件。</p>
 * <p>实现思路：
 * 1. 读取源文件所有文本行；
 * 2. 提取每行的序号，对文本内容进行升序排序；
 * 3. 将排序后的完整《出师表》文本输出至新文件保存。
 * </p>
 */
public class SortTextOrderDemo {
    static TreeMap<Integer, String> ts = new TreeMap<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day29-buffered-io/src/main/java/exercise/b/csb.txt"));

        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line.charAt(0));
                System.out.println(line.substring(2));
                ts.put(line.charAt(0) - '0', line.substring(2));
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("day29-buffered-io/src/main/java/exercise/b/csb.txt"));

        try (bw) {
            Set<Map.Entry<Integer, String>> entries = ts.entrySet();
            for (var e : entries) {
                bw.write(e.getKey() + "." + e.getValue());
                bw.newLine();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
