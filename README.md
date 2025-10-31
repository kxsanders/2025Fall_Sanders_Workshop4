# 🚗 Dealership Inventory Program

## 📋 Overview
A simple **Java program** to manage a car dealership inventory.  
- **View, search, add, and remove vehicles** from a CSV file  
- **Safe input handling** to prevent crashes  

---

## ✨ Features
- 🔹 Search vehicles by **price**, **make/model**, **year**, **color**, **mileage**, or **type**  
- 🔹 **List all vehicles** in a formatted table  
- 🔹 **Add or remove vehicles** easily  
- 🔹 **Auto-save** changes to CSV  
- 🔹 **Input validation** for numbers and text  

---

## 🛠 Requirements
- Java 8+  
- IDE or terminal  

---

## 🚀 How to Run
1. Place `inventory.csv` in `src/main/resources/`  
2. Compile:

```bash
javac -d bin src/main/java/org/example/*.java

Run:
java -cp bin org.example.Program
Follow the menu prompts:

---MAIN MENU---
1) Find vehicles within a price range
2) Find vehicles by make/model
3) Find vehicles by year range
4) Find vehicles by color
5) Find vehicles by mileage range
6) Find vehicles by type (car, truck, SUV, van)
7) List ALL vehicles
8) Add a vehicle
9) Remove a vehicle
99) QUIT

💾 CSV Format
DealershipName|Address|Phone
VIN|Year|Make|Model|Type|Color|Odometer|Price

Example:
My Dealership|123 Main St|555-1234
1001|2020|Honda|Civic|Car|Blue|15000|20000.00
1002|2018|Ford|F-150|Truck|Red|45000|25000.00

📝 Notes
Strings allow letters, spaces, and hyphens only
Numbers are validated to prevent errors
Beginner-friendly and easy to follow

👤 Author
Kayla Sanders
