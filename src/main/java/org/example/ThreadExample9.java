package org.example;

public class ThreadExample9 {

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
        thread.start();
        sleep(3100);
        System.out.println("Main thread terminated.");
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }




}
