package ru.srp.modem_srp_solution;

public interface IConnectionManager {
    void dial(String phoneNumber);
    void disconnect();
}
