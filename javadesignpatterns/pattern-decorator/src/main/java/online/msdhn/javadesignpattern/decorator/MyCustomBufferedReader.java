package online.msdhn.javadesignpattern.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author masud
 */
public class MyCustomBufferedReader extends Reader {

    private BufferedReader bufferedReader;

    public MyCustomBufferedReader(BufferedReader reader) {
        bufferedReader = reader;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return bufferedReader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        this.bufferedReader.close();
    }

    public String readLine() throws IOException {
        return this.bufferedReader.readLine().toUpperCase();
    }
}
