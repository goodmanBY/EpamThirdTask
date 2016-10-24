package com.savko.third.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pier {

    private final Lock lock = new ReentrantLock();
    private int pierId;

    public Pier(int pierId) {
        this.pierId = pierId;
    }

    public static Pier createPier(int numberOfPiers) {
        return new Pier(numberOfPiers);
    }

    public int getPierId() {
        return pierId;
    }

    public Lock getLock() {
        return lock;
    }

}
