package Transfer;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner{
    Account account1=new Account();
    Account account2=new Account();
    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();
    Object o=new Object();

    private void tryLock(Lock lock1,Lock lock2){
        boolean lock1State=false;
        boolean lock2State=false;
        while(true){
            try{
               lock1State=lock1.tryLock();
               lock2State=lock2.tryLock();
            }finally {
                if(lock1State&&lock2State){
                        return;
                    }
                if(lock1State){
                        lock1.unlock();
                    }
                if(lock2State){
                        lock2.unlock();
                    }
                try {
                     Thread.sleep(1);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
         }
      }




    }

    public void firstThread(){
        //synchronized (o) {
        //synchronized (account1) {
            //synchronized (account2) {
                for (int i = 0; i < 10000; i++) {
                    tryLock(lock1,lock2);
//        lock1.lock();
//        lock2.lock();
        try {

                    Account.transfer(account1, account2, new Random().nextInt(100));
        }finally {

        lock1.unlock();
            lock2.unlock();
        }
                }
            //}
        //}
        //}


    }

    public void secondThread(){
        //synchronized (o) {
        //synchronized (account1) {
            //synchronized (account2) {
                for (int i = 0; i < 10000; i++) {
                    tryLock(lock1,lock2);
//        lock2.unlock();
//        lock1.lock();

        try {

                    Account.transfer(account2, account1, new Random().nextInt(100));
        }finally {

            lock2.unlock();
            lock1.unlock();
        }
                }
            //}
        //}
        //}



    }

    public int finish(){

//        System.out.printf("acc1-%s\n",account1.getBalance());
//        System.out.printf("acc2-%s\n",account2.getBalance());
//        System.out.printf("Total-%s\n",account1.getBalance()+account2.getBalance());
        return account1.getBalance()+account2.getBalance();


    }
}