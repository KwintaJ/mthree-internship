package dao;

import model.StudentModel;
import java.util.List;
import java.util.ArrayList;

public class StudentDAO implements StudentDAOInterface
{
    private List<StudentModel> students;
    private int dataSize;

    public StudentDAO()
    {
        students = new ArrayList<>();
        dataSize = 0;
    }

    public int getSize()
    {
        return dataSize;
    }

    @Override
    public List<StudentModel> getAllStudents()
    {
        return students;
    }

    @Override
    public StudentModel getStudentByID(int id)
    {
        return students.get(id - 1);
    }
    
    @Override
    public void newStudent(StudentModel s)
    {
        dataSize++;
        students.add(s);
    }  
    
    @Override
    public void deleteStudent(StudentModel s)
    {
        dataSize--;
        students.remove(s);
    }
}