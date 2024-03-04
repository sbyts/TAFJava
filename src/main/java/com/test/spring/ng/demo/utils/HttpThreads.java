package com.test.spring.ng.demo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class HttpThreads implements Runnable {
        private static final Logger LOGGER = LogManager.getLogger(HttpThreads.class.getSimpleName());
        private Runnable request;
        private CountDownLatch counter;

        /**
         *
         * @param counter - A synchronization aid that allows one or more threads to
         *            wait until a set of operations being performed in other
         *            threads completes.
         * @param request - Runnable request.
         */
        public HttpThreads(CountDownLatch counter, Runnable request) {
            this.counter = counter;
            this.request = request;
        }

        public void run() {
            while (this.counter.getCount() > 0) {
                try {
                    this.request.run();
                } catch (AssertionError e) {
                    LOGGER.error(e.getMessage());
                }
                this.counter.countDown();
                LOGGER.debug(String.format("sending request (%s requests left ) ... ", this.counter.getCount()));
            }
        }
}
