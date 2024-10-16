package view;

import java.util.Scanner;

// view - interaction with user
public class StudentView
{
    // print model information
    public void displayStudent(int id, String studentName, int studentAge)
    {
        System.out.println("ID: " + id + ", Name: " + studentName + ", Age: " + studentAge);
    }

    // print menu and allow user to select one option
    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("---- STUDENT APP ----");
        System.out.println("1. Print all students");
        System.out.println("2. Print student by id");
        System.out.println("3. Add new student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Exit application");
        int choice = scan.nextInt();

        return choice;
    }

    // take new name as an input from the user
    public String newName()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new student's name:");
        String choice = scan.nextLine();

        return choice;
    }

    // take new age as an input from the user
    public int newAge()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new student's age:");
        int choice = scan.nextInt();

        return choice;
    }

    // select student's id
    public int whichID()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student id:");
        int choice = scan.nextInt();

        return choice;
    }

    // error message
    // can be an effect of InputMismatchException
    // student with given ID not existing
    // or wrong Name/Age formatting
    public void wrongChoice()
    {
        System.out.println("Input not valid!");
        System.out.println("");
    }
}