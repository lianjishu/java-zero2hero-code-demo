package zipstream.unzip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipDemo {

    private static final String src = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day29-buffered-serialization-convert-print-zip-stream\\src\\main\\resources\\aaa.zip";
    private static final String dest = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day29-buffered-serialization-convert-print-zip-stream\\src\\main\\resources\\copy";

    private static void unzip() throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry zentry;
        try (zis) {
            while ((zentry = zis.getNextEntry()) != null) {
                if (zentry.isDirectory()) {//文件夹: 在dist下创建此文件夹
                    new File(dest, zentry.getName()).mkdirs();
                } else {//文件: 拷贝此文件
                    zentry.getName();//resources\aaa\kkk.txt -> //resources\copy\aaa\kkk.txt
                    FileOutputStream fos = new FileOutputStream(new File(dest, zentry.getName()));
                    try (fos) {
                        byte[] buffer = new byte[8192];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            fos.write(buffer, 0, len);
                        }
                        //fos.close();
                    }
                }
                zis.closeEntry();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        unzip();
    }
}
