package eu.msdhn.java19features.eu.msdhn.java19features.virtualthread;

public class ThreadLimit {
    private static Object s = new Object();
    private static int count = 0;

    public static void main(String... args) throws InterruptedException {
        for (; ; ) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (s) {
                        count += 1;
                        System.err.println("New thread #" + count);
                    }
                    for (; ; ) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                }
            }).start();
        }
    }

}

