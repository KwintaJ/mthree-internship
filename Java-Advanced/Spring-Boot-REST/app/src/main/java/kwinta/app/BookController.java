package kwinta.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController
{
    @GetMapping("/books")
    public String controllerAPI()
    {
        return "first api";
    }
}