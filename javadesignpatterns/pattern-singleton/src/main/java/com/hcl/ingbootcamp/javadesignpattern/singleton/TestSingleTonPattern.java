package com.hcl.ingbootcamp.javadesignpattern.singleton;

public class TestSingleTonPattern {

  public static void main(String... args) {

    for (int i = 0; i < 100; i++) {
      Thread t1 = new Thread(() -> {
        MyLazySingleton myLazySingleton = MyLazySingleton.getInstance();
        System.out.println(myLazySingleton.hashCode());
      });
      t1.start();
    }


  }

}
