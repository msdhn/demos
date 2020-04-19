package online.msdhn.javadesignpattern.adaptor;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * adapting a enumeration to iterator
 *
 * @author masud
 */
public class EnumerationIterator implements Iterator<String> {

    private Enumeration<String> enumeration;

    public EnumerationIterator(Enumeration<String> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public String next() {
        return enumeration.nextElement();
    }

}
