package online.msdhn.javadesignpattern.decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyCustomBufferedReaderDemo {

    public static void main(String... args) throws IOException {

        MyCustomBufferedReader myCustomBufferedReader = new MyCustomBufferedReader(new BufferedReader(
                new FileReader(System.getProperty("user.dir") + System.getProperty("file.separator") + "test.txt")));


        System.out.println(myCustomBufferedReader.readLine());
    }

}
