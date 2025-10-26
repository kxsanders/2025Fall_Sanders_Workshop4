package org.example;

import java.io.*;
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


    public void saveDealership (Dealership dealership){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            //Dealership info first
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            //write each vehicle
            for (Vehicle v : dealership.getAllVehicles()){
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully.");
        }
        catch(IOException exception){
            System.out.println("Error saving dealership file.");
        }

    }

}
