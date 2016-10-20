package com.savko.third.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    public final int MAXIMUM_CAPACITY_OF_STORAGE = 100;
    private int storageCapacity = 0;
    private Lock storageLock = new ReentrantLock();


    public int getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * This method transport incoming cargo from ship to the storage
     *
     * @param incomingCargo incoming cargo from ship
     * @return cargo after unload
     */
    public int transportCargoFromShipToStorage(int incomingCargo) {
        int rest = 0;
        try {
            storageLock.lock();
            if (storageCapacity + incomingCargo <= MAXIMUM_CAPACITY_OF_STORAGE) {
                this.storageCapacity += incomingCargo;
            } else {
                rest = incomingCargo - MAXIMUM_CAPACITY_OF_STORAGE - storageCapacity;
                storageCapacity = MAXIMUM_CAPACITY_OF_STORAGE;
            }
        } finally {
            storageLock.unlock();
        }
        return rest;
    }

    /**
     * This method transport
     *
     * @param expectedCargo expected cargo for the ship
     * @return maximum cargo for ship
     */
    public int transportCargoFromStorageToShip(int expectedCargo) {
        int result = 0;
        try {
            storageLock.lock();
            if (storageCapacity >= expectedCargo) {
                result = expectedCargo;
                storageCapacity -= expectedCargo;
            } else if (storageCapacity < expectedCargo) {
                result = storageCapacity;
                storageCapacity = 0;
            }
        } finally {
            storageLock.unlock();
        }
        return result;
    }

}
