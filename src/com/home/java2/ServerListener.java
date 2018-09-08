package com.home.java2;

import java.util.Scanner;

public class ServerListener extends Thread{
    @Override
    public void run() {

        Scanner scan = new Scanner(System.in);
        String str;
        System.out.println("Ввод сообщений:");
        while (true) {
            str = scan.nextLine();
            Server.pw.println("Server: " + str);
            Server.pw.flush();
        }
    }
}
