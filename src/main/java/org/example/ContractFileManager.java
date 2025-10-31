package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {

    private static final String FILE_NAME = "src/main/resources/contracts.csv";
    private List<Contract> contracts;

    //constructor: initialize list
    public ContractFileManager() {
        contracts = new ArrayList<>();
    }

    //getter
    public List<Contract> getContracts() {
        return contracts;
    }

    // Add contract and save all
    public void addContract(Contract contract) {
        contracts.add(contract);
        saveAllContracts();
    }

    // Save entire list of contracts to CSV
    private void saveAllContracts() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))){

            //Write Header for clarity
            bufferedWriter.write("CONTRACT_TYPE|DATE|CUSTOMER_NAME|CUSTOMER_EMAIL|VIN|YEAR|MAKE|MODEL|VEHICLE_TYPE|COLOR|ODOMETER|VEHICLE_PRICE|CONTRACT_FIELDS|TOTAL_PRICE|MONTHLY_PAYMENT");
            bufferedWriter.newLine();

            //Write each contract
            for(Contract c : contracts){
                bufferedWriter.write(c.toCSV());
                bufferedWriter.newLine();
            }
            System.out.println("Contract(s) saved successfully.");
        }
        catch (IOException exception){
            System.out.println("Error saving contract(s).");
        }
    }


    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    //Load contracts from file
    public void loadContracts() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //can add parse logic later if needed.
                //For now, just keep in memory.
            }
        }
        catch (FileNotFoundException exception) {
            System.out.println("Contract(s) file not found.");
        }
        catch (IOException exception) {
            System.out.println("Error reading contract(s).");
        }

    }
}
