package com.home.java2;

public class Main {
    public static void main(String[] args) {

//1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера
// необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе
// массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
// исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
// и вывести результат расчета.
        String[][] str1 = {{"14", "15", "16", "17"}, {"11", "12", "13", "12"}, {"14", "15", "16", "17"}, {"19", "20", "21", "22"}};
        String[][] str2 = { {"11", "test", "13", "12"}, {"14", "15", "16", "17"}, {"19", "20", "21", "22"}};

        System.out.println("Сумма: " + test(str1));
        System.out.println();
        System.out.println("Сумма: " + test(str2));
    }

    private static int test(String[][] str) {
        System.out.println(str[0].length);
        System.out.println(str.length);

        try {
            if ((str.length != 4) || (str[0].length != 4)) throw new MyArraySizeException();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                try {
                    sum += Integer.parseInt(str[i][j]);
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException("Ошибочное содержание: " + i + " " + j);
                    } catch (MyArrayDataException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        return sum;

    }


}
