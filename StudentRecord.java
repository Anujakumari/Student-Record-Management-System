package crud;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecord {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> studentList = new ArrayList<>();
	
	// Add
    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // Clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        float marks = sc.nextFloat();
        Student student = new Student(id, name, marks);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    // View
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Update
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getId() == id) {
                sc.nextLine();  // Clear buffer
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                System.out.print("Enter new Marks: ");
                float marks = sc.nextFloat();
                student.setName(name);
                student.setMarks(marks);
                System.out.println("Record updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Delete
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        
        boolean removed = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Record deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

	public static void main(String[] args) {
		int choice;
        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1: 
                	addStudent(); 
                	break;
                case 2: 
                	viewStudents(); 
                	break;
                case 3: 
                	updateStudent(); 
                	break;
                case 4: 
                	deleteStudent(); 
                	break;
                case 5: 
                	System.out.println("Exiting..."); 
                	break;
                default: 
                	System.out.println("Invalid choice. Try again.");
            }
            
        } 
        while (choice != 5);
        

	}
	

}
