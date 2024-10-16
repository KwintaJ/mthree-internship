package dao;

import model.StudentModel;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// implementation of the DAO interface
public class StudentDAO implements StudentDAOInterface
{
    // mysql database connection
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    // next student's id
    public int getNextID()
    {
        List<StudentModel> list = getAllStudents();
        if(list.size() == 0)
            return 1;
        return list.get(list.size() - 1).getID() + 1;
    }

    @Override
    public List<StudentModel> getAllStudents()
    {
        List<StudentModel> students = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?user=root&password=*****");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from Students.StudentInfo");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while(resultSet.next())
            {
                StudentModel model = new StudentModel(Integer.valueOf(resultSet.getString(1)), resultSet.getString(2), Integer.valueOf(resultSet.getString(3)));
                students.add(model);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                connect.close();
            }
            catch(Exception e) {}
        }

        return students;
    }

    @Override
    public StudentModel getStudentByID(int id)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?user=root&password=*****");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from Students.StudentInfo where ID = " + id);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while(resultSet.next())
            {
                StudentModel model = new StudentModel(Integer.valueOf(resultSet.getString(1)), resultSet.getString(2), Integer.valueOf(resultSet.getString(3)));
                return model;
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                connect.close();
            }
            catch(Exception e) {}
        }

        // returns -1 if a student with given id does not exist
        return new StudentModel(-1, "", 0);
    }
    
    @Override
    public void newStudent(StudentModel s)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?user=root&password=*****");

            statement = connect.createStatement();
            statement.executeUpdate("insert into Students.StudentInfo(ID, Name, Age) values ( " + s.getID() + ", \"" + s.getName() + "\", " + s.getAge() + ");");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                connect.close();
            }
            catch(Exception e) {}
        }
    }  

    @Override
    public void updateStudent(int id, StudentModel s)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?user=root&password=*****");

            statement = connect.createStatement();
            statement.executeUpdate("update StudentInfo set Name = \"" + s.getName() + "\", Age = " + s.getAge() + " where ID = " + id + ";");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                connect.close();
            }
            catch(Exception e) {}
        }
    }  
    
    @Override
    public void deleteStudent(StudentModel s)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students?user=root&password=*****");

            statement = connect.createStatement();
            statement.executeUpdate("delete from Students.StudentInfo where ID = " + s.getID() + ";");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                connect.close();
            }
            catch(Exception e) {}
        }
    }
}