package com.test.spring.ng.demo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadRunner {
    private static final Logger LOGGER = LogManager.getLogger(MultiThreadRunner.class.getSimpleName());
    private ExecutorService executor;
    private int size;
    private int rCount;

    public MultiThreadRunner(int requestsInThreads, int poolSize) {
        executor = Executors.newFixedThreadPool(poolSize);
        rCount = requestsInThreads;
        size = poolSize;
    }

    /**
     * Start running Runnable requests and wait until all requests are executed.
     *
     * @param request
     */
    public void fireIt(Runnable request) {
        Map<String, CountDownLatch> hm = new HashMap<>();
        for (int i = 0; i < size; i++) {
            hm.put(String.valueOf(i), new CountDownLatch(rCount));
            executor.execute(new HttpThreads(hm.get(String.valueOf(i)), request));
        }
        fireAll(hm);
    }

    public void fireIt(List<Runnable> requestList) {
        Map<String, CountDownLatch> hm = new HashMap<>();
        int y = 0;
        for (Runnable request : requestList) {
            y++;
            for (int i = 0; i < (size / requestList.size()); i++) {
                String keyIdent = y + String.valueOf(i);
                hm.put(keyIdent, new CountDownLatch(rCount));
                executor.execute(new HttpThreads(hm.get(keyIdent), request));
            }
        }
        fireAll(hm);
    }

    private void fireAll(Map<String, CountDownLatch> hm) {
        for (String key : hm.keySet()) {
            try {
                hm.get(key).await();
            } catch (InterruptedException e) {
                LOGGER.info(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        executor.shutdown();
        LOGGER.info("All threads are finished");
    }
}
