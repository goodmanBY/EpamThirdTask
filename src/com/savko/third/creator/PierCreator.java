package com.savko.third.creator;

import com.savko.third.entity.Harbor;
import com.savko.third.entity.Pier;

public class PierCreator {

    /**
     * This method creates number of needed piers for loading or unloading cargo
     *
     * @param numberOfPiers number of needed piers
     */
    public static void createPiers(int numberOfPiers) {
        for (int i = 1; i <= numberOfPiers; i++) {
            Harbor.getInstance().addPier(Pier.createPier(i));
        }
    }

}
