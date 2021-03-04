package ru.srp.modem_srp_solution;

public class PhoneClient {
    public static void main(String[] args) {
        Phone phone=new Phone(new IConnectionManagerImplementation(),new IDataManagerImplementation());
        phone.dial("98765");
        phone.send("Bay");
        phone.receive();
        phone.disconnect();
    }
}
