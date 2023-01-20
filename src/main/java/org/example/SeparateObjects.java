package org.example;

public class SeparateObjects {

    public static void main(String[] args) {
        /*
        Remember each thread creates their own thread stack, so each thread has their own primitives and object references
        However, we need to create two different runnable object for threads, so threads will not have common object in the
        heap. That's why we created two runnable objects below.
        Also, remember that objects are allocated in the heap memory.

        Additional info, We can still make threads not to share the same object in the heap without creating two different runnable object.
        Solution to that,
        add the line below to overrriden run method inside MyRunnable.
        MyObject myObject = new MyObject();
        So each thread will create their own references in their stack and also the their own object (MyObject is a object we created) in the heap

        RACE CONDITION
        It arises when multiple threads shares same object in heap memory. Lets say in heap we keep and object that is increasing, thread 1 and thread 2 reaches it
        at the same time and value is 1, they increase it +1 and object becomes 2, actually needs to be 3 because each thread increased it once.
        To solve the issue you can use synchronized blocks or you can use volatile variables.

        Data Update Visibility Between Threads
        Similar condition to race condition above. One thread reads object from heap before other thread however, second thread reads object before it is updated.
        */
        Runnable runnable1 = new MyRunnable();
        //Runnable runnable2 = new MyRunnable();

        Thread thread1 =
                new Thread(runnable1, "Thread 1");
        Thread thread2 =
                new Thread(runnable1,"Thread 2");

        thread1.start();
        thread2.start();
    }
}
