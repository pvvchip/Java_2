package com.home.java2;

import java.util.*;

public class Main {


    public static void main(String[] args) {

//1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

        System.out.println("Task 1");

        String[] date =
                        {"Зелёный",
                        "Красный",
                        "Самолёт",
                        "Жёлтый",
                        "Дерево",
                        "Самолёт",
                        "Трава",
                        "Трава",
                        "Цветок",
                        "Машина",
                        "Бежать",
                        "Спринтер"};

        HashSet<String> hs = new HashSet<String>();
        for (String st : date) {
            hs.add(st);
        }
        for (String st : hs) {
            System.out.println(st + ": " + Collections.frequency(Arrays.asList(date), st));
        }

//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
// номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

        System.out.println();
        System.out.println("Task 2");

        PhoneBook myPB = new PhoneBook();
        HashMap<String, String> myHM = new HashMap<>();
        myHM.put("12345", "Ivanov");
        myHM.put("23435", "Ivanov");
        myHM.put("33787", "Petrov");

        myPB.setPb(myHM);

        myHM = myPB.getPb();

        getPhone("Ivanov", myHM);
    }

    private static void getPhone(String findName, HashMap<String, String> myHM) {
        for (Map.Entry entry : myHM.entrySet()) {
            if (entry.getValue() == findName) System.out.println(findName + ": " + entry.getKey());
        }
    }
}
