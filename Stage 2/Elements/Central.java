package Elements;

import java.util.ArrayList;

public class Central {
    // TODO: Add a Siren as an attribute of this class
    private boolean isArmed;
    private Door zone1; // Main door

    // Other doors and windows
    private ArrayList<Door> zone2Doors;
    private ArrayList<Window> zone2Windows;
    // TODO: zone 3 with PIRs

    private Siren siren;


    public Central(Door doors[], int nDoors, Window windows[], int nWindows, Siren siren) {
        isArmed = false;
        this.siren = siren;

        zone1 = doors[0];
        this.zone2Doors = new ArrayList<>();
        this.zone2Windows = new ArrayList<>();

        for (int i = 1; i < nDoors; i++) {
            zone2Doors.add(doors[i]);
        }
        for (int i = 0; i < nWindows; i++) {
            zone2Windows.add(windows[i]);
        }
    }

    public int arm(){
        // Check if all zones are closed
        String zonesNotClosed = getZonesNotClosed();
        if(zonesNotClosed.equals("")){
            // If all closed then arm
            isArmed = true;
            System.out.println("Se ha armado la alarma correctamente");
            return 1;
        }
        isArmed = false;
        System.out.println("Falta por cerrar la(s) zona(s): " + zonesNotClosed);
        return -1;


        // Else print zones not closed
    }

    public void armPerimeter(){
        // ????????????????
    }

    public void disarm(){
        isArmed = false;
    }

    public String getZonesNotClosed(){
        String zonesNotClosed = "";
        // Zone 1
        if(zone1.isOpen())
            zonesNotClosed += "1";
        // Zone 2
        boolean zone2Closed = true;
        for (Door door : zone2Doors) {
            if(door.isOpen()) {
                zonesNotClosed += " 2";
                zone2Closed = false;
                break;
            }
        }
        if (zone2Closed) { // To prevent adding " 2" twice
            for (Window window : zone2Windows) {
                if (window.isOpen()) {
                    zonesNotClosed += " 2";
                    break;
                }
            }
        }
        // TODO: zone 3

        return zonesNotClosed;
    }

    public String getState(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(boolToInt(zone1.isClosed()));

        // TODO: finish this
        for (Door door : zone2Doors) {
            stringBuilder.append(", " + boolToInt(door.isClosed()));
        }
        zone2Doors.forEach((door) -> stringBuilder.append(", " + boolToInt(door.isClosed())));

        for (Window window : zone2Windows) {
            stringBuilder.append(", " + boolToInt(window.isClosed()));
        }

        // TODO: Zone 3

        return stringBuilder.toString(); // TODO: ??????????
    }

    public void open(String object, int index){
        switch (object){
            case "d" -> {
                if(index == 0){
                    zone1.open();
                    return;
                }

            }
        }
    }

    private int boolToInt(boolean boo){
        return boo ? 1 : 0;
    }

    /* Getter and Setters */
    public boolean isArmed() {
        return isArmed;
    }
}
