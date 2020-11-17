package firstCodeState;

public class Homwork1Author {
//    public static void main(String[] args) {
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println(getState());
//            }
//        };
//        System.out.println(thread.getState());
//        thread.start();
//        try {
//            // Тут маленькая сложность есть только для вывода состояния TERMINATED:
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(thread.getState());
//
//
//
//
//
//    }

    /**
     * Вывод состояния WAITING
     *
     * @param strings
     * @throws InterruptedException
     */
    public static void main(String[] strings) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.notifyAll();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        synchronized (lock){
            thread.start(); // Запустим поток
            lock.wait(); // Будем ждать, пока поток не запустится
            System.out.println(thread.getState()); // WAITING
            lock.notifyAll();
            System.out.println(thread.getState()); // BLOCKED
        }
    }




}
