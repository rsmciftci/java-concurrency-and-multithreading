package org.example;

public class ThreadExample4 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {  // This time we created runnable object inside psvm to
            @Override                          // substitute it to Thread object below.
            public void run() {
                System.out.println("Runnable running");
                System.out.println("Runnable finished");
            }
        };

        Thread thread = new Thread( runnable );
        thread.start();
    }



}
