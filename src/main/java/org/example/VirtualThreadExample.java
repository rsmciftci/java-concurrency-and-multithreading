package org.example;
public class VirtualThreadExample {

    public static void main(String[] args) {

        // Example 1: Create Runnable. Create and start virtual thread
        Runnable runnable = () -> {
            for(int i=0; i < 100; i++){
                System.out.println("Index: " + i);
            }
        };

        Thread virtualThread = Thread.ofVirtual().start(runnable);

        // Example 2: Create but do not start virtual thread
        Thread virtualThreadUnstarted = Thread.ofVirtual().unstarted(runnable);
        virtualThreadUnstarted.start();

        /*
        Virtual threads are much more lightweight, they requires less memory, ram compared to platform thread.
        Running millions of platform threads is impossible. But running millions of virtual threads is possible.

         */
        // How to join a virtual thread
        try {
            virtualThreadUnstarted.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }

}