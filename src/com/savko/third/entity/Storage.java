package com.savko.third.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    private final int MAXIMUM_CAPACITY_OF_STORAGE = 100;
    private int storageCapacity = 0;
    private Lock storageLock = new ReentrantLock();


    public int getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * This method transports incoming cargo from a ship to the storage
     *
     * @param incomingCargo incoming cargo from ship
     * @return cargo after unload
     */
    public int transportCargoFromShipToStorage(int incomingCargo) {
        int rest = 0;
        storageLock.lock();
        try {
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
     * This method transports cargo from the storage to a ship
     *
     * @param expectedCargo expected cargo for the ship
     * @return cargo for a ship
     */
    public int transportCargoFromStorageToShip(int expectedCargo) {
        int result = 0;
        storageLock.lock();
        try {
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
