package com.company;

import java.util.Scanner;
import java.util.HashMap;


class Student {
    Integer studentId;
    String studentName;
    int studentClass;
    String studentSection;

    Student(Integer studentId, String studentName, int studentClass, String studentSection) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentSection = studentSection;

    }

    public void display() {
        System.out.println(this.studentId + " " + this.studentName + " " + this.studentClass + " " + this.studentSection);
    }

}


public class StudentDatabase {

    public static Student newStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the Student Id");
        Integer studentId = scan.nextInt();
        System.out.println("enter the student name");
        String studentName = scan.next();
        System.out.println("enter the student class");
        int studentClass = scan.nextInt();
        System.out.println("enter the student section");
        String studentSection = scan.next();
        Student student = new Student(studentId, studentName, studentClass, studentSection);
        return student;
    }

    public static void addStudentData(Student student, HashMap studentDatabase) {
        studentDatabase.put(student.studentId, student);
    }

    public static void updateStudentData(Student student, HashMap studentDatabase) {
        Scanner scan = new Scanner(System.in);
        System.out.println("what you want to change among studentName,studentClass," +
                "studentSection or else type exit ");
        String choice = scan.next();
        if (choice.equals("studentClass")) {
            int newClass = scan.nextInt();
            student.studentClass = newClass;
        } else {
            String changedData = scan.next();
            if (choice.equals("studentName")) {
                student.studentName = changedData;
            } else if (choice.equals("studentSection")) {
                student.studentSection = changedData;
            }
        }
        studentDatabase.put(student.studentId, student);
    }

    public static void readStudentData(int Id, HashMap studentDatabase) {
        if (Id == 0) {
            studentDatabase.forEach((key, value) -> ((Student) value).display());
        } else {
            Student student = (Student) studentDatabase.get(Id);
            student.display();
        }

    }

    public static void deleteStudentData(int id, HashMap studentDataBase) {
        studentDataBase.remove(id);
    }


    public static void main(String[] args) {
        HashMap<Integer, Student> studentDatabase = new HashMap<Integer, Student>();
        Student student1 = new Student(1, "a", 2, "a");
        Student student2 = new Student(2, "a", 2, "a");
        studentDatabase.put(student1.studentId, student1);
        studentDatabase.put(student2.studentId, student2);


        boolean loopFalg = true;
        while (loopFalg) {
            System.out.println("Type 1 to add new student data");
            System.out.println("Type 2 to update student data");
            System.out.println("Type 3 to read student data");
            System.out.println("Type 4 to delete student data");
            System.out.println("Type 5 to exit");

            Scanner scan = new Scanner(System.in);
            int choiceMade = scan.nextInt();
            if (choiceMade == 1) {
                Student student = newStudent();
                addStudentData(student, studentDatabase);
            }
            else if (choiceMade == 2) {
                System.out.println(studentDatabase);
                System.out.println("enter the studentId you want to update");
                int Id = scan.nextInt();
                readStudentData(Id, studentDatabase);
                updateStudentData(studentDatabase.get(Id), studentDatabase);
                readStudentData(Id, studentDatabase);
            }
            else if (choiceMade == 3) {
                System.out.println("Enter Id of the student you want to view else enter 0 to view whole database");
                int Id = scan.nextInt();
                readStudentData(Id, studentDatabase);

            }
            else if (choiceMade == 4) {
                System.out.println("Enter Id of the student you want to delete");
                int Id = scan.nextInt();
                deleteStudentData(Id, studentDatabase);
            }
            else {
                loopFalg = false;
            }
        }
    }
}
