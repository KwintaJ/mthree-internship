package controller;

import dao.StudentDAO;
import model.StudentModel;
import view.StudentView;

import java.util.List;

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
                    for(StudentModel model : dao.getAllStudents())
                        view.displayStudent(model.getID(), model.getName(), model.getAge());
                    break;

                case 2:
                    StudentModel st1 = dao.getStudentByID(view.whichID());
                    if(!checkResult(st1))
                    {
                        view.wrongChoice();
                        break;
                    }

                    view.displayStudent(st1.getID(), st1.getName(), st1.getAge());
                    break;

                case 3:
                    int nID = dao.getNextID();
                    String nName = view.newName();
                    int nAge = view.newAge();
                    if(!checkInput(nName, nAge))
                    {
                        view.wrongChoice();
                        break;
                    }

                    dao.newStudent(new StudentModel(nID, nName, nAge));
                    break;

                case 4:
                    int id = view.whichID();
                    StudentModel st2 = dao.getStudentByID(id);
                    if(!checkResult(st2))
                    {
                        view.wrongChoice();
                        break;
                    }

                    String uName = view.newName();
                    int uAge = view.newAge();
                    if(!checkInput(uName, uAge))
                    {
                        view.wrongChoice();
                        break;
                    }

                    dao.updateStudent(id, new StudentModel(0, uName, uAge));
                    break;

                case 5:
                    StudentModel st3 = dao.getStudentByID(view.whichID());
                    if(!checkResult(st3))
                    {
                        view.wrongChoice();
                        break;
                    }

                    dao.deleteStudent(st3);
                    break;

                case 6:
                    return;

                default:
                    view.wrongChoice();
                }
            }
            catch(RuntimeException e)
            {
                view.wrongChoice();
            }
        }
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