package ru.srp.modem_srp_violation;

public class Phone implements Phoneble {
    @Override
    public void dial(String phoneNumber) {
        System.out.printf("Connect to %s\n",phoneNumber);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected");
    }

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
