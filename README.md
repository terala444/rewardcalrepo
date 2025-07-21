# Reward Points Calculator - Spring Boot

This project demonstrates a reward points calculation logic for a retailer using Spring Boot.

## 📋 Problem Statement

A customer earns:
- **2 points** for every dollar spent **over $100** in a transaction.
- **1 point** for every dollar spent **between $50 and $100** in a transaction.

📌 Example:

## 💡 Requirements Covered
- ✅ Spring Boot REST API
- ✅ RESTful endpoint to get reward points
- ✅ Hardcoded transaction dataset
- ✅ Monthly and total reward breakdown per customer
- ✅ GitHub repo with code and explanation

## 🔧 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/terala444/rewardcalrepo.git
2. Import into any IDE (IntelliJ, Eclipse) as Maven Project.
3. Run the Spring Boot app:
   mvn spring-boot:run
4. Access the endpoint:
http://localhost:8080/api/rewards

## API Response Example
{
  "John": {
    "2023-05": 90,
    "2023-06": 75,
    "Total": 165
  },
  "Alice": {
    "2023-07": 110,
    "Total": 110
  }
}
## Tech Stack
Java 8+
Spring Boot
Maven
REST API

## Author**
terala444

