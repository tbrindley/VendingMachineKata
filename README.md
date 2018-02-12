# Vending Machine Kata
## Overview
This kata simulates a vending machine and its core functionality.  The vending machine can do the following:

- Accept coins (nickels, dimes & quarters)
- Rejects pennies & any random junk 'coin' inserted into machine
- Allows consumer to select 1 of 3 products 'cola, chips, candy'
- The vending machine will make change or return coins
- The vending machine will notify user if the machine is sold out of an item
- Will notify consumer that the machine is exact change only when there is insufficient change to return correct change.

## Dependencies
There are a few dependencies needed to run this application.  All dependencies are managed through [Maven](https://maven.apache.org/).  In order to both run and test this application, you will need to have the following dependencies added:
* JDK8
* JUnit - for testing

All dependencies are available in the include pom.xml file.
## Building Tests
* The easiest way to run the tests is to go to the parent directory of this project and run through Maven.
    * Open command Prompt and navigate to the parent directory.
    * From the parent directory, run
    ```
    mvn clean test
    ```
    * This will automatically compile all tests, add any necessary packages, and run them.

## Building and Running
*  Clone this project from the github repository [https://github.com/tbrindley/VendingMachineKata.git](https://github.com/tbrindley/VendingMachineKata.git)
*  Ensure all dependencies have been added to your package.  Once again, these can be viewed in the pom.xml file
    * Don't forget to reimport from Maven after adding the dependencies.
