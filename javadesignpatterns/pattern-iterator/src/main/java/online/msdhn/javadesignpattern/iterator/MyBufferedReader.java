package online.msdhn.javadesignpattern.iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author masud
 */
public class MyBufferedReader extends Reader {

    private BufferedReader bufferedReader;

    public MyBufferedReader(BufferedReader reader) {
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
        String dataLine = this.bufferedReader.readLine();
        if (dataLine != null) {
            return dataLine.toUpperCase();
        } else {
            return dataLine;
        }
    }
}
