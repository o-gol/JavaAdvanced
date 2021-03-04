package ru.srp.modem_srp_solution;

public class IDataManagerImplementation implements IDataManager {
    @Override
    public void send(String messages) {
        System.out.printf("You message: \"%s\" was send \n",messages);

    }

    @Override
    public int receive() {
        System.out.println("Message was send successfully");
        return 0;
    }
}
