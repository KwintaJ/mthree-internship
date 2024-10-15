import controller.StudentController;
import dao.StudentDAO;
import model.StudentModel;
import view.StudentView;

public class StudentApp
{
    public static void main(String[] args)
    {
        StudentView view = new StudentView();
        StudentDAO dao = new StudentDAO();
        StudentController controller = new StudentController(dao, view);

        controller.startRequest();
    }
}