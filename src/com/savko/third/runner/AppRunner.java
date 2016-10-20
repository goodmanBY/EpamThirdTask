package com.savko.third.runner;

import com.savko.third.creator.PierCreator;
import com.savko.third.creator.ShipCreator;
import org.apache.log4j.Logger;


public class AppRunner {

    private static Logger LOGGER = Logger.getLogger(AppRunner.class);

    public static void main(String args[]) {

        LOGGER.info("Start program.");

        PierCreator.createPiers(2);
        ShipCreator.createAndStart(3);

    }
}
