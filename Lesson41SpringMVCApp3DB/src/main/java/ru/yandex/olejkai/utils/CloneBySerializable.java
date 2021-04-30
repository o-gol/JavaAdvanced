package ru.yandex.olejkai.utils;

import ru.yandex.olejkai.model.People;

import java.io.*;

public class CloneBySerializable {
    public static People clone(People people) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        //сохраняем состояние people в поток и закрываем его(поток)
        ous.writeObject(people);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        //создаём newPeople  и инициализируем его состояние people
        return  (People) ois.readObject();
    }
}
