package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;

@SpringBootApplication
public class SpringBootJpaProjectApplication
{
    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(SpringBootJpaProjectApplication.class, args);
        UserRepository userRepository= context.getBean(UserRepository.class);
        
        User u1 = new User();
        u1.setName("Abir");
        u1.setCity("London");
        u1.setStatus("Active");
        
        User u2 = new User();
        u2.setName("Jan");
        u2.setCity("Cracow");
        u2.setStatus("Active");
        
        User u3 = new User();
        u3.setName("Jose");
        u3.setCity("Madrid");
        u3.setStatus("Away");

        // ---- save to repository
        // userRepository.save(u1);

        // ---- save from list
        // List<User> userList = List.of(u2, u3);
        // Iterable<User> iterableUsers = userRepository.saveAll(userList);
           
        // ---- find in repository
        Optional<User> resultUser = userRepository.findById(2);
        User userFound = resultUser.get();
        System.out.println(userFound);
       
        // ---- update found record
        // userFound.setStatus("Busy");
        // userRepository.save(userFound);      
        
        // ---- delete a record from repository
        // userRepository.deleteById(1);
    }
}
