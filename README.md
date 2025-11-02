🚗 Dealership Management System

A Java console application to manage a vehicle dealership.
Manage inventory, sell or lease vehicles, and save contracts with CSV persistence.

✨ Features
🛠️ Vehicle Management

🔍 Search vehicles by:

💰 Price range

🚗 Make & Model

📅 Year range

🎨 Color

🛣️ Mileage range

🚙 Type (Car, Truck, SUV, Van)

➕ Add new vehicles to inventory

❌ Remove vehicles from inventory

💾 Save inventory to inventory.csv

💳 Sales & Lease Management

🏷️ Sell or lease a vehicle

💵 Display total price and monthly payment for both sale and lease

✅ Lease eligibility check (vehicles ≤ 3 years old)

🏦 Option to finance a sale

💾 Save contracts to contracts.csv

🗄️ Data Persistence

Inventory: src/main/resources/inventory.csv

Contracts: src/main/resources/contracts.csv

Files automatically created & updated

🖥️ User Interface

Interactive console menu

Input validation:

✍️ Names: letters only

📧 Emails: must include @ and .

📅 Dates: YYYYMMDD

🔢 Numbers: VIN, price, odometer, year

Clean formatted vehicle list

📂 Project Structure
src/main/java/org/example/
├── Vehicle.java               # Vehicle class
├── Dealership.java            # Manages inventory
├── DealershipFileManager.java # Reads/Writes inventory.csv
├── Contract.java              # Abstract contract class
├── SalesContract.java         # Implements Contract for sales
├── LeaseContract.java         # Implements Contract for leases
├── ContractFileManager.java   # Reads/Writes contracts.csv
├── UserInterface.java         # Console menu & input handling
└── Main.java                  # Entry point

⚙️ Installation & Run

Clone/download repository

Ensure Java 8+ is installed

Compile:

javac -d bin src/main/java/org/example/*.java


Run:

java -cp bin org.example.Main

📝 CSV Format
Inventory (inventory.csv)
VIN|Year|Make|Model|Type|Color|Odometer|Price
12345|2022|Toyota|Camry|Car|Blue|15000|24000.0

Contracts (contracts.csv)
CONTRACT_TYPE|DATE|CUSTOMER_NAME|CUSTOMER_EMAIL|VIN|YEAR|MAKE|MODEL|VEHICLE_TYPE|COLOR|ODOMETER|VEHICLE_PRICE|CONTRACT_FIELDS|TOTAL_PRICE|MONTHLY_PAYMENT
SALE|20251002|John Doe|john@example.com|12345|2022|Toyota|Camry|Car|Blue|15000|24000.0|NO FINANCE|24000.0|24000.0
LEASE|20251002|Jane Smith|jane@example.com|12346|2023|Honda|Civic|Car|Red|10000|26000.0|13000.0|13100.0|387.0

🖱️ How It Works

🚀 Start program → loads inventory from inventory.csv

📝 Main menu:

Search vehicles 🔍

List all vehicles 📋

Add/remove vehicles ➕❌

Sell/lease vehicle 💳

💵 Sell/Lease Process:

Enter vehicle VIN

Enter customer info & date

Display pricing for sale and lease

Confirm SALE or LEASE

If SALE → ask about financing

Contract created & saved

Vehicle removed from inventory

💾 CSV files updated automatically

🛡️ Input Validation

✍️ Names: Letters, spaces, hyphens only

📧 Emails: Must include @ and .

📅 Dates: Enter as YYYYMMDD (normalized automatically)

🔢 Numbers: VIN, year, odometer, price

📌 Notes

Lease only eligible for vehicles ≤ 3 years old

Finance option available only for SALE contracts

Console-based UI, no GUI

CSV files created if missing


👤 Author
Kayla Sanders
