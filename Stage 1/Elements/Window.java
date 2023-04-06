package Elements;

public class Window {
    private MagneticSensor magneticSensor;

    public Window() {
        magneticSensor = new MagneticSensor();
    }

    public void open(){
        magneticSensor.activate();
    }

    public void close(){
        magneticSensor.reset();
    }
}
