package org.example;

public class ThreadExample {
    public static void main(String[] args) { // main method is a thread hre

        Thread thread = new Thread();
        thread.start(); // And this is another thread, that works parallel with main above
                        //  Because the thread doesn't have anything to process, it starts
                        // and immediately stops

    }
}
