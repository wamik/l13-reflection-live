package kz.halyk.cars;


@kz.halyk.cars.DeprecatedModel(newOffer = kz.halyk.cars.SUV.class)
public class Car {

    private String body;
    private String color;

    public Car() {
    }

    public Car(String body, String color) {
        this.body = body;
        this.color = color;
    }

     String getInfo(){
        return "Body: " + body + ", color: " + color;
    }
}
