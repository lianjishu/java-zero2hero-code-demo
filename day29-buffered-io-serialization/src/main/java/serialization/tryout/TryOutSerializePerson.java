package serialization.tryout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TryOutSerializePerson {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day29-buffered-io-serialization/src/main/java/serialization/tryout/person.txt"));

        Person p = new Person("张三", "男", "420456200102450021");
        try (oos) {
            oos.writeObject(p);
        }
    }
}
