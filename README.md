🚀 Selenium Web Automation Framework

This project is a Selenium-based web automation framework built with Java, using TestNG for execution and Cucumber for Behavior-Driven Development (BDD). The framework follows the Page Object Model (POM) to ensure clean, maintainable, and scalable code.

📋 Features

This automation framework includes comprehensive test scenarios for the following actions:

Registration

Login

Logout

Search for a Product

Add Product to Shopping Cart

Update Product Quantity in Cart

Checkout

View Order History

Return Order

Add Product to Wish List

Add Product to Compare

Add Product Review

Gift Certificate Purchase

Change Currency

Change Password

Use Contact Us



🛠 Technologies and Tools

Java: Main programming language
Maven: Dependency management
IntelliJ IDEA: IDE for development
Selenium WebDriver: Browser automation
TestNG: Test execution framework
Cucumber: BDD support with Gherkin syntax
Page Object Model (POM): Design pattern for organizing web elements and interactions
Apache POI: Data-driven testing (DDT) with Excel files



📂 Project Structure

src/main/java: Contains the core code, including page object classes.

src/test/java: Contains the test classes, written with TestNG and Cucumber.

src/test/resources: Contains Cucumber feature files.

data: Holds test data for data-driven testing using Excel.



🚀 Getting Started

Prerequisites
Install Java JDK (version 11 or higher)
Install Maven
Install IntelliJ IDEA
Setup Instructions

Clone the repository:
git clone https://github.com/yourusername/your-repo.git
Import the project into IntelliJ as a Maven project.
Update the dependencies by running:
mvn clean install

▶️ Running Tests

To run all tests with TestNG:
mvn test
To execute specific Cucumber scenarios:
mvn test -Dcucumber.options="--tags @tagname"
