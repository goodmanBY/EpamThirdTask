package com.savko.third.creator;

import com.savko.third.entity.Ship;

public class ShipCreator {

    /**
     * This method creates number of needed ships and start threads
     *
     * @param numberOfShips number of needed ships
     */
    public static void createAndStart(int numberOfShips) {
        for (int i = 0; i < numberOfShips; i++) {
            Ship.createShip().start();
        }
    }

}
