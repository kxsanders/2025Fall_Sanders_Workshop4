package org.example;

public class SalesContract extends Contract {
   private static final double SALES_TAX_RATE = 0.05; //5%
   private static final double RECORDING_FEE = 100.00;

   private double processingFee; //$295 if < $10k, else $495
   private boolean financeOption; //true = financed, false = cash

   //Constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(date, customerName, customerEmail, vehicle);
        this.financeOption = financeOption;

        //The processing fee depends on price
        if(vehicle.getPrice() < 10000) {
            this.processingFee = 295.00;
        }
        else {
            this.processingFee = 495.00;
        }
    }

    /// ABSTRACT METHOD OVERRIDES
    /// implementing abstract methods from Contract parent class

    //calculate total sale price (car + tax + fees)
    @Override
    public double getTotalPrice(){
        double price = getVehicle().getPrice();
        double salesTax = price * SALES_TAX_RATE;

        return price + salesTax + RECORDING_FEE + processingFee;
    }

    //calculate monthly payment (if financed)
    @Override
    public double getMonthlyPayment(){
        if (!financeOption)
            return 0.0;

        double total = getTotalPrice();
        double interestRate;
        int months;

        if (getVehicle().getPrice() >= 10000) {
            interestRate = 0.0425; //4.25%
            months = 48;
        } else {
            interestRate = 0.0525; //5.25%
            months = 24;
        }
        double montlyRate = interestRate / 12;
        return (total * montlyRate) / (1 - Math.pow(1 + montlyRate, -months));
    }

    @Override
    public String getType() {
        return "SALE";
    }

    //override CSV output for this specific type of contract
    @Override
    public String toCSV(){
        double salesTax = getVehicle().getPrice() * SALES_TAX_RATE;
        return super.toCSV() +
                salesTax + "|" + RECORDING_FEE + "|" + processingFee + "|" +
                getTotalPrice() + "|" + (financeOption ? "YES" : "NO") + "|" + getMonthlyPayment();
        // ? : basically is just an if else.
        //IF finance option is true then YES, else NO.
    }
}
