package ru.semaphoreExecuters;

import ru.Colors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

 class OperatorServices implements Runnable {
    private Operator operator;
    private Client client;
    private Semaphore semaphore;
    private BlockingQueue<Operator> operators;

    OperatorServices(Operator operator, Client client, Semaphore semaphore, BlockingQueue<Operator> operators) {
        this.operator = operator;
        this.client = client;
        this.semaphore = semaphore;
        this.operators = operators;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            operator.getClient(client);
            operators.put(operator);
            System.out.printf("%s                                       Operator %s free and in operators %s  \n"
                    , Colors.GREEN, operator.getName(), operators.size()
//                    , clientsQueue.size()
//                    , clientsQueue.isEmpty()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();

        }
    }
}
