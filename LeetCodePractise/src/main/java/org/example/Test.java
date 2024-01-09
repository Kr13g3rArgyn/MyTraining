package org.example;

public class Test {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                    System.out.println(i);
                    i++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                synchronized (lock) {
                    System.out.println(i);
                    i++;
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

