package zipstream.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileDemo {
    private static final String src = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day29-buffered-serialization-convert-print-zip-stream\\src\\main\\resources\\file.txt";
    private static final String dest = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day29-buffered-serialization-convert-print-zip-stream\\src\\main\\resources\\file.zip";

    private static void zipFile() throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        FileInputStream fis = new FileInputStream(src);

        try (zos; fis) {
            ZipEntry entry = new ZipEntry("zipEntry.txt");
            zos.putNextEntry(entry);
            byte[] buffer = new byte[8192];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
        }
    }

    public static void main(String[] args) throws IOException {
        zipFile();
    }
}
