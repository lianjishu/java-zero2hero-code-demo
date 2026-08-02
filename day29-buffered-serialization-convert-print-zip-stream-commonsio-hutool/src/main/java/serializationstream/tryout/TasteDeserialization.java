package serializationstream.tryout;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TasteDeserialization {
    public static void main(String[] args) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day29-buffered-io-serialization/src/main/java/serialization/tryout/person.txt"));

        try (ois) {
//            Object o = ois.readObject();
            Person o = (Person) ois.readObject();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
