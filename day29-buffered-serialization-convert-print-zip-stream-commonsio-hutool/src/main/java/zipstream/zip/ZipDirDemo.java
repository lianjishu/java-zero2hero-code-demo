package zipstream.zip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class ZipDirDemo {
    private static void zipDir(String src, String dest) throws IOException {
        /**
         * 1.处理路径
         * src = "resources/aaa"
         * dest = "resources/myzip/" + "aaa.zip"
         *
         * 2.
         */
        File srcFile = new File(src);
        File destFile = new File(dest);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(srcFile));
        try(zos) {
            
        }
    }

    public static void main(String[] args) throws IOException {


    }
}
