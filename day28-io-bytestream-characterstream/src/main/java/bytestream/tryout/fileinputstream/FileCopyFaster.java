package bytestream.tryout.fileinputstream;

import common.Path;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyFaster {
    //传统try-catch-finally写法
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(Path.RSRC_PATH + "\\fileinputstream\\Freya-Mayer.jpg");
            fos = new FileOutputStream(Path.RSRC_PATH + "\\fileinputstream\\output\\Freya-Mayer-copied.jpg");

            int len;
            byte[] buffer = new byte[1024 * 1024 * 5];

            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
