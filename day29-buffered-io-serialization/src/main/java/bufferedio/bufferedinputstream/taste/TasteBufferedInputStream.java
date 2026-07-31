package bufferedio.bufferedinputstream.taste;

import java.io.*;

public class TasteBufferedInputStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("day29-buffered-io/src/main/java/bufferedinputstream/taste/aaa.txt")
        );
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("day29-buffered-io/src/main/java/bufferedinputstream/taste/bbb.txt")
        );

        try (bis; bos) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        }
    }
}
