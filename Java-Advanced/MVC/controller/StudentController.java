package controller;

import dao.StudentDAO;
import model.StudentModel;
import view.StudentView;

public class StudentController
{
    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view)
    {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name)
    {
        model.setName(name);
    }

    public String getStudentName()
    {
        return model.getName();
    }

    public void setStudentAge(int age)
    {
        model.setAge(age);
    }

    public int getStudentAge()
    {
        return model.getAge();
    }

    public void updateView()
    {
        view.displayStudentDetails(model.getName(), model.getAge());
    }   
}