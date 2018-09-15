package com.home.java2.server;

public interface AuthService {
    String authByLoginAndPassword(String login, String password);

    User createOrActivateUser(String login, String password, String nick);

    boolean deactivateUser(String nick);

}
