package com.home.java2;

import java.util.Random;

public class Corse {
    private int wall;
    private int road;
    private int water;

    public Corse(int wall, int road, int water) {

        Random rnd = new Random();

        this.wall = rnd.nextInt(wall);
        this.road = rnd.nextInt(road);
        this.water = rnd.nextInt(water);

        System.out.println("Полоса");
        System.out.println("Высота:\t\t" + this.wall);
        System.out.println("Бег:\t\t" + this.road);
        System.out.println("Плавание:\t" + this.water);
        System.out.println();
    }

    void doIt(Team team) {
        boolean[] res = new boolean[3];
        for (Pleer p : team.getPleers()) {
            res[0] = p.getMaxSpring() > wall;
            res[1] = p.getMaxRun() > road;
            res[2] = p.getMaxSwim() > water;
            p.setResult(res);
        }

    }
}
