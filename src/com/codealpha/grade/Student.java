package com.codealpha.grade;


public class Student {
 private String name;        
 private int rollNumber;      
 private int[] marks;         

 
 public Student(String name, int rollNumber, int[] marks) {
     this.name = name;
     this.rollNumber = rollNumber;
     this.marks = marks;
 }

 
 public int getTotal() {
     int sum = 0;
     for (int m : marks) {
         sum += m;
     }
     return sum;
 }

 
 public double getAverage() {
     return getTotal() / (double) marks.length;
 }

 
 public int getHighest() {
     int max = marks[0];
     for (int m : marks) {
         if (m > max) max = m;
     }
     return max;
 }

 
 public int getLowest() {
     int min = marks[0];
     for (int m : marks) {
         if (m < min) min = m;
     }
     return min;
 }

 
 public String getGrade() {
     double avg = getAverage();
     if (avg >= 80) return "A";
     else if (avg >= 60) return "B";
     else if (avg >= 40) return "C";
     else return "F";
 }

 
 public void displayReport() {
     System.out.println("Name       : " + name);
     System.out.println("Roll No.   : " + rollNumber);
     for (int i = 0; i < marks.length; i++) {
         System.out.println("Subject " + (i + 1) + ": " + marks[i]);
     }
     System.out.println("Total      : " + getTotal());
     System.out.printf("Average    : %.2f\n", getAverage());
     System.out.println("Highest    : " + getHighest());
     System.out.println("Lowest     : " + getLowest());
     System.out.println("Grade      : " + getGrade());
 }
}
