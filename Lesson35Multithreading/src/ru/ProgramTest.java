package ru;

public class ProgramTest {
    public static void main(String[] args) throws InterruptedException {
        String[] strings=new String[]{"123"};
        ru.semaphoreExecuters.Program.main(strings);
        ru.semaphore.Program.main(strings);

    }
}
