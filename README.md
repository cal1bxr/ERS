# Employee Reimbursement System (ERS)

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used:  
  Java, 
  SQL, 
  CSS, 
  HTML, 
  JavaScript, 
  JUnit, 
  Hibernate, 
  AWS RDS, 
  Log4J, 
  Javalin

## Features:  
  Login  
  A manager and employee account with different levels of priveledges and acess
  All employees can submit reimbursement requests  
  All employees can view their past and pending reimbursements  
  Managers can view request for each employee individually
  Managers can approve or deny requests  

**Possible future developement features:**  
  Convert into an SPA  
  Custom CSS
  Fix issue with viewing all requests

## Setting up the application:

**Clone the repository somewhere onto your computer with git**  

**Import an existing Maven project into your IDE**  

**Select the folder into which you cloned the repository**  

**Create schema in database called ers_reimbursement**

**Run the Main class as a java application**  

**Navigate to localhost:8081/index.html**


## Usage

Login into app using accounts listed in database, or create account in database for login.
Once logged in use text fields to enter information based on info listed in model diagrams below.


**State-chart Diagram (Reimbursement Statuses)** 
![](./imgs/state-chart.jpg)

**Reimbursement Types**

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)

