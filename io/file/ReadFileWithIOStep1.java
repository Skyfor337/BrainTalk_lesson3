package lesson2.io.file;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileWithIOStep1 {

    public static class Reader1 {
        public static void main(String[] args) throws IOException {
            FileInputStream fin = new FileInputStream("test.txt");
            int i = -1;  // -1 специальный байт - признак конца файла
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
        }
    }

    public static class Reader2 {
        public static void main(String[] args) {
            try (FileInputStream fin = new FileInputStream("test.txt")) {
                System.out.printf("File size: %d bytes \n", fin.available());
                int i = -1;
                while ((i = fin.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
