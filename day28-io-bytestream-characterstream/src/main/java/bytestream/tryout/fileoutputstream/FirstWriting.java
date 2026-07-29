package bytestream.tryout.fileoutputstream;

import common.Path;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示：字节输出流FileOutputStream
 * <p>
 * 实现需求：写出一段文字到本地文件中。 （暂时不写中文）
 * <p>
 * 实现步骤：
 * <p>
 * 创建对象
 * <p>
 * 写出数据
 * <p>
 * 释放资源
 */
public class FirstWriting {
    public static void main(String[] args) throws IOException {
        //创建对象
        FileOutputStream fos = new FileOutputStream(Path.RSRC_PATH + "\\fileoutputstream\\FirstWriting.txt");
        //写出数据
        fos.write(99);
        fos.close();
    }
}
