package ru.it2g.h2o.service.auth;

public interface AuthService {

    boolean login(String username, String password);

    void logOut(String username);
}
