package kz.halyk.instantiation;

import kz.halyk.cars.Sedan;

import java.lang.reflect.Constructor;

public class Test1 {

    public static void main(String[] args) throws Exception {
        var className = "kz.halyk.cars.Sedan";
        // загрузка класса
        Class<Sedan> cl = (Class<Sedan>) Class.forName(className);

        // получение конструктора по-умолчанию
        Constructor<Sedan> constructor = cl.getConstructor();

        // создание экземпляра класса Sedan
        Sedan obj = constructor.newInstance();
        System.out.println(obj.getTrunkVolume());
    }
}
