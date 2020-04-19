package online.msdhn.javadesignpattern.builder;

public class BuilderDemo {

    public static void main(String... args) {
        BankAccount.builder("").holder("Masud Hasan").with("HDFC").inBranch("MANPADA").withRate(4.20d)
                .openingWith(1200d).build();
    }

}
