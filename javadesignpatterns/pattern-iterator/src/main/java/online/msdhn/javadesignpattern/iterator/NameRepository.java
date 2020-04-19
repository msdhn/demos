package online.msdhn.javadesignpattern.iterator;

public class NameRepository implements Container {

    public String names[] = {"Robert", "John", "Julie", "Lora"};

    /*
     * (non-Javadoc)
     *
     * @see com.hcl.ingbootcamp.javadesignpattern.iterator.Container#getIterator()
     */
    @Override
    public ContainerIterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements ContainerIterator {
        private int index;

        /*
         * (non-Javadoc)
         *
         * @see
         * com.hcl.ingbootcamp.javadesignpattern.iterator.ContainerIterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        /*
         * (non-Javadoc)
         *
         * @see com.hcl.ingbootcamp.javadesignpattern.iterator.ContainerIterator#next()
         */
        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }

}