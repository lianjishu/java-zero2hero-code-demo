package exercise.c;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 * # 练习
 * <p>
 * 修改文件中的数据
 * <p>
 * 文本文件中有以下的数据：
 * <p>
 * 2-1-9-4-7-8
 * <p>
 * 将文件中的数据进行排序，变成以下的数据：
 * <p>
 * 1-2-4-7-8-9
 */
public class ModifyFile {
    private static TreeSet<Integer> ts = new TreeSet<>();

    private static void solution() throws IOException {
        String oldData = doRead("day28-io-bytestream-characterstream/src/main/java/exercise/c/file.txt");
        String[] split = oldData.split("-");
        for (int i = 0; i < split.length; ++i) {
            ts.add(Integer.parseInt(split[i]));
        }
        StringBuilder newSb = new StringBuilder();
        ts.forEach(i -> newSb.append(i + "-"));
        newSb.deleteCharAt(newSb.length() - 1);
        doWrite(newSb);
    }

    private static String doRead(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(fileName);
        try (fr) {
            char[] buffer = new char[8];
            int len;

            while ((len = fr.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static String doWrite(StringBuilder sb) throws IOException {
        String toWrite;
        sb = new StringBuilder();
        for (var e : ts) {
            sb.append(e).append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        toWrite = sb.toString();

        FileWriter fw = new FileWriter("day28-io-bytestream-characterstream/src/main/java/exercise/c/file.txt");
        try (fw) {
            fw.write(toWrite);
        }

        return toWrite;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
