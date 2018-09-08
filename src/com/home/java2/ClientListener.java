package com.home.java2;

public class ClientListener extends Thread {
    @Override
    public void run() {
        String str;
        System.out.println("Слушаю ...");
        while (true){
            if (Client.in.hasNext()) {
                str = Client.in.nextLine();
                System.out.println("Получено: " + str);
                if (str.equals("end")) {
                    System.out.println("Завершение работы. Нажми кнопку.");
                    break;
                }
            }
        }
    }
}
