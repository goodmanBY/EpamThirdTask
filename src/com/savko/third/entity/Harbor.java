package com.savko.third.entity;

import java.util.ArrayList;

public class Harbor {

    private Storage storage;
    private ArrayList<Pier> piers;

    private Harbor() {
        piers = new ArrayList<>();
        storage = new Storage();
    }

    public static Harbor getInstance() {
        return StaticHolder.INSTANCE;
    }

    public ArrayList<Pier> getPiers() {
        return piers;
    }

    public void addPier(Pier pier) {
        getPiers().add(pier);
    }

    public Storage getStorage() {
        return storage;
    }

    private static class StaticHolder {
        static final Harbor INSTANCE = new Harbor();
    }
}
