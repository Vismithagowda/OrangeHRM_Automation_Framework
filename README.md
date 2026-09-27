# OrangeHRM Automation Framework

## Project Overview

This project is a Selenium WebDriver automation framework developed using Java, TestNG, Maven, and Page Object Model (POM).

The framework automates key workflows of the OrangeHRM application and demonstrates a structured approach to UI automation testing.

## Application

OrangeHRM Open Source Demo
https://opensource-demo.orangehrmlive.com/

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Apache POI
* Git & GitHub
* IntelliJ IDEA

## Framework Features

* Page Object Model design
* Reusable WebDriver setup using DriverFactory
* Explicit waits using WebDriverWait
* Configuration management using properties file
* Excel-based test data handling
* Screenshot utility
* TestNG listeners
* TestNG annotations and test dependencies
* Maven test execution
* Reusable utility classes
* Assertions for test validation

## Modules Covered

### Login

* Valid login
* Invalid login

### Logout

* Logout from the application

### Employee Management

* Add employee
* Capture generated Employee ID
* Search employee using generated Employee ID
* Delete employee

### Leave Management

* Navigate to Leave module
* Apply Leave workflow
* Leave type selection
* Negative scenario validation

### Admin

* Search users
* Reset search
* Add new user

### Recruitment

* Recruitment page validation
* Add candidate
* Recruitment workflow scenarios

## Project Structure

```text
OrangeHRM_Automation_Framework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   ├── driver
│   │   │   ├── pages
│   │   │   └── utils
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       └── java
│           ├── tests
│           └── listeners
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

## Test Execution

### Using IntelliJ

Run the TestNG test classes directly from IntelliJ IDEA.

### Using Maven

Run all tests using:

```bash
mvn clean test
```

## Test Execution Result

The complete test suite currently executes successfully:

```text
Tests run: 11
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## Key Automation Concepts Demonstrated

* Selenium WebDriver automation
* XPath locators
* Explicit waits
* Page Object Model
* TestNG annotations
* Test dependencies
* Dynamic test data handling
* Reusable test utilities
* Configuration management
* Screenshot capture
* Test execution through Maven
* TestNG listeners

## Purpose

This project was created to practice and demonstrate practical Selenium automation framework development using Java and industry-relevant testing concepts.
