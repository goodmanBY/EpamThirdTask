package com.savko.third.processor;

import com.savko.third.entity.Harbor;
import com.savko.third.entity.Storage;

public class CargoProcessor {

    private static Storage storage = Harbor.getInstance().getStorage();

    /**
     * This method transports incoming cargo from a ship to the storage
     *
     * @param incomingCargo incoming cargo from ship
     * @return cargo after unload
     */
    public static int transportCargoFromShipToStorage(int incomingCargo) {
        int rest = 0;
        storage.getStorageLock().lock();
        int currentCapacity = storage.getStorageCapacity();
        try {
            if (currentCapacity + incomingCargo <= Storage.MAXIMUM_CAPACITY_OF_STORAGE) {
                storage.setStorageCapacity(currentCapacity + incomingCargo);
            } else {
                rest = incomingCargo - (Storage.MAXIMUM_CAPACITY_OF_STORAGE - currentCapacity);
                storage.setStorageCapacity(Storage.MAXIMUM_CAPACITY_OF_STORAGE);
            }
        } finally {
            storage.getStorageLock().unlock();
        }
        return rest;
    }

    /**
     * This method transports cargo from the storage to a ship
     *
     * @param expectedCargo expected cargo for the ship
     * @return cargo for a ship
     */
    public static int transportCargoFromStorageToShip(int expectedCargo) {
        int result = 0;
        int emptyStorage = 0;
        storage.getStorageLock().lock();
        int currentCapacity = storage.getStorageCapacity();
        try {
            if (currentCapacity >= expectedCargo) {
                result = expectedCargo;
                storage.setStorageCapacity(currentCapacity - expectedCargo);
            } else if (currentCapacity < expectedCargo) {
                result = currentCapacity;
                storage.setStorageCapacity(emptyStorage);
            }
        } finally {
            storage.getStorageLock().unlock();
        }
        return result;
    }

}
