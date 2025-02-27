package lesson2.io.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteFileWithIOStep1 {

    public static class Writer1 {
        public static void main(String[] args) throws Exception {
            FileOutputStream fos = new FileOutputStream("test.txt");
            fos.write("123".getBytes(StandardCharsets.UTF_8));
            fos.flush();
            fos.close(); //не правильно так делать - закрывать стрим нужно в блоке finally
        }
    }

    public static class Writer2 {
        public static void main(String[] args)  {

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("test.txt");
                fos.write("123".getBytes(StandardCharsets.UTF_8));
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Writer3 {
        public static void main(String[] args) throws Exception {
            try (FileWriter writer = new FileWriter("test.txt")) {
                writer.write("123");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
