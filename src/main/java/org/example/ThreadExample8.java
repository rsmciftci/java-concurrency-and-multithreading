package org.example;

public class ThreadExample8 {
   public static class StoppableRunnable implements Runnable{
       private boolean stopRequested = false;

       public synchronized void requestStop(){ // synchronized prevents multiple cores to call the method
           this.stopRequested = true;           // so only one core can call the method
       }

       public synchronized  boolean isStopRequested(){
           return this.stopRequested;
       }
       private void sleep(long millis){
           try {
               Thread.sleep(millis);
           } catch (InterruptedException e){
               e.printStackTrace();
           }
       }

       @Override
       public void run(){
           System.out.println("StoppableRunnable Running");
           while( !isStopRequested() ){
               sleep(1000);
               System.out.println("...");
           }
           System.out.println("StoppableRunnable Stopped");
       }
   }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread( stoppableRunnable, "The Thread");
        thread.start();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");
    }
}
