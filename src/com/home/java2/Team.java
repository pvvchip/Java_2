package com.home.java2;

public class Team {
    private String name;
    private Pleer[] pleers;

    public Team(String name) {
        pleers = new Pleer[4];
        for (int i = 0; i < 4; i++) {
            this.pleers[i] = new Pleer(100, 100, 100);
        }
        this.name = name;
    }

    public Pleer[] getPleers() {
        return pleers;
    }

    public void showResults() {
        System.out.println("Команда: " + name);
        System.out.println();
        boolean[] res;
        for (int i = 0; i < 4; i++) {
            res = pleers[i].getResult();
            System.out.println("Игрок:\t" + (i+1));
            System.out.println("Прыгнул:\t" + (res[0] ? "Да\t" : "Нет\t") + pleers[i].getMaxSpring());
            System.out.println("Пробежал:\t" + (res[1] ? "Да\t" : "Нет\t") + pleers[i].getMaxRun());
            System.out.println("Проплыл:\t" + (res[2] ? "Да\t" : "Нет\t") + pleers[i].getMaxSwim());
            System.out.println();
        }
    }
}
