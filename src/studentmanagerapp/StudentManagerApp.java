/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagerapp;

/**
 *
 * @author kevin
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerApp {
    private static ArrayList<Learner> learnerList = new ArrayList<>();
    private static Scanner inputDevice = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("LEARNER MANAGEMENT SYSTEM");
            System.out.println("=========================");
            System.out.println("Press (1) to open the menu or any other key to exit.");
            String userChoice = inputDevice.nextLine();

            if (!userChoice.equals("1")) {
                Learner.exitApplication();
            }

            showMenu();
        }
    }

    private static void showMenu() {
        System.out.println("Select an option from the menu below:");
        System.out.println("(1) Register a new learner.");
        System.out.println("(2) Find a learner.");
        System.out.println("(3) Remove a learner.");
        System.out.println("(4) Generate learner report.");
        System.out.println("(5) Quit the system.");

        String userChoice = inputDevice.nextLine();

        switch (userChoice) {
            case "1":
                registerLearner();
                break;
            case "2":
                findLearner();
                break;
            case "3":
                removeLearner();
                break;
            case "4":
                generateLearnerReport();
                break;
            case "5":
                Learner.exitApplication();
                break;
            default:
                System.out.println("Invalid selection! Please choose a valid option.");
                showMenu();
        }
    }

    private static void registerLearner() {
        System.out.println("REGISTER A NEW LEARNER");
        System.out.println("======================");

        System.out.print("Enter learner ID: ");
        String learnerId = inputDevice.nextLine();

        System.out.print("Enter learner name: ");
        String learnerName = inputDevice.nextLine();

        System.out.print("Enter learner age: ");
        int learnerAge = inputDevice.nextInt();
        inputDevice.nextLine(); // Consuming the remaining newline

        while (learnerAge < 16) {
            System.out.println("Invalid age! Please enter a valid learner age.");
            System.out.print("Enter learner age: ");
            learnerAge = inputDevice.nextInt();
            inputDevice.nextLine(); // Consuming the remaining newline
        }

        System.out.print("Enter learner email: ");
        String learnerEmail = inputDevice.nextLine();

        System.out.print("Enter learner course: ");
        String learnerCourse = inputDevice.nextLine();

        Learner newLearner = new Learner(learnerId, learnerName, learnerAge, learnerEmail, learnerCourse);
        newLearner.saveLearnerDetails(learnerList);

        System.out.println("Learner registration successful!");
    }

    private static void findLearner() {
        System.out.print("Enter learner ID to search: ");
        String learnerId = inputDevice.nextLine();
        Learner.searchLearnerById(learnerList, learnerId);
    }

    private static void removeLearner() {
        System.out.print("Enter learner ID to remove: ");
        String learnerId = inputDevice.nextLine();
        System.out.print("Confirm removal of learner " + learnerId + " from the system? Type 'y' to confirm: ");
        String confirmation = inputDevice.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            Learner.removeLearnerById(learnerList, learnerId);
        }
    }

    private static void generateLearnerReport() {
        Learner.displayLearnerReport(learnerList);
    }
}

