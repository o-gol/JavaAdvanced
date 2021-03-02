package ru.semaphoreExecuters;

 class Client {
    private static Integer numbers=0;
    private final Integer number;

     Client() {
        numbers++;
        this.number = numbers;
        System.out.printf("Client %s in queue\n",number);
    }

    Integer getNumber() {
        return number;
    }

     public static Integer getNumbers() {
         return numbers;
     }
 }
