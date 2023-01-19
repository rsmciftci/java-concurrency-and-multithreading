package org.example;

public class ThreadExample10 {
    /*
    * It is also possible for a thread to wait other thread to terminate.
    *
    *
    *
    **/

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i=0; i < 5; i++){
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread thread = new Thread( runnable );
        thread.setDaemon(true);
        thread.start();

        /*  Waits for this thread to die.
            An invocation of this method (.join() )behaves in exactly the same way as the invocation
            What happens here is
            psvm waits for the thread
            once the thread completed, jvm shuts down
            Notice, the thread marked as Deamon above
        */
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
