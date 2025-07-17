package com.codealpha.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    // Reuse the same subject list defined in Student.java
    private static final String[] subjects = { "Math   ", "English", "Marathi", "Science", "History" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n====== Student Grade Tracker ======");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Student Reports");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                sc.nextLine(); // Consume newline
                String name = sc.nextLine();

                System.out.print("Enter Roll Number: ");
                int roll = sc.nextInt();

                int[] marks = new int[subjects.length];
                for (int i = 0; i < subjects.length; i++) {
                    System.out.print("Enter marks for " + subjects[i] + ": ");
                    marks[i] = sc.nextInt();
                }

                students.add(new Student(name, roll, marks));
                System.out.println("✅ Student added successfully!");

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("❌ No student records found.");
                } else {
                    System.out.println("\n--- Student Reports ---");

                    double totalScore = 0;
                    double highestScore = Double.MIN_VALUE;
                    double lowestScore = Double.MAX_VALUE;

                    for (Student s : students) {
                        System.out.println("________________________________________");
                        s.displayReport();
                        double avg = s.getAverageForSummary();
                        totalScore += avg;
                        if (avg > highestScore) highestScore = avg;
                        if (avg < lowestScore) lowestScore = avg;
                    }

                    double classAverage = totalScore / students.size();
                    System.out.println("\n📊 Summary:");
                    System.out.printf("Average Score: %.2f%n", classAverage);
                    System.out.printf("Highest Score: %.2f%n", highestScore);
                    System.out.printf("Lowest Score : %.2f%n", lowestScore);
                }

            } else if (choice == 3) {
                System.out.print("Do you want to restart the application? (yes/no): ");
                sc.nextLine(); // consume leftover newline
                String restart = sc.nextLine().trim().toLowerCase();

                if (restart.equals("yes") || restart.equals("y")) {
                    continue; // go back to main menu
                } else {
                    System.out.println("📘 Exiting... Thank you!");
                    break;
                }
            } else {
                System.out.println("❌ Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
