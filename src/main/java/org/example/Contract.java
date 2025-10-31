package org.example;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;

    //Calculated by childclasses
    protected double totalPrice;
    protected double monthlyPayment;

    //Constructor
    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    //Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    //Abstract methods to be implemented
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
    public abstract String getType(); //SALE or LEASE

    //helper method
    //converts to a CSV line for saving
    public String toCSV() {
        return getType() + "|" + date + "|" + customerName + "|" + customerEmail + "|" +
                vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                vehicle.getOdometer() + "|" + vehicle.getPrice() + "|";
    }
}
