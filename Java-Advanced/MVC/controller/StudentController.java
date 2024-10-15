package controller;

import dao.StudentDAO;
import model.StudentModel;
import view.StudentView;

import java.util.List;

public class StudentController
{
    private StudentDAO dao;
    private StudentView view;

    public StudentController(StudentDAO dao, StudentView view)
    {
        this.dao = dao;
        this.view = view;
    }

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
                    int nID = dao.getSize() + 1;
                    String nName = view.newName();
                    int nAge = view.newAge();
                    dao.newStudent(new StudentModel(nID, nName, nAge));
                    break;
                case 4:
                    StudentModel st2 = dao.getStudentByID(view.whichID());
                    dao.deleteStudent(st2);
                    break;
                case 5:
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