import controller.StudentController;
import dao.StudentDAO;
import model.StudentModel;
import view.StudentView;

public class StudentApp
{
    public static void main(String[] args)
    {
        // Create a student model
        StudentModel model = new StudentModel("Jan", 22);

        // Create a view to display student details
        StudentView view = new StudentView();

        // Create a controller to manipulate the model and update the view
        StudentController controller = new StudentController(model, view);

        // Initial display
        controller.updateView();

        // Update student details
        controller.setStudentName("Jan");
        controller.setStudentAge(23);

        // Display updated student details
        controller.updateView();
    }
}