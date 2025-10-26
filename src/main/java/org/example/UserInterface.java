package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership; //holds dealership data
    private Scanner scanner = new Scanner(System.in); //reads user input

    //Load dealership from file
    private void init() {

        //load dealership data directly here
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();

        if(dealership == null){
            System.out.println("Could not load. Please try again.");
        }
        else{
            System.out.println("Dealership loaded successfully.");
        }
    }

    //Run menu
    public void display() {

        boolean isRunning = true;
        init();

        while (isRunning) {
            System.out.println("---MAIN MENU---");
            System.out.println("1) Find vehicles within a price range");
            System.out.println("2) Find vehicles by make/model");
            System.out.println("3) Find vehicles by year range");
            System.out.println("4) Find vehicles by color");
            System.out.println("5) Find vehicles by mileage range");
            System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7) List ALL vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("-----------------");
            System.out.println("99) QUIT");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": processGetByPriceRequest(); break;
                case "2": processGetByMakeModelRequest(); break;
                case "3": processGetByYearRequest(); break;
                case "4": processGetByColorRequest(); break;
                case "5": processGetByMileageRequest(); break;
                case "6": processGetByVehicleTypeRequest(); break;
                case "7": processGetAllVehiclesRequest(); break;
                case "8": processAddVehiclesRequest(); break;
                case "9": processRemoveVehiclesRequest(); break;
                case "99":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid. Please try again.");
            }
        }
    }

    //Process Methods for each menu option
    private void processGetByPriceRequest(){
        double min = getDoubleInput("Enter minimum price: ");
        double max = getDoubleInput("Enter maximum price: ");

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest(){
            String make = getStringInput("Enter make: ");
            String model = getStringInput("Enter model: ");

            List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
            displayVehicles(vehicles);
    }

    private void processGetByYearRequest(){
        int min = getIntInput("Enter minimum year: ");
        int max = getIntInput("Enter maximum year: ");

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest(){
        String color = getStringInput("Enter color: ");

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest(){
        int min = getIntInput("Enter minimum mileage: ");
        int max = getIntInput("Enter maximum number: ");

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest(){
        String type = getStringInput("Enter vehicle type (car, truck, SUV, van): ");

        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    private void processGetAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void processAddVehiclesRequest(){
        int vin = getIntInput("Enter VIN: ");
        int year = getIntInput("Enter year: ");
        String make = getStringInput("Enter make: ");
        String model = getStringInput("Enter model: ");
        String type = getStringInput("Enter type (car, truck, SUV, van): ");
        String color = getStringInput("Enter color: ");
        int odometer = getIntInput("Enter odometer reading: ");
        double price = getDoubleInput("Enter price: ");

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle((newVehicle));

        //save updated info to CSV
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle successfully added!");
    }

    private void processRemoveVehiclesRequest(){
        int vin = getIntInput("Enter VIN of vehicle to remove: ");
        boolean removed = dealership.removeVehicle(vin);

        if (removed) {
            System.out.println("Vehicle successfully removed!");
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
        }
        else {
            System.out.println("Vehicle not found.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if(vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            //format assistance from research
            // %-8s String, left aligned, 8 characters wide (VIN)
            // %-6s String, left aligned, 6 characters wide (year)
            //etc...
            System.out.printf("%-8s %-6s %-10s %-10s %-8s %-10s %-12s %-10s%n", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            for (Vehicle v : vehicles) {
                System.out.printf("%-8d %-6d %-10s %-10s %-8s %-10s %-12d $%-10.2f%n", v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice());
            }
        }

        //Pause for smoother experience
        System.out.println("\nPress enter to return to the main menu");
        scanner.nextLine();
    }

    //.........................HELPER METHODS...........................
    //Rewrote my Process methods to go with Helper methods.
    //Need to have a safety net for each input so the program doesn't crash with a wrong input
    //Going with this approach because:
    //it would be a lot of repeating try catch blocks with a lot more room for error if I attempted to input it in each individual method.

    private int getIntInput(String prompt) {
        while(true){
            try {
                System.out.println(prompt);
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException exception){
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while(true){
            try {
                System.out.println(prompt);
                return Double.parseDouble(scanner.nextLine());
            }
            catch(NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private String getStringInput(String prompt) {
        while(true){
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Try again.");
            }

            // input.matches("\\d+") checks if the entire input is made up of only digits
            // if true, it's a number and we ask the user again for a text input
            if (input.matches("\\d+")) {
                System.out.println("Please enter text, not a number.");
            }

            return input;
        }
    }
}
