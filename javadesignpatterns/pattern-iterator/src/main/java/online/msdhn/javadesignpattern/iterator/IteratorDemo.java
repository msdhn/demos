package online.msdhn.javadesignpattern.iterator;

public class IteratorDemo {

    public static void main(String... args) {
        NameRepository namesRepository = new NameRepository();

        for (ContainerIterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }

}
