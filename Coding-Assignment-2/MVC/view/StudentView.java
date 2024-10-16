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

    public void clearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        printMenu(); 
    }  

    // print menu
    private void printMenu()
    {
        System.out.println("---- STUDENT APP ----");
        System.out.println("1. Print all students");
        System.out.println("2. Print student by id");
        System.out.println("3. Add new student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Exit application");
        System.out.println("");
    }

    // allow user to select one option from menu
    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.print("Select action: ");
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
    // effect of choosing option that doesn't exist
    public void wrongChoice()
    {
        clearScreen();
        System.out.println("This is not a choice!");
    }

    // error message
    // effect of WrongIdException:
    // student with given ID not existing
    public void wrongID()
    {
        clearScreen();
        System.out.println("Student with given ID does not exist!");
    }

    // error message
    // effect of FormattingException:
    // wrong Name/Age formatting
    // or effect of InputMismatchException
    public void wrongFormat()
    {
        clearScreen();
        System.out.println("Input not valid!");
    }
}