package bytestream.tryout.fileinputstream;

import common.Path;

import java.io.FileInputStream;
import java.io.IOException;

public class LoopReading {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream(Path.RSRC_PATH + "\\fileinputstream\\LoopReading.txt")) {
            int b;
            while ((b = fis.read()) != -1) System.out.print((char) b);
        }
    }
}
