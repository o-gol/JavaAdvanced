package Transfer;

class Account{
    private  int balance=10000;
    void deposit(int amount){
        balance+=amount;
    }
    void withdrow(int amount){
        balance-=amount ;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account account1,Account account2,int amout){
        account1.withdrow(amout);
        account2.deposit(amout);
    }
}