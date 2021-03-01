package ru.semaphore;

public class Operator {
    private final String name;

    public Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getClient(Client client){
        System.out.printf("Operator %s BEGIN work with Client %s\n",name,client.getNumber());
        Program.sleep(3000);
        System.out.printf("Operator %s STOP work with Client %s\n",name,client.getNumber());

    }
}
