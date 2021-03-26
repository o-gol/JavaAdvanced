package ru.dip.ex1.wrong;

public class SimpleLogin implements SimpleLoginInterface {
    @Override
    public boolean authenticate(User user){
        return true;
    }
}
