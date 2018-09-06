package com.home.java2;

//1) Создают одномерный длинный массив, например:
//static final int size = 10000000;
//static final int h = size / 2;
//float[] arr = new float[size];
//2) Заполняют этот массив единицами;
//3) Засекают время выполнения: long a = System.currentTimeMillis();
//4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//5) Проверяется время окончания метода System.currentTimeMillis();
//6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//Отличие первого метода от второго:
//Первый просто бежит по массиву и вычисляет значения.
//Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//Пример деления одного массива на два:
//System.arraycopy(arr, 0, a1, 0, h);
//System.arraycopy(arr, h, a2, 0, h);
//
//Пример обратной склейки:
//System.arraycopy(a1, 0, arr, 0, h);
//System.arraycopy(a2, 0, arr, h, h);
//
//Примечание:
//System.arraycopy() копирует данные из одного массива в другой:
//System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//По замерам времени:
//Для первого метода надо считать время только на цикл расчета:
//for (int i = 0; i < size; i++) {
//arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//}
//Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    public static float[] a1, a2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis()-a);

        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        a1 = new float[h];
        a2 = new float[h];
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        mt1.start(a1, 1);
        mt2.start(a2, 2);

        while (mt1.isAlive() || mt2.isAlive()){

        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis()-a);

    }
}
