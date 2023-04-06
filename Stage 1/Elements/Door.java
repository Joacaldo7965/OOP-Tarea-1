package Elements;

public class Door {
    private MagneticSensor magneticSensor;

    public Door() {
        magneticSensor = new MagneticSensor();
    }

    public void open(){
        magneticSensor.activate();
    }

    public void close(){
        magneticSensor.reset();
    }
}
