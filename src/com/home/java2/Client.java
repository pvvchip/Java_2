package com.home.java2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String SERVER_ADR = "localhost";
    private static final int SERVER_PORT = 8189;
    private static Socket sock;
    public static Scanner in;
    private static PrintWriter out;


    public static void main(String[] args) {

        try {
            sock = new Socket(SERVER_ADR,SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ввод сообщений:");
        Scanner key = new Scanner(System.in);
        String str;

        ClientListener myListener = new ClientListener();
        myListener.start();

        while (myListener.isAlive()) {
            str = key.nextLine();
            sendMsg(str);
        }
    }

    private static void sendMsg(String hi) {
        out.println(hi);
        out.flush();
    }


}
