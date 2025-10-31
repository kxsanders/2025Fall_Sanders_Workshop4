package org.example;

public class LeaseContract extends Contract{
    //lease contract reps a vehicle lease
    //handles lease fees, expected end value, and monthly payments
    private static final double LEASE_FEE_RATE = 0.07; //7% lease fee
    private static final double FINANCE_RATE = 0.04; //4% annual interest
    private static final int LEASE_MONTHS = 36;

    private double expectedEndingValue; //50% of vehicle price
    private double leaseFee; //calculated as 7% of vehicle price

    //Constructor

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    /// ABSTRACT METHOD OVERRIDES
    ///implementing abstract methods from Contract parent class
    @Override
    public double getTotalPrice() {
        //ending value + lease fee
        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        //Monthly payment financed over 36 months at 4% interest
        double total = getTotalPrice();
        double monthlyRate = FINANCE_RATE / 12;
        return  (total * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -LEASE_MONTHS));
    }

    @Override
    public String getType(){
        return "LEASE";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + expectedEndingValue + "|" + leaseFee + "|" + getTotalPrice() + "|" + getMonthlyPayment();
    }
}
