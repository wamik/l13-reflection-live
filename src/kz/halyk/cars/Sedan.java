package kz.halyk.cars;


public class Sedan extends kz.halyk.cars.Car {

    private int trunkVolume;


    public Sedan(String body, String color, int trunkVolume) {
        super(body, color);
        this.trunkVolume = trunkVolume;
    }

    public int getTrunkVolume() {
        return trunkVolume;
    }

    public void setTrunkVolume(int trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", trunkVolume: " + trunkVolume;
    }
}
