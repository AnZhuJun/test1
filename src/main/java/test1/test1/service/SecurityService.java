package test1.test1.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String name, String password);
}
