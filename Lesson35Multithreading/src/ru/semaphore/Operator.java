package ru.semaphore;

import ru.Colors;

public class Operator {
    private final int name;

    public Operator(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void getClient(Client client){
        System.out.printf("%s                   Operator %s BEGIN work with Client %s\n", Colors.BLUE,name,client.getNumber());
        Program.sleep(3000);
        System.out.printf("%s                   Operator %s STOP work with Client %s\n",Colors.RED,name,client.getNumber());

    }
}
