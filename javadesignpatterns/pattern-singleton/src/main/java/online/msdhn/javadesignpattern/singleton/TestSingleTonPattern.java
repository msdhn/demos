package online.msdhn.javadesignpattern.singleton;

public class TestSingleTonPattern {

  public static void main(String... args) {

    for(int i = 0 ; i < 100 ; i++){

      Thread t = new Thread(() -> {
        DemoClass demoClass = DemoClass.INSTANCE;
        System.out.println(demoClass.hashCode());
      });

      t.start();
    }

  }

}
