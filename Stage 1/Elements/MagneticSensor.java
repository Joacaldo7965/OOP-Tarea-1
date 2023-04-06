package Elements;

public class MagneticSensor extends Sensor{

    public MagneticSensor() {
    }

    @Override
    public void activate() {
        setSwitchOpen(true);
    }
}
