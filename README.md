# My Note Automated Testing

This repository contains automated tests for the My Note website using WebDriver in Java. The tests are designed to ensure that the website's key features and functionalities including notes, login, signup work as expected.

## Prerequisites

Before running the tests, make sure you have the following prerequisites set up:
- Intellij
- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- Chrome WebDriver
- Extent Reports
- My Note website URL
- Maven Dependencies

## Installation
1. Install the "IntelliJ IDEA Community Edition" version of IntelliJ from this link https://www.jetbrains.com/idea/download/?section=windows based on your OS.
2. Install JDK version 17 bin file from https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html based on your OS.
3. Install the Google Chrome browser version 145.0.7632.68 (Official Build) (64-bit) on your device.
4. Install the Google Chrome driver version 145.0.7632.67 on your device from https://googlechromelabs.github.io/chrome-for-testing/#stable.
5. Make sure the Chrome driver version is compatible with the Chrome browser.

## Getting Started
1. Clone the project from GitHub.
2. Open IntelliJ and choose the Maven Project.
3. Open the cloned project on IntelliJ.
4. Open the pom.xml file to load the Maven Dependencies
5. Click on the Maven symbol on pom.xml to load all the presented Maven Dependencies.
6. The Maven Dependencies consist of  Selenium Webdriver, Junit, and TestNG.
8. Run the test by right-clicking on FullFowTest and clicking on run.
9. Leave the automation browser till it closes itself to generate the real-time report.
10. If the automated browser is closed before finishing the automation, the real-time report will not overwrite.


## Test Structure

The tests are organized into different classes within the `test` package:

* FullFlowTest: The main test class containing test methods for all features of the My Note website.
* RegressionTest: The test class containing test methods for regression test only.
* SmokeTest: The test class containing test methods for the smoke test only.

Each test class corresponds to a specific page of the website.

