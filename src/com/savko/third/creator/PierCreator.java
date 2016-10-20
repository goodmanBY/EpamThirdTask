package com.savko.third.creator;

import com.savko.third.entity.Harbor;
import com.savko.third.entity.Pier;

public class PierCreator {

    /**
     * This method create number of needed piers for loading or unloading cargo
     *
     * @param i number of needed piers
     */
    public static void createPiers(int i) {
        for (int j = 1; j <= i; j++) {
            Harbor.getSingleton().addPier(Pier.createPier(j));
        }
    }

}
