package ru.dip.ex1.wrong;

public class ManagerLogin {
    SimpleLoginInterface simpleLoginInterface;

    public ManagerLogin(SimpleLoginInterface simpleLoginInterface) {
        this.simpleLoginInterface = simpleLoginInterface;
    }

    public void login(User user){
        simpleLoginInterface.authenticate(user);

    }
}
