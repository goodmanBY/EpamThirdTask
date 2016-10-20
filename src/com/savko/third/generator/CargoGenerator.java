package com.savko.third.generator;

import java.util.Random;

public class CargoGenerator {

    /**
     * This method generate random number for current cargo
     *
     * @return current cargo
     */
    public static int generateCurrentCargo() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(20) + 1;
    }

}
