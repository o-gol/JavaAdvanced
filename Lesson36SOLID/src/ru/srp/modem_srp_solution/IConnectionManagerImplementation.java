package ru.srp.modem_srp_solution;

public class IConnectionManagerImplementation implements IConnectionManager{
    @Override
    public void dial(String phoneNumber) {
        System.out.printf("Connect to %s\n",phoneNumber);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected");
    }
}
