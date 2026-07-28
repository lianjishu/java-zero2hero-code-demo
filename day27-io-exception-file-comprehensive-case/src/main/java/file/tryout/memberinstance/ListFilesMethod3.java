package file.tryout.memberinstance;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class ListFilesMethod3 {
    public static void main(String[] args) {
        //创建File对象
        File f = new File("D:\\aaa");

        //调用listFiles(FileFilter filter)
        File[] arr = f.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        //调用listFiles(FilenameFilter filter)
        f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir);
                System.out.println(name);
                System.out.println("----------------------");
                return false;
            }
        });
    }
}
