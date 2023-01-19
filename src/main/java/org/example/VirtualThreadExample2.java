package org.example;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadExample2 {
    public static void main(String[] args) {

        // Creating 100_000 virtual threads
        List<Thread> virtualThreads = new ArrayList<>();

        int virtualThreadCount = 100_000;

        for(int i=0; i < virtualThreadCount; i++){
            int virtualThreadIndex = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for(int j=0; j<10; j++){
                    result *= (j + 1);
                }
                System.out.println("Result[" + virtualThreadIndex + "]:" + result);
            });
            virtualThreads.add(vThread);


            // Here we make main thread to wait all virtual threads.
            for(int j=0; j<virtualThreads.size(); j++){
                try {
                    virtualThreads.get(j).join();
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
