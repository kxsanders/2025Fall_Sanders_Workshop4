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
                case "2": //ADD
                case "3": //ADD
                case "4": //ADD
                case "5": //ADD
                case "6": //ADD
                case "7": //ADD
                case "8": //ADD
                case "9": //ADD
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
        System.out.println("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }
    private void processGetByMakeModelRequest(){
        //ADD
    }

    private void processGetByYearRequest(){
        //ADD
    }

    private void processGetByColorRequest(){
        //ADD
    }

    private void processGetByMileageRequest(){
        //ADD
    }

    private void processGetByVehicleTypeRequest(){
        //ADD
    }

    private void processGetAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void processAddVehiclesRequest(){
        //ADD
    }

    private void processRemoveVehiclesRequest(){
        //ADD
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if(vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
        //Pause for smoother experience
        System.out.println("\nPress enter to return to the main menu");
        scanner.nextLine();
    }

}
