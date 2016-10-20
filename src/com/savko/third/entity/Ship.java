package com.savko.third.entity;

import com.savko.third.generator.CargoGenerator;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Ship extends Thread {

    public static final int MAXIMUM_CAPACITY_OF_SHIP = 20;
    private Logger LOGGER = Logger.getLogger(Ship.class);
    private int currentCargo;

    public Ship(int cargo) {
        this.currentCargo = cargo;
    }

    public static Ship createShip() {
        return new Ship(CargoGenerator.generateCurrentCargo());
    }

    @Override
    public void run() {
        Harbor harbor = Harbor.getSingleton();
        Storage storage = harbor.getStorage();
        boolean process = true;
        while (process) {
            for (Pier harborPier : harbor.getPiers()) {
                if (harborPier.getLocker().tryLock()) {
                    try {
                        LOGGER.info("[Ship with id - " + this.getId() + "] " +
                                "[Cargo of ship - " + getCurrentCargo() + "] " +
                                "[Lock pear with id - " + harborPier.getPierId() + "]");
                        LOGGER.info("Process cargo...");
                        TimeUnit.SECONDS.sleep(5);
                        if (currentCargo > 0) {
                            currentCargo = storage.transportCargoFromShipToStorage(currentCargo);
                        } else {
                            currentCargo = storage.transportCargoFromStorageToShip(MAXIMUM_CAPACITY_OF_SHIP);
                        }
                        LOGGER.info("[Final storage value = " + storage.getStorageCapacity() + "]");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        harborPier.getLocker().unlock();
                    }
                }
            }
        }
    }

    public int getCurrentCargo() {
        return currentCargo;
    }

    public void setCargo(int cargo) {
        this.currentCargo = cargo;
    }

    @Override
    public String toString() {
        return "Ship: " +
                "cargo = " + currentCargo;
    }

}
