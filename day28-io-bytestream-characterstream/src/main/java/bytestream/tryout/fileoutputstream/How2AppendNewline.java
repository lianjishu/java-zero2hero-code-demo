package bytestream.tryout.fileoutputstream;

import common.Path;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 换行写
 * 追加写
 */
public class How2AppendNewline {
    private static void WriteNewline() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(Path.RSRC_PATH + "\\fileoutputstream\\How2AppendNewline.txt")) {
            fos.write("Man, what can I say...".getBytes());
            //换行
            fos.write("\r\n".getBytes());
            //写剩下的
            fos.write("Mamba Out".getBytes());
        }
    }

    private static void WriteAppend() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(
                Path.RSRC_PATH + "\\fileoutputstream\\How2AppendNewline.txt",
                true
        )) {
            fos.write("""
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    """.getBytes());
            fos.write("""
                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
                    """.getBytes());

            fos.write("""
                    Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
                    totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, 
                    explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, 
                    qui ratione voluptatem sequi nesciunt.
                    """.getBytes());
            fos.write("""
                    Neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci velit,
                    sed quia non numquam eius modi tempora incidunt, ut labore et dolore magnam aliquam quaerat voluptatem. 
                    Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?
                    """.getBytes());
            fos.write("""
                    Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, 
                    vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus,
                    qui blanditiis praesentium voluptatum deleniti atque corrupti, quos dolores et quas molestias excepturi sint,
                    obcaecati cupiditate non provident, similique sunt in culpa, qui officia deserunt mollitia animi, id est laborum et dolorum fuga.;
                    """.getBytes());
        }
    }

    public static void main(String[] args) throws IOException {
        WriteNewline();
        WriteAppend();
    }
}
