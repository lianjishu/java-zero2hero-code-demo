package bytestream.tryout.fileoutputstream;

import common.Path;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * void write(int b) 一次写一个字节数据
 * void write(byte[] b) 一次写一个字节数组数据
 * void write(byte[] b, int off, int len) 一次写一个字节数组的部分数据
 */
public class Way2Write {
    private static void way2Write() throws IOException {
        try (//1. 创建对象
             FileOutputStream fos1 = new FileOutputStream(Path.RSRC_PATH + "\\fileoutputstream\\way2WriteA.txt");
             FileOutputStream fos2 = new FileOutputStream(Path.RSRC_PATH + "\\fileoutputstream\\way2WriteB.txt");
             FileOutputStream fos3 = new FileOutputStream(Path.RSRC_PATH + "\\fileoutputstream\\way2WriteC.txt")) {

            //一次写一个字节数据
            fos1.write(97);
            //一次写一个字节数组数据
            //用方法String.getBytes()即可把字符转为ASCII编码
            byte[] letters = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
            fos2.write(letters);
            //一次写一个字节数组的部分数据
            fos3.write(letters, 0, 3);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            way2Write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
