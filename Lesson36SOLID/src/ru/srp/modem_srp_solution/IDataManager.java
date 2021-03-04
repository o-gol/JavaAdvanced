package ru.srp.modem_srp_solution;

public interface IDataManager {
    void send(String messages);
    int receive();
}
