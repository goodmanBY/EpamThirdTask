package com.savko.third.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    public final static int MAXIMUM_CAPACITY_OF_STORAGE = 100;

    private int storageCapacity = 0;
    private Lock storageLock = new ReentrantLock();

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public Lock getStorageLock() {
        return storageLock;
    }
}
