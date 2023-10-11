/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Worker;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validate {
    public static boolean isValidId(String id, Map<String, Worker> workerDB) {
        return id != null && !id.trim().isEmpty() && !workerDB.containsKey(id);
    }

    public static String isValidName(Scanner scanner) {
        // Prompt user to input worker's Name and validate it
        String name = "";
        boolean validName = false;
        while (!validName) {
            System.out.print("Enter worker's Name: ");
            name = scanner.nextLine();

            if (name.matches(".*\\d.*") || name.matches(".*[^a-zA-Z\\s].*")) {
                System.out.println("Invalid name. Name should not contain numbers or special characters.");
            } else {
                validName = true;
            }
        }
        return name;
    }

    public static int isValidAge(Scanner scanner) {
        // Prompt user to input worker's Age and validate it
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.print("Enter worker's Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age >= 18 && age <= 50) {
                    validAge = true;
                } else {
                    System.out.println("Invalid age. Age must be in the range 18 to 50.");
                }
            } else {
                System.out.println("Invalid age. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
        return age;
    }

    public static double isValidInitialSalary(Scanner scanner) {
        // Prompt user to input worker's Initial Salary
        double initialSalary = 0;
        boolean validSalary = false;
        while (!validSalary) {
            System.out.print("Enter worker's Initial Salary: ");
            if (scanner.hasNextDouble()) {
                initialSalary = scanner.nextDouble();
                if (initialSalary <= 0) {
                    System.out.println("Salary must be greater than 0.");
                } else {
                    validSalary = true;
                }
            } else {
                System.out.println("Invalid salary. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
        return initialSalary;
    }

    public static String getSalaryStatus(double currentSalary, double initialSalary) {
        return (currentSalary > initialSalary) ? "UP" : (currentSalary < initialSalary) ? "DOWN" : "UP/DOWN";
    }
}   

