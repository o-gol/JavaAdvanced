package ru.srp.modem_srp_solution;

public class Phone implements IDataManager,IConnectionManager {

    IConnectionManager connection;
    IDataManager dataManager;

    public Phone(IConnectionManager connection, IDataManager dataManager) {
        this.connection = connection;
        this.dataManager = dataManager;
    }

    @Override
    public void dial(String phoneNumber) {
        connection.dial(phoneNumber);
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }

    @Override
    public void send(String messages) {
        dataManager.send(messages);
    }

    @Override
    public int receive() {
        return dataManager.receive();
    }
}
