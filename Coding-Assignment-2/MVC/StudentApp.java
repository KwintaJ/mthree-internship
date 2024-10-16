import view.StudentView;
import dao.StudentDAO;
import controller.StudentController;

// main - Java application for managing students' information
public class StudentApp
{
    public static void main(String[] args)
    {
        // create view to interact with the user
        StudentView view = new StudentView();

        // create dao to handle data operations
        StudentDAO dao = new StudentDAO();

        // create controller to handle app's logic
        StudentController controller = new StudentController(dao, view);

        // start the application
        controller.startRequest();
    }
}