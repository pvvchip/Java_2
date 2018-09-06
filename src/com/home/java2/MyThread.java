package com.home.java2;

public class MyThread extends Thread {
    private int i;
    private float[] ar;

    @Override
    public void run() {
        System.out.println(this.getName());
        if (i == 1) ar = Main.a1;
        if (i == 2) ar = Main.a2;
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (float)(ar[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public void start(float[] a, int i) {
        this.i = i;
        ar = a;
        super.start();
    }
}
