package dao;

import model.StudentModel;
import java.util.List;

public interface StudentDAOInterface
{
    List<StudentModel> getAllStudents();
    StudentModel getStudentByID(int id);
    void newStudent(StudentModel s);
    void deleteStudent(StudentModel s);
}