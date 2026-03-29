package com.java.Experiment2;

import java.util.*;

public class Student_record {

    Map<Integer, Student> studentMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        studentMap.put(id, new Student(id, name, marks, course));
        System.out.println("Student added.");
    }

    void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        Student s = studentMap.get(id);

        if (s != null)
            System.out.println(s);
        else
            System.out.println("Student not found.");
    }

    void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.print("Enter new Name: ");
            s.name = sc.nextLine();

            System.out.print("Enter new Marks: ");
            s.marks = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter new Course: ");
            s.course = sc.nextLine();

            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    void displayAll() {
        if (studentMap.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student s : studentMap.values()) {
                System.out.println(s);
            }
        }
    }

    void sortByMarks() {
        if (studentMap.isEmpty()) {
            System.out.println("No records to sort.");
            return;
        }

        List<Student> list = new ArrayList<>(studentMap.values());
        list.sort((a, b) -> Double.compare(b.marks, a.marks));

        System.out.println("--- Students Sorted by Marks ---");

        for (Student s : list) {
            System.out.println(s);
        }
    }

    void displayStudents() {
        while (true) {

            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    searchStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    displayAll();
                    break;

                case 5:
                    sortByMarks();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        new Student_record().displayStudents();
    }
}