package org.example;

public class ThreadExample2 {
        public static class MyThread extends Thread {
            public void run(){
                System.out.println("MyThread is running");
                System.out.println("MyThread is finished");
            }
        }
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start(); // when start() method runs, it runs the void run method above

        // extending to Thread class is not recommended because it is not as good as Runnable interface !!!

    }
}
