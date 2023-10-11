//package Controller;
//
//import View.WorkerView;
//import Model.Worker;
//import java.time.LocalDate;
//import java.util.*;
//
//public class WorkerController {
//    private Map<String, Worker> workerDB = new HashMap<>();
//    private List<String> salaryHistory = new ArrayList<>();
//    private WorkerView view;
//    private Map<String, Double> initialSalaries = new HashMap<>(); // Lưu mức lương ban đầu
//
//    public WorkerController(WorkerView view) {
//        this.view = view;
//    }
//
//    public void run() {
//        while (true) {
//            int choice = view.showMenuAndGetChoice();
//
//            switch (choice) {
//                case 1:
//                    addWorker();
//                    break;
//                case 2:
//                    changeSalary(SalaryStatus.INCREASE);
//                    break;
//                case 3:
//                    changeSalary(SalaryStatus.DECREASE);
//                    break;
//                case 4:
//                    showAd();
//                    break;
//                case 5:
//                    System.out.println("Goodbye!");
//                    return;
//                default:
//                    System.out.println("Invalid option. Please choose a valid option.");
//            }
//        }
//    }
//
//    private void addWorker() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Adding a Worker:");
//
//        // Prompt user to input worker information
//        System.out.print("Enter worker's ID: ");
//        String id = scanner.nextLine();
//
//        // Check data input is valid
//        if (id == null || id.trim().isEmpty() || workerDB.containsKey(id)) {
//            System.out.println("Invalid ID. It cannot be null or duplicated.");
//            return;
//        }
//
//        // Prompt user to input worker's Name and validate it
//        String name = "";
//        boolean validName = false;
//        while (!validName) {
//            System.out.print("Enter worker's Name: ");
//            name = scanner.nextLine();
//
//            if (name.matches(".*\\d.*") || name.matches(".*[^a-zA-Z\\s].*")) {
//                System.out.println("Invalid name. Name should not contain numbers or special characters.");
//            } else {
//                validName = true;
//            }
//        }
//
//        // Prompt user to input worker's Age and validate it
//        int age = 0;
//        boolean validAge = false;
//        while (!validAge) {
//            System.out.print("Enter worker's Age: ");
//            if (scanner.hasNextInt()) {
//                age = scanner.nextInt();
//                if (age >= 18 && age <= 50) {
//                    validAge = true;
//                } else {
//                    System.out.println("Invalid age. Age must be in the range 18 to 50.");
//                }
//            } else {
//                System.out.println("Invalid age. Please enter a valid number.");
//                scanner.next(); // Consume the invalid input
//            }
//        }
//
//        // Prompt user to input worker's Initial Salary
//        double initialSalary = 0;
//        boolean validSalary = false;
//        while (!validSalary) {
//            System.out.print("Enter worker's Initial Salary: ");
//            if (scanner.hasNextDouble()) {
//                initialSalary = scanner.nextDouble();
//                if (initialSalary <= 0) {
//                    System.out.println("Salary must be greater than 0.");
//                } else {
//                    validSalary = true;
//                }
//            } else {
//                System.out.println("Invalid salary. Please enter a valid number.");
//                scanner.next(); // Consume the invalid input
//            }
//        }
//
//        initialSalaries.put(id, initialSalary);
//
//        // Prompt user to input worker's Work Location
//        scanner.nextLine(); // Consume the newline character
//        System.out.print("Enter worker's Work Location: ");
//        String workLocation = scanner.nextLine();
//
//        Worker worker = new Worker(id, name, age, initialSalary, workLocation);
//        workerDB.put(id, worker);
//        System.out.println("Worker added successfully.");
//        System.out.println("Worker Information:\n" + worker.toString());
//    }
//
//    private void changeSalary(SalaryStatus status) {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println(status == SalaryStatus.INCREASE ? "Increasing Salary:" : "Decreasing Salary:");
//
//    // Prompt user to input Code(id)
//    System.out.print("Enter worker's ID: ");
//    String id = scanner.nextLine();
//
//    if (!workerDB.containsKey(id)) {
//        System.out.println("Worker with ID " + id + " does not exist in the database.");
//        return;
//    }
//
//    // Prompt user to input the amount to raise or cut
//    System.out.print("Enter the amount to " + (status == SalaryStatus.INCREASE ? "raise: " : "cut: "));
//    double amount = scanner.nextDouble();
//    scanner.nextLine();
//
//    if (amount <= 0) {
//        System.out.println("Invalid amount. Amount must be greater than 0.");
//        return;
//    }
//
//    Worker worker = workerDB.get(id);
//    double currentSalary = worker.getSalary();
//    double initialSalary = initialSalaries.get(id); // Lấy mức lương ban đầu
//
//    double newSalary = (status == SalaryStatus.INCREASE) ? (currentSalary + amount) : (currentSalary - amount);
//
//    if (newSalary < 0 && status == SalaryStatus.DECREASE) {
//        System.out.println("Invalid cut amount. The new salary would be negative.");
//        return;
//    }
//
//    worker.setSalary(newSalary);
//
//    // Xác định trạng thái (UP hoặc DOWN)
//    String statusLabel = (newSalary > initialSalary) ? "UP" : "DOWN";
//
//    String historyEntry = "W " + id + " " + worker.getName() + " " + worker.getAge() + " " + initialSalary + " " + statusLabel + " " + LocalDate.now();
//
//    // Display the date
//    System.out.println("Date: " + LocalDate.now());
//
//    salaryHistory.add(historyEntry);
//    System.out.println("Salary " + statusLabel + " successfully.");
//    System.out.println("Updated Worker Information:\n" + worker.toString());
//}
//
//
//    private void showAd() {
//    System.out.println("--------------------Display Information Salary-----------------------");
//    System.out.println("Code\tName\tAge\tSalary\tStatus\tDate");
//
//    for (Map.Entry<String, Worker> entry : workerDB.entrySet()) {
//        String code = entry.getKey();
//        Worker worker = entry.getValue();
//        String name = worker.getName();
//        String age = String.valueOf(worker.getAge());
//        String salary = String.valueOf(worker.getSalary());
//
//        double initialSalary = initialSalaries.get(code);
//        String status = "UP/DOWN";
//        if (worker.getSalary() > initialSalary) {
//            status = "UP";
//        } else if (worker.getSalary() < initialSalary) {
//            status = "DOWN";
//        }
//
//        String date = LocalDate.now().toString();
//
//        System.out.println("W " + code + "\t" + name + "\t" + age + "\t" + salary + "\t" + status + "\t" + date);
//    }
//}
//
//    enum SalaryStatus {
//        INCREASE, DECREASE
//    }
//}
package Controller;

import View.WorkerView;
import Model.Worker;
import java.time.LocalDate;
import java.util.*;

public class WorkerController {
    private Map<String, Worker> workerDB = new HashMap<>();
    private List<String> salaryHistory = new ArrayList<>();
    private WorkerView view;
    private Map<String, Double> initialSalaries = new HashMap<>(); // Lưu mức lương ban đầu

    public WorkerController(WorkerView view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            int choice = view.showMenuAndGetChoice();

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    changeSalary(SalaryStatus.INCREASE);
                    break;
                case 3:
                    changeSalary(SalaryStatus.DECREASE);
                    break;
                case 4:
                    showAd();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void addWorker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a Worker:");

        // Prompt user to input worker information
        System.out.print("Enter worker's ID: ");
        String id = scanner.nextLine();

        if (!Validate.isValidId(id, workerDB)) {
            System.out.println("Invalid ID. It cannot be null or duplicated.");
            return;
        }

        String name = Validate.isValidName(scanner);
        int age = Validate.isValidAge(scanner);
        double initialSalary = Validate.isValidInitialSalary(scanner);
        initialSalaries.put(id, initialSalary);

        // Prompt user to input worker's Work Location
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter worker's Work Location: ");
        String workLocation = scanner.nextLine();

        Worker worker = new Worker(id, name, age, initialSalary, workLocation);
        workerDB.put(id, worker);
        System.out.println("Worker added successfully.");
        System.out.println("Worker Information:\n" + worker.toString());
    }

    private void changeSalary(SalaryStatus status) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(status == SalaryStatus.INCREASE ? "Increasing Salary:" : "Decreasing Salary:");

        // Prompt user to input Code(id)
        System.out.print("Enter worker's ID: ");
        String id = scanner.nextLine();

        if (!workerDB.containsKey(id)) {
            System.out.println("Worker with ID " + id + " does not exist in the database.");
            return;
        }

        // Prompt user to input the amount to raise or cut
        System.out.print("Enter the amount to " + (status == SalaryStatus.INCREASE ? "raise: " : "cut: "));
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount. Amount must be greater than 0.");
            return;
        }

        Worker worker = workerDB.get(id);
        double currentSalary = worker.getSalary();
        double initialSalary = initialSalaries.get(id); 

        double newSalary = (status == SalaryStatus.INCREASE) ? (currentSalary + amount) : (currentSalary - amount);

        if (newSalary < 0 && status == SalaryStatus.DECREASE) {
            System.out.println("Invalid cut amount. The new salary would be negative.");
            return;
        }

        worker.setSalary(newSalary);

        // Xác định trạng thái (UP hoặc DOWN)
        String statusLabel = Validate.getSalaryStatus(newSalary, initialSalary);

        String historyEntry = "W " + id + " " + worker.getName() + " " + worker.getAge() + " " + initialSalary + " " + statusLabel + " " + LocalDate.now();

        // Display the date
        System.out.println("Date: " + LocalDate.now());

        salaryHistory.add(historyEntry);
        System.out.println("Salary " + statusLabel + " successfully.");
        System.out.println("Updated Worker Information:\n" + worker.toString());
    }

    private void showAd() {
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.println("Code\tName\tAge\tSalary\tStatus\tDate");

        for (Map.Entry<String, Worker> entry : workerDB.entrySet()) {
            String code = entry.getKey();
            Worker worker = entry.getValue();
            String name = worker.getName();
            String age = String.valueOf(worker.getAge());
            String salary = String.valueOf(worker.getSalary());

            double initialSalary = initialSalaries.get(code);
            String status = Validate.getSalaryStatus(worker.getSalary(), initialSalary);
            String date = LocalDate.now().toString();

            System.out.println("W " + code + "\t" + name + "\t" + age + "\t" + salary + "\t" + status + "\t" + date);
        }
    }

    enum SalaryStatus {
        INCREASE, DECREASE
    }
}
