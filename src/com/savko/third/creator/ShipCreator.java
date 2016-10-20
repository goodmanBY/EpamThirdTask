package com.savko.third.creator;

import com.savko.third.entity.Ship;

import java.util.ArrayList;
import java.util.List;

public class ShipCreator {

    /**
     * This method create number of needed ships and start threads
     *
     * @param i number of needed ships
     */
    public static void createAndStart(int i) {
        List<Ship> ships = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            ships.add(Ship.createShip());
            ships.get(j).start();
        }
    }

}
