package com.home.java2.client;

public class MainClass {

    public static void main(String[] args) {
        Controller controller = new ClientController();
        ClientUI clientUI = new Client(controller, ((ClientController) controller).getIndex());
        controller.showUI(clientUI, ((ClientController) controller).getIndex());
    }
}
