package com.hcl.ingbootcamp.javadesignpattern.iterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileIrteratorDemo {
    public static void main(String... args) throws FileNotFoundException {
        MyFileIterator myFileIterator = new MyFileIterator(new MyBufferedReader(new BufferedReader(
                new FileReader(System.getProperty("user.dir") + System.getProperty("file.separator") + "test.txt"))));

        while (myFileIterator.hasNext()) {
            System.out.println(myFileIterator.next());
        }

    }
}
