package file.tryout.constructor;

import java.io.File;
import java.io.FileFilter;

/**
 * public File(String pathname)                    根据文件路径创建文件对象
 * public File(String parent, String child)        根据父路径名字符串和子路径名字符串中创建文件对象
 * public File(File parent, String child)          根据父路径对应文件对象和子路径名字符串中创建文件对象
 * <p>
 * C:\Users\alienware\Desktop
 */
public class TryOutConstructor {
    public static void main(String[] args) {
        String pathname = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day27-io-exception-file-comprehensive-case\\src\\main\\java\\file\\tryout\\constructor\\f1.txt";
        File f1 = new File(pathname);

        String parent = "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day27-io-exception-file-comprehensive-case\\src\\main\\java\\file\\tryout\\constructor";
        String child = "f2.txt";
        File f2 = new File(parent, child);

        File parent2 = new File("E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day27-io-exception-file-comprehensive-case\\src\\main\\java\\file\\tryout\\constructor");
        String child2 = "f3.txt";
        File f3 = new File(parent2, child2);
    }
}
