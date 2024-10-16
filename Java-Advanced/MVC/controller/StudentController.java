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
                    view.displayStudent(st1.getID(), st1.getName(), st1.getAge());
                    break;
                case 3:
                    int nID = dao.getNextID();
                    String nName = view.newName();
                    int nAge = view.newAge();
                    dao.newStudent(new StudentModel(nID, nName, nAge));
                    break;
                case 4:
                    int id = view.whichID();
                    String uName = view.newName();
                    int uAge = view.newAge();
                    dao.updateStudent(id, new StudentModel(0, uName, uAge));
                    break;
                case 5:
                    StudentModel st2 = dao.getStudentByID(view.whichID());
                    dao.deleteStudent(st2);
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
}