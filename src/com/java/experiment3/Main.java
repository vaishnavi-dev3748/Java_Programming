package com.java.experiment3;

//Main.java
public class Main {
 public static void main(String[] args) {
     // Creating Employee and Manager objects
     Employee emp = new Employee("Vaishnavi", 22, 50000);
     Manager mngr = new Manager("Isha", 24, 80000, 10000);

     // Display info and salary
     emp.displayInfo();
     System.out.println("Employee Salary: " + emp.calculateSalary());

     mngr.displayInfo();
     System.out.println("Manager Salary: " + mngr.calculateSalary());

     // Update Employee data (Method Overloading)
     emp.updateEmployeeData("Shreya");
     emp.updateEmployeeData(21);
     emp.updateEmployeeData(70000);
 }
}