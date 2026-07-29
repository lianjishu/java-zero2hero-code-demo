package charactorstream.tryout.filereader;

import common.Path;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 第一步：创建对象
 * public FileReader(File file)    创建字符输入流关联本地文件
 * public FileReader(String pathname) 创建字符输入流关联本地文件
 * <p>
 * 第二步：读取数据
 * public int read()    读取数据，读到末尾返回-1
 * public int read(char[] buffer) 读取多个数据，读到末尾返回-1
 * <p>
 * 第三步：释放资源
 * public void close()    释放资源/关流
 */
public class TryOutFileReader1 {
    public static void main(String[] args) throws FileNotFoundException {
        //创建对象
        FileReader fr = new FileReader(Path.RSRC_PATH + "\\filereader\\a.txt");
        try (fr) {
            //读取数据
            int buffer; //11100110 10110001 10001001 -> 27721自动解码并转化为十进制
            while ((buffer = fr.read()) != -1) {
                System.out.print((char) buffer);
            }//释放资源
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
