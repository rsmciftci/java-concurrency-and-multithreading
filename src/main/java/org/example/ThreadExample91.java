package org.example;

public class ThreadExample91 {

    /*
     * JVM will stay alive as long as there are any remaining threads running, even if psvm thread stops
     *  JAVA Deamon Thread; is a low-priority thread that runs in the background to perfom tasks such as garbage collection.
     * Deamon thread in Java is also a service provider thread that provides services to the user thread
     */

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true){
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread thread = new Thread( runnable );
        thread.setDaemon(true); // Marks this thread as either a daemon thread or a user thread.
                                    // The Java Virtual Machine exits when the only threads running are all daemon threads.
        thread.start();
        sleep(3100);
        System.out.println("Main thread terminated.");
                                // All deamon threats are terminated here with main thread
                                // Better understanding, compare it with previous commit
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }




}
