# C195 Scheduling Application

---

## Purpose
> This application allows users to create, view, maintain, and delete customer appointments. Additionally,
users can generate reports on the data.

---

## Creating a Customer
- Dropdowns for US states and Provinces change automatically.
- Renders quickly after updating the MySQL database.

![customer](https://github.com/ike5/C195ProjectV1/blob/main/resources/Jun-10-2022%2018-36-11.gif)


## Deleting a Customer
- Prompts a warning
- Rerenders the table after updating the database.

![delete_customer](https://github.com/ike5/C195ProjectV1/blob/main/resources/Jun-10-2022%2018-38-54.gif)




## Personal Info

- Author: Ike Maldonado  
- Contact info: 
  - email: imald14@wgu.edu
- Application Version: 1.1
- Date: 12/08/2021

---

## System info

- IDE: IntelliJ IDEA 2021.2.2 (Ultimate Edition)  
- JDK: openjdk version "11.0.12" 2021-07-20 LTS
- JavaFX: javafx.runtime.version: 11.0.2+1

---

## Getting started
 
1. Set machine timezone in order for LocalTime ComboBoxes to populate correctly.
2. Run main() method in Main class.
3. Enter username: `test`, and password `test`, then hit enter or click `Login`.
    - This will create and append to `login_activity.txt`. This file will be created if not already present.

---

## Additional Report Description
- The additional report counts the total number of Appointments, Customers, Contacts, and logins (successful and unsuccessful). 
  - Location: `Reports Button > Additional Report Tab`

## MySQL info
MySQL version: 8.0.25  
Driver: mysql-connector-java-8.0.25

## Additional info
- Location of lambda expressions
  - `LoginController > changeScreen()`
  - `LoginController > changeScreen()`
  - `CustomersController > viewAppointmentsButtonOnAction()`
  - `CustomersController > reportsButtonOnAction()`
  - `AppointmentsController > newAppointmentButtonOnAction()`
  - `AppointemntsController > updateAppointmentButtonOnAction()`


