package ru.semaphore;

public class Client {
    private static Integer numbers=0;
    private final Integer number;

    public Client() {
        numbers++;
        this.number = numbers;
        System.out.printf("Client %s in queue\n",number);
    }

    public Integer getNumber() {
        return number;
    }
}
