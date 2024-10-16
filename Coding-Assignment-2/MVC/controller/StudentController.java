package controller;

import dao.StudentDAO;
import model.StudentModel;
import view.StudentView;

import java.util.List;
import java.util.InputMismatchException;

// model - all the internal logic
public class StudentController
{
    // data access
    private StudentDAO dao;

    // i/o
    private StudentView view;

    public StudentController(StudentDAO dao, StudentView view)
    {
        this.dao = dao;
        this.view = view;
    }

    // looped logic - each time print menu 
    // perform selected option
    public void startRequest()
    {
        while(true)
        {
            try
            {
                int choice = view.menu();

                switch(choice)
                {
                case 1:
                    printAllLogic();
                    break;

                case 2:
                    printOneLogic();
                    break;

                case 3:
                    newStudentLogic();
                    break;

                case 4:
                    updateStudentLogic();
                    break;

                case 5:
                    deleteStudentLogic();
                    break;

                case 6:
                    return;

                default:
                    // calls wrongChoice() if choice is not in range [1, 6]
                    view.wrongChoice();
                }
            }
            // calls wrongChoice() if choice is not an int
            catch(InputMismatchException e)
            {
                view.wrongChoice();
            }
        }
    }

    // get all students in the database as a list and print every one 
    private void printAllLogic()
    {
        for(StudentModel model : dao.getAllStudents())
            view.displayStudent(model.getID(), model.getName(), model.getAge());        
    }

    // get student with a specific id as a model object and print it
    // calls wrongChoice() if student of that id does not exist in database
    private void printOneLogic()
    {
        StudentModel st1 = dao.getStudentByID(view.whichID());
        if(!checkResult(st1))
        {
            view.wrongChoice();
            return;
        }

        view.displayStudent(st1.getID(), st1.getName(), st1.getAge());           
    }

    // insert new model object into a database
    // calls wrongChoice() if newName or newAge are of wrong format
    private void newStudentLogic()
    {
        int nID = dao.getNextID();
        String nName = view.newName();
        int nAge = view.newAge();
        if(!checkInput(nName, nAge))
        {
            view.wrongChoice();
            return;
        }

        dao.newStudent(new StudentModel(nID, nName, nAge));
                    
    }

    // execute update query on a student with a specific id 
    // calls wrongChoice() if student of that id does not exist in database
    // calls wrongChoice() if newName or newAge are of wrong format
    private void updateStudentLogic()
    {
        int id = view.whichID();
        StudentModel st2 = dao.getStudentByID(id);
        if(!checkResult(st2))
        {
            view.wrongChoice();
            return;
        }

        String uName = view.newName();
        int uAge = view.newAge();
        if(!checkInput(uName, uAge))
        {
            view.wrongChoice();
            return;
        }

        dao.updateStudent(id, new StudentModel(0, uName, uAge));
                    
    }

    // delete a student with a specific id 
    // calls wrongChoice() if student of that id does not exist in database
    private void deleteStudentLogic()
    {
        StudentModel st3 = dao.getStudentByID(view.whichID());
        if(!checkResult(st3))
        {
            view.wrongChoice();
            return;
        }

        dao.deleteStudent(st3);                    
    }

    // checking if input is correct
    private boolean checkInput(String n, int a)
    {
        if(a <= 0)
            return false;

        if(n.charAt(0) == '"' || n.charAt(0) == ' ' )
            return false;

        return true;
    }

    // checking if searched result exist and is correct
    private boolean checkResult(StudentModel s)
    {
        if(s.getID() <= 0)
            return false;

        return true;
    }
}