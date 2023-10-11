package View;

import java.util.Scanner;

public class WorkerView {
    public int showMenuAndGetChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWorker Management System");
        System.out.println("1. Add a Worker");
        System.out.println("2. Increase Salary");
        System.out.println("3. Decrease Salary");
        System.out.println("4. Show Adjusted Salary by Worker Code");
        System.out.println("5. Quit");

        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
