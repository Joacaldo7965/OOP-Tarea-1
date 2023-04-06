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

    public boolean isOpen(){
        return magneticSensor.isSwitchOpen();
    }

    public boolean isClosed(){ return !magneticSensor.isSwitchOpen();}
}
