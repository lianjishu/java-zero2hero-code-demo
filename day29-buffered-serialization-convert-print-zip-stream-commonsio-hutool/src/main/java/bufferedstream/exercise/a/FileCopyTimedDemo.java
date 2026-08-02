package bufferedstream.exercise.a;

import java.io.*;

/**
 * 文件拷贝四种实现方式，并且统计每种拷贝耗时
 * <ol>
 * <li>字节基本流：一次读写单个字节</li>
 * <li>字节基本流：一次读写字节数组</li>
 * <li>字节缓冲流：一次读写单个字节</li>
 * <li>字节缓冲流：一次读写字节数组</li>
 * </ol>
 */
public class FileCopyTimedDemo {
    private static long withFIOS1() throws IOException {
        FileInputStream fis = new FileInputStream("day29-buffered-io/src/main/java/exercise/a/csb.txt");
        FileOutputStream fos = new FileOutputStream("day29-buffered-io/src/main/java/exercise/a/csb1.txt");
        long start = System.currentTimeMillis();
        try (fis; fos) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long withFIOS2() throws IOException {
        FileInputStream fis = new FileInputStream("day29-buffered-io/src/main/java/exercise/a/csb.txt");
        FileOutputStream fos = new FileOutputStream("day29-buffered-io/src/main/java/exercise/a/csb2.txt");

        long start = System.currentTimeMillis();
        try (fis; fos) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long withBIOS1() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day29-buffered-io/src/main/java/exercise/a/csb.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day29-buffered-io/src/main/java/exercise/a/csb3.txt"));
        long start = System.currentTimeMillis();
        try (bis; bos) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long withBIOS2() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day29-buffered-io/src/main/java/exercise/a/csb.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day29-buffered-io/src/main/java/exercise/a/csb4.txt"));
        long start = System.currentTimeMillis();
        try (bis; bos) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws IOException {
        long timed1 = withFIOS1();
        long timed2 = withFIOS2();
        long timed3 = withBIOS1();
        long timed4 = withBIOS2();

        System.out.printf("字节基本流：一次读写单个字节 -> %dms%n", timed1);
        System.out.printf("字节基本流：一次读写字节数组 -> %dms%n", timed2);
        System.out.printf("字节缓冲流：一次读写单个字节 -> %dms%n", timed3);
        System.out.printf("字节缓冲流：一次读写字节数组 -> %dms%n", timed4);
    }
}
