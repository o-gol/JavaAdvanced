package ru.srp.modem_srp_violation;

public interface Phoneble {
    void dial(String phoneNumber);
    void disconnect();

    void send(String messages);
    int receive();
}
