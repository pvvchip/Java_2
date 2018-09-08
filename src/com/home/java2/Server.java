package com.home.java2;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static PrintWriter pw;

    public static void main(String[] args) {
        ServerSocket ser = null;
        Socket soc = null;
        ServerListener myListener = new ServerListener();

        try {
            ser = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидание подключения ...");
            soc =ser.accept();
            System.out.println("Клиент подключился.");
            Scanner sc = new Scanner(soc.getInputStream());
            pw =new PrintWriter(soc.getOutputStream());


            myListener.start();


            while (true) {
                String str = sc.nextLine();
                if (str.equals("end")) {
                    System.out.println("Завершение работы. Нажми кнопку.");
                    break;
                }
                System.out.println("Получил: " + str);
                pw.println("Эхо: " + str);
                pw.flush();
            }
        }
        catch (Exception e){
            System.out.println("Ошибка инициализации сервера.");
            System.out.println(e.getStackTrace());
        }
        finally {
            try {
                pw.println("end");
                pw.flush();
                ser.close();
                myListener.stop();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
