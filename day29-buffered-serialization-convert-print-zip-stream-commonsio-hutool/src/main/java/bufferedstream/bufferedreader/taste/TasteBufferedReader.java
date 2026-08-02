package bufferedstream.bufferedreader.taste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TasteBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("day29-buffered-io/src/main/java/bufferedreader/taste/aaa.txt")
        );
        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
