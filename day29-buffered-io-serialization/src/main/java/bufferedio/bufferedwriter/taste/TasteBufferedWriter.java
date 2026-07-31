package bufferedio.bufferedwriter.taste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TasteBufferedWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("day29-buffered-io/src/main/java/bufferedwriter/taste/aaa.txt", true));

        try (bw) {
            bw.write("你嘴角上揚的樣子，百度搜不到");
            bw.newLine();
            bw.write("以後如果我結婚了，你一定要來，沒有新娘我會很尷尬。。。");
        }
    }
}
