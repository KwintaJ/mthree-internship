package dao;

import model.StudentModel;
import java.util.List;

// data access object interface
public interface StudentDAOInterface
{
    // returns all students in a list
    List<StudentModel> getAllStudents();

    // returns one student of given id
    StudentModel getStudentByID(int id);

    // add a new student to a database
    void newStudent(StudentModel s);

    // update information about a student
    void updateStudent(int id, StudentModel s);

    // delete student from the database
    void deleteStudent(StudentModel s);
}