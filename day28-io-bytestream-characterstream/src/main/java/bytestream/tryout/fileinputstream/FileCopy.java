package bytestream.tryout.fileinputstream;

import common.Path;

import java.io.*;

/**
 * 文件拷贝
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {

        try (
                FileInputStream fis = new FileInputStream(Path.RSRC_PATH + "\\fileinputstream\\Freya-Mayer.jpg");
                FileOutputStream fos = new FileOutputStream(Path.RSRC_PATH + "\\fileinputstream\\output\\Freya-Mayer-copied.jpg")) {
            long start = System.currentTimeMillis();

            int mayer;
            while ((mayer = fis.read()) != -1) {
                fos.write(mayer);
            }
            long end = System.currentTimeMillis();
            System.out.println("用时" + ((end - start) / 1000L) + "s");
        }
    }
}
