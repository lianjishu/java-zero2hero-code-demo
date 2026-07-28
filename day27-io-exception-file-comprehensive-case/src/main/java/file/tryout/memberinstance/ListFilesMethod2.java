package file.tryout.memberinstance;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * public File[] listFiles(FileFilter filter)        利用文件名过滤器获取当前该路径下所有内容
 * public File[] listFiles(FilenameFilter filter)     利用文件名过滤器获取当前该路径下所有内容
 */
public class ListFilesMethod2 {
    public static void main(String[] args) {
        //创建File对象
        File f = new File("D:\\aaa");
        //调用listFiles
        File[] arr = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
