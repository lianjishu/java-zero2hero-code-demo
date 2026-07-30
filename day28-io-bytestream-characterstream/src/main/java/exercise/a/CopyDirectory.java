package exercise.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * # 拷贝
 * <p>
 * 需求：
 * <p>
 * 拷贝一个文件夹，考虑子文件夹
 */
public class CopyDirectory {
    private static void solution() throws IOException {
        doCopyDir(
                new File("day28-io-bytestream-characterstream/src/main/java/exercise/a/testDirA"),
                new File("day28-io-bytestream-characterstream/src/main/java/exercise/a/dist")
        );

    }

    /**
     * srcDir=testDirA distDir=dist
     * doCopyDir(testDirA, dist)
     * * subfiles=[B, C, file2]
     * * for: B->doCopyDir(B, dist)
     * * for: C->B->doCopyDir(C, dist)
     * * for: file2->doCopyFile()
     * doCopyDir()
     */

    private static void doCopyDir(File srcDir, File distDir) throws IOException {
        if (srcDir != null) {
            if (srcDir.isFile()) {
                doCopyFile(srcDir, new File(distDir + "\\" + srcDir));
            }
            if (srcDir.isDirectory()) { //f is a dir
                File newDir = new File(distDir.getPath() + "\\" + distDir.getName());
                newDir.mkdirs();
                doCopyDir(srcDir, distDir);
            }
        }
    }

    private static void doCopyFile(File srcFile, File distFile) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(distFile);

        try (fis; fos) {
            int len;
            byte[] buffer = new byte[1024 * 1024 * 5];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
    }

    private static void testCreateDirectory(File srcDir, File distDir) throws IOException {
        File[] subfiles = srcDir.listFiles();
        for (File f : subfiles) {
            if (f.isFile()) {
            } else { //f is a dir
                File newDir = new File(distDir.getPath() + "\\" + f.getName());
                newDir.mkdirs();
            }

        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
