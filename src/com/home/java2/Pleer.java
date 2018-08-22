package com.home.java2;

import java.util.Random;

public class Pleer {
    private int maxSpring;
    private int maxRun;
    private int maxSwim;
    private boolean[] result = new boolean[3];

    public Pleer(int maxSpring, int maxRun, int maxSwim) {

        Random rnd = new Random();

        this.maxSpring = rnd.nextInt(maxSpring);
        this.maxRun = rnd.nextInt(maxRun);
        this.maxSwim = rnd.nextInt(maxSwim);
    }

    public void setResult(boolean[] result) {
        this.result = result;
    }

    public boolean[] getResult() {
        return result;
    }

    public int getMaxSpring() {
        return maxSpring;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxSwim() {
        return maxSwim;
    }
}
