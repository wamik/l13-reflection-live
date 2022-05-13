package kz.halyk.cars;

public class SUV extends Sedan{

    private int clirense;

    public SUV(String body, String color, int trunkVolume, int clirense) {
        super(body, color, trunkVolume);
        this.clirense = clirense;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", clirense: " + this.clirense;
    }
}
