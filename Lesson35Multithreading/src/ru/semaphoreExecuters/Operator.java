package ru.semaphoreExecuters;

import ru.Colors;

  class Operator {
    private final int name;
    private static int allClients=0;

    static int getAllClients() {
        return allClients;
    }
     Operator(int name) {
        this.name = name;
    }

    int getName() {
        return name;
    }


    void getClient(Client client){
        allClients++;
        System.out.printf("%s                   Operator %s BEGIN work with Client %s\n", Colors.BLUE,name,client.getNumber());
        Program.sleep(1000);
        System.out.printf("%s                   Operator %s STOP work with Client %s\n",Colors.RED,name,client.getNumber());

    }
}
