package ru.srp.modem_srp_violation;

public class Program {
    public static void main(String[] args) {
        Phoneble phone=new Phone();
        phone.dial("1234567");
        phone.send("Hello");
        phone.receive();
        phone.disconnect();
    }
}
