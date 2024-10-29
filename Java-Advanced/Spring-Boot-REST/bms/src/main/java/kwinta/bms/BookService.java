package kwinta.bms;

import java.util.*;
import java.util.stream.Collectors;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class BookService 
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
    private String database = "BookManagementSystem";
    private String databaseTable = "BookManagementSystem.BooksData";

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<>();
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
                Book entity = new Book(Integer.valueOf(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3));
                books.add(entity);
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

        books.sort(Comparator.comparing(Book::getId));  
        return books;
    }

    public Book getBookByID(int id)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + databaseTable + " where id = " + id);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while(resultSet.next())
            {
                Book model = new Book(Integer.valueOf(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3));
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
        return new Book(-1, "", "");
    }
    
    public void deleteBookByID(int id)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            statement.executeUpdate("delete from " + databaseTable + " where id = " + id + ";");
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

    public Book addBook(Book bookObject) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            statement.executeUpdate("insert into " + databaseTable + " values ( " + bookObject.getId() + ", \"" + bookObject.getTitle() + "\", \"" + bookObject.getAuthor() + "\");");
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
        return bookObject;
    }

    public void updateBookByID(Book updatedBookObject, int id)
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + hostPort + "/" + database + "?user=" + sqlUser + "&password=" + sqlPassword);

            statement = connect.createStatement();
            statement.executeUpdate("update " + databaseTable + " set title = \"" + updatedBookObject.getTitle() + "\", Author = \"" + updatedBookObject.getAuthor() + "\" where id = " + id + ";");
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