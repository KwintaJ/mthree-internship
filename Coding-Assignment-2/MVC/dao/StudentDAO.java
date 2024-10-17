package dao;

import model.StudentModel;

import java.util.*;

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

    // mysql login
    private String sqlUser = "root";
    private String sqlPassword = "*****";
    private String hostPort = "localhost:3306";

    // mysql queries
    private String database = "Students";
    private String databaseTable = "Students.StudentInfo";

    // next student's id
    public int getNextID()
    {
        List<StudentModel> list = getAllStudents();
        if(list.size() == 0)
            return 1;

        int i = 1;
        for(; i <= list.size(); i++)
        {
            if(list.get(i - 1).getID() != i)
                return i;
        }
        return i;
    }

    @Override
    public List<StudentModel> getAllStudents()
    {
        List<StudentModel> students = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + databaseTable);

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

        students.sort(Comparator.comparing(StudentModel::getID));  
        return students;
    }

    @Override
    public StudentModel getStudentByID(int id)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + databaseTable + " where ID = " + id);

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
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            statement.executeUpdate("insert into " + databaseTable + "(ID, Name, Age) values ( " + s.getID() + ", \"" + s.getName() + "\", " + s.getAge() + ");");
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
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            statement.executeUpdate("update " + databaseTable + " set Name = \"" + s.getName() + "\", Age = " + s.getAge() + " where ID = " + id + ";");
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
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            statement.executeUpdate("delete from " + databaseTable + " where ID = " + s.getID() + ";");
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