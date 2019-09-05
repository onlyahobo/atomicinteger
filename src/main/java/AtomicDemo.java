import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (c) Asseco Business Solutions S.A. All rights reserved.
 */

public class AtomicDemo {
    public static void main(String[] args) {
        new AtomicThread("A");
        new AtomicThread("B");
        new AtomicThread("C");
    }
}

class Shared {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomicThread implements Runnable {

    private final String name;

    AtomicThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Initializing " + name);

        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " got value: " + Shared.ai.getAndSet(i));
        }
    }
}