package com.codealpha.grade;

public class Student {
    private String name;
    private int rollNumber;
    private int[] marks;
    
    private static final String[] subjects = { "Math   ", "English", "Marathi", "Science", "History" };

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks.clone(); // Defensive copy
    }

    public int getTotal() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }

    public double getAverage() {
        return marks.length > 0 ? (double) getTotal() / marks.length : 0;
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
        int avgBucket = (int) getAverage() / 10;
        switch (avgBucket) {
            case 10:
            case 9:
            case 8:
                return "A";
            case 7:
            case 6:
                return "B";
            case 5:
            case 4:
                return "C";
            default:
                return "F";
        }
    }

    public void displayReport() {
        System.out.println("Name       : " + name);
        System.out.println("Roll No.   : " + rollNumber);
        System.out.println("Subjects    Marks");
        for (int i = 0; i < marks.length; i++) {
            String subjectName = (i < subjects.length) ? subjects[i] : "Subject " + (i + 1);
            System.out.println(subjectName + "    : " + marks[i]);
        }

        System.out.println("Total      : " + getTotal());
        System.out.printf ("Percetage  : %.2f%n", getAverage());
        System.out.println("Highest    : " + getHighest());
        System.out.println("Lowest     : " + getLowest());
        System.out.println("Grade      : " + getGrade());

    }

    public double getAverageForSummary() {
        return getAverage(); // for consistency in tracker
    }
}
