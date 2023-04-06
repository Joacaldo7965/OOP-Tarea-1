import Elements.Central;
import Elements.Door;
import Elements.Siren;
import Elements.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) throws IOException {
/*
        if(args.length == 0){
            System.out.println("Error no parameters specified!!");
            return;
        }

        String fileInputName = args[0];
*/

        String fileInputName = "C:\\Users\\joaca\\IdeaProjects\\OOP-Tarea1-Stage2\\src\\test.txt"; // Debugging purposes

        System.out.println(fileInputName);

        System.out.println("Abriendo el archivo " + fileInputName);
        File file = new File(fileInputName);
        Scanner scanner = new Scanner(file);

        int nDoors = scanner.nextInt();
        int nWindows = scanner.nextInt();
        int nPIRs = scanner.nextInt(); // Not used

        System.out.println("N° Doors: " + nDoors + "\n" +
                "N° Windows: " + nWindows + "\n" +
                "N° PIRs: " + nPIRs);

        // Create Doors
        Door doors[] = new Door[nDoors];
        for (int i = 0; i < nDoors; i++) {
            doors[i] = new Door();
        }

        // Create Windows
        Window windows[] = new Window[nWindows];
        for (int i = 0; i < nWindows; i++) {
            windows[i] = new Window();
        }

        // TODO: Create PIRs from file

        // Get Siren sound fileName
        String sirenFileName = scanner.next();
        System.out.println("Siren filename: " + sirenFileName);
        // Create Siren
        Siren siren = new Siren(sirenFileName); // TODO: add siren sound to parameter

        // Create Central
        Central central = new Central(doors, nDoors, windows, nWindows, siren);

        String fileName = "C:\\Users\\joaca\\IdeaProjects\\OOP-Tarea1\\src\\output.csv";

        FileWriter fileWriter = new FileWriter(fileName);

        // StringBuilder used to append and write to csv file
        StringBuilder stringBuilder = new StringBuilder();

        // Build the csv header
        stringBuilder.append("Step");
        for (int i = 0; i < nDoors; i++) {
            stringBuilder.append(", d" + i);
        }
        for (int i = 0; i < nWindows; i++) {
            stringBuilder.append(", w" + i);
        }
        for (int i = 0; i < nPIRs; i++) {
            stringBuilder.append(", Pir" + i);
        }
        stringBuilder.append(", Siren, Central\n");

        fileWriter.write(stringBuilder.toString());


        // Main loop with commands
        String inputFile = "C:\\Users\\joaca\\IdeaProjects\\OOP-Tarea1\\src\\input.txt";
        Scanner inputScanner = new Scanner(new File(inputFile));


        while (inputScanner.hasNext()){
            stringBuilder = new StringBuilder();

            String userInput = inputScanner.next();

            // TODO: remove this used for debugging
            if (userInput.equals("q")){
                break;
            }

            char command = userInput.charAt(0);

            // TODO: Check java version for this homework. (Enhanced switch statement available in j12
            switch (command) {
                case 'k' -> {
                    String param = inputScanner.next();
                    switch (param){
                        case "a" -> {
                            // Arm all
                            // TODO: Build string for output file
                            central.arm();
                        }
                        case "p" -> {
                            // Arm perimeter???
                            central.armPerimeter(); // TODO: implement this
                        }
                        case "d" -> {
                            // Disarm
                            central.disarm();
                        }
                        default -> {
                            // Raise error
                            throw new IllegalStateException("Unexpected value: " + param);
                        }
                    }
                }
                case 'd','w' -> { // Window or Door
                    int arrayIndex = userInput.charAt(1) - '0'; // char to int
                    System.out.println(arrayIndex);

                    String param = inputScanner.next();

                    System.out.println(param);
                    switch (param){
                        case "o" -> {
                            if(command == 'd'){
                                // Open doors[arrayIndex]
                                doors[arrayIndex].open(); // TODO: Change this to do ir from central
                                // TODO: Build string for output file

                            } else {
                                // Open windows[arrayIndex]
                                windows[arrayIndex].open();
                                // TODO: Build string for output file
                            }
                        }
                        case "c" -> {
                            if(command == 'd'){
                                // Close doors[arrayIndex]
                                doors[arrayIndex].close();
                                // TODO: Build string for output file
                            } else{
                                // Close windows[arrayIndex]
                                windows[arrayIndex].close();
                                // TODO: Build string for output file
                            }
                        }
                        default -> {
                            // Raise error
                            throw new IllegalStateException("Unexpected value: " + param);
                        }
                    }
                }
                case 'c' -> {
                    int x = inputScanner.nextInt();
                    int y = inputScanner.nextInt();

                    // TODO: Create person in (x, y) coords.
                }
                case 'p' -> {
                    int arrayIndex = userInput.charAt(1) - '0'; // char to int
                    System.out.println(arrayIndex);

                    String param = inputScanner.next();

                    System.out.println(param);


                    /*
                     * '↓' -> 8595
                     * '→' -> 8594
                     * '↑' -> 8593
                     * '←' -> 8592
                     * */
                    switch (param){
                        case "←" -> {
                            // TODO: Move people[arrayIndex] 0.5 to left
                        }
                        case "→" -> {
                            // TODO: Move people[arrayIndex] 0.5 to right
                        }
                        case "↑" -> {
                            // TODO: Move people[arrayIndex] 0.5 up
                        }
                        case "↓" -> {
                            // TODO: Move people[arrayIndex] 0.5 down
                        }
                        default -> {
                            // Raise error
                            throw new IllegalStateException("Unexpected value: " + param);
                        }

                    }
                }
                default -> {
                    // TODO: Maybe ask for new command
                    throw new IllegalStateException("Unexpected value: " + command);
                }
            }
            // TODO: Write state change to file

            stringBuilder.append("\n");
            fileWriter.write(stringBuilder.toString());
        }

        // Close output file
        fileWriter.close();


    }
}
