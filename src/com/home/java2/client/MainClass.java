package com.home.java2.client;

public class MainClass {

    //    1. Разобраться с кодом.
    //    2. *Реализовать личные сообщения так: если клиент пишет «/w nick3 Привет», то только клиенту с ником nick3
    //          должно прийти сообщение «Привет».

    public static void main(String[] args) {
        Controller controller = new ClientController();
        ClientUI clientUI = new Client(controller);
        controller.showUI(clientUI);
    }
}
