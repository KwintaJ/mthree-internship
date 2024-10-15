package view;

import java.util.Scanner;

public class StudentView
{
    public void displayStudent(int id, String studentName, int studentAge)
    {
        System.out.println("ID: " + id + " Name: " + studentName + " Age: " + studentAge);
    }

    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("---- STUDENT APP ----");
        System.out.println("1. Print all students");
        System.out.println("2. Print student by id");
        System.out.println("3. Add new student");
        System.out.println("4. Delete student");
        System.out.println("5. Exit application");
        int choice = scan.nextInt();

        return choice;
    }

    public String newName()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new student's name:");
        String choice = scan.nextLine();

        return choice;
    }

    public int newAge()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new student's age:");
        int choice = scan.nextInt();

        return choice;
    }

    public int whichID()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student id:");
        int choice = scan.nextInt();

        return choice;
    }

    public void wrongChoice()
    {
        System.out.println("This is not an option!");
        System.out.println("");
    }
}