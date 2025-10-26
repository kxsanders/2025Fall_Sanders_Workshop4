package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DealershipFileManager {

    private static String fileName = "src/main/resources/inventory.csv";

    //Reads dealership file, builds dealership object
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            //Open file to read
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            //Read first line (dealership info)
            String firstline = bufferedReader.readLine();

            //Split using "|"
            String[] dealershipInfo = firstline.split("\\|");

            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            //create dealership
            dealership = new Dealership(name, address, phone);

            //read the rest of the lines
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\\|");

                //Turn each line into a vehicle object
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

                //add to dealership
                dealership.addVehicle(vehicle);
            }

            //close file when done
            bufferedReader.close();
        }

        catch(IOException exception){
            System.out.println("There was a problem reading the file.");
        }
        return dealership;

    }

    // ADD LATER
    public void saveDealership (Dealership dealership){
        //DO: SAVE DATA TO FILE
    }

}
