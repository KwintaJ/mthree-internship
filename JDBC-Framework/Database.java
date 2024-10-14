import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void printUsers()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/People?user=root&password=********");

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from People.Users");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while(resultSet.next())
            {
                for(int i = 1; i <= columnsNumber; i++)
                {
                    if(i > 1)
                        System.out.print(", ");

                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
            System.out.println("");
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

    public void newUser(int id, String name)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/People?user=root&password=********");

            statement = connect.createStatement();
            statement.executeUpdate("insert into People.Users(ID, Name) values ( " + id + ", \"" + name + "\");");
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

    public void deleteUser(int id)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/People?user=root&password=********");

            statement = connect.createStatement();
            statement.executeUpdate("delete from People.Users where ID = " + id + ";");
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

    public static void main(String[] args)
    {
        Database db = new Database();

        // db.deleteUser(6);

        db.newUser(6, "Tracey");

        db.printUsers();
    }
}