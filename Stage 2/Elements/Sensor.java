package Elements;

public abstract class Sensor {
    private boolean isSwitchOpen;

    public Sensor() {
        isSwitchOpen = false;
    }

    public abstract void activate();

    public void reset(){
        isSwitchOpen = false;
    }

    public boolean isSwitchOpen() {
        return isSwitchOpen;
    }

    public void setSwitchOpen(boolean switchOpen) {
        isSwitchOpen = switchOpen;
    }
}
