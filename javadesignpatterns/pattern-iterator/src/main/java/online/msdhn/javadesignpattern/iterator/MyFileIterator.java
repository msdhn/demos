package online.msdhn.javadesignpattern.iterator;

import java.io.IOException;
import java.util.Iterator;

public class MyFileIterator implements Iterator<String> {

    private MyBufferedReader reader;

    private String line;

    public MyFileIterator(MyBufferedReader myReader) {
        this.reader = myReader;
    }

    @Override
    public boolean hasNext() {
        boolean rersult = false;
        try {
            line = reader.readLine();
            rersult = (line != null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rersult;
    }

    @Override
    public String next() {
        return line;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported!");
    }
}