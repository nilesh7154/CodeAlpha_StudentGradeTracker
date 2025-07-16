package com.codealpha.grade;

import java.util.*;  

public class GradeTracker {
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
             sc.nextLine();                               
             String name = sc.nextLine();

             System.out.print("Enter Roll Number: ");
             int roll = sc.nextInt();

             int[] marks = new int[5];                 
             for (int i = 0; i < 5; i++) {
                 System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                 marks[i] = sc.nextInt();
             }

             
             Student s = new Student(name, roll, marks);
             students.add(s);
             System.out.println("✅ Student added successfully!");

         } else if (choice == 2) {
            
             if (students.isEmpty()) {
                 System.out.println("❌ No student records found.");
             } else {
                 System.out.println("\n--- Student Reports ---");
                 for (Student s : students) {
                     System.out.println("--------------------------");
                     s.displayReport();
                 }
             }

         } else if (choice == 3) {
            
             System.out.println("📘 Exiting... Thank you!");
             break;

         } else {
            
             System.out.println("❌ Invalid choice. Please try again.");
         }
     }

     sc.close(); 
 }
}

