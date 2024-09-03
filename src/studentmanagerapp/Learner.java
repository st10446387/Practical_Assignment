/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagerapp;

/**
 *
 * @author kevin
 */


import java.util.ArrayList;

public class Learner {
    private String learnerId;
    private String learnerName;
    private int learnerAge;
    private String learnerEmail;
    private String learnerCourse;

    // Constructor
    public Learner(String id, String name, int age, String email, String course) {
        this.learnerId = id;
        this.learnerName = name;
        this.learnerAge = age;
        this.learnerEmail = email;
        this.learnerCourse = course;
    }

    // Getters
    public String getLearnerId() {
        return learnerId;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public int getLearnerAge() {
        return learnerAge;
    }

    public String getLearnerEmail() {
        return learnerEmail;
    }

    public String getLearnerCourse() {
        return learnerCourse;
    }

    // Save learner information
    public void saveLearnerDetails(ArrayList<Learner> learnerList) {
        learnerList.add(this);
    }

    // Static methods for Learner operations
    public static void searchLearnerById(ArrayList<Learner> learnerList, String id) {
        for (Learner learner : learnerList) {
            if (learner.getLearnerId().equals(id)) {
                System.out.println("LEARNER ID: " + learner.getLearnerId());
                System.out.println("LEARNER NAME: " + learner.getLearnerName());
                System.out.println("LEARNER AGE: " + learner.getLearnerAge());
                System.out.println("LEARNER EMAIL: " + learner.getLearnerEmail());
                System.out.println("LEARNER COURSE: " + learner.getLearnerCourse());
                return;
            }
        }
        System.out.println("No learner found with ID: " + id);
    }

    public static void removeLearnerById(ArrayList<Learner> learnerList, String id) {
        for (Learner learner : learnerList) {
            if (learner.getLearnerId().equals(id)) {
                learnerList.remove(learner);
                System.out.println("Learner with ID: " + id + " has been removed.");
                return;
            }
        }
        System.out.println("No learner found with ID: " + id);
    }

    public static void displayLearnerReport(ArrayList<Learner> learnerList) {
        int learnerCounter = 1;
        for (Learner learner : learnerList) {
            System.out.println("LEARNER " + learnerCounter);
            System.out.println("LEARNER ID: " + learner.getLearnerId());
            System.out.println("LEARNER NAME: " + learner.getLearnerName());
            System.out.println("LEARNER AGE: " + learner.getLearnerAge());
            System.out.println("LEARNER EMAIL: " + learner.getLearnerEmail());
            System.out.println("LEARNER COURSE: " + learner.getLearnerCourse());
            System.out.println("-----------------------------------------");
            learnerCounter++;
        }
    }

    public static void exitApplication() {
        System.out.println("Exiting the system...");
        System.exit(0);
    }
}
