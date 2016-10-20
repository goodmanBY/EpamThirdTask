package com.savko.third.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pier {

    private final Lock locker = new ReentrantLock();
    private int pierId;

    public Pier(int pierId) {
        this.pierId = pierId;
    }

    public static Pier createPier(int i) {
        return new Pier(i);
    }

    public int getPierId() {
        return pierId;
    }

    public Lock getLocker() {
        return locker;
    }

}
