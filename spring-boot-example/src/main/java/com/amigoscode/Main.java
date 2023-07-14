package com.amigoscode;

import java.util.List;

//import java.util.Objects;
import com.amigoscode.models.Customer;
import com.amigoscode.repositories.CustomerRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public static void main(String [] args){
        SpringApplication.run(Main.class, args);
        System.out.println("Hello");
    }
    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("Hello",55, List.of("Python","Java"), new Person("Armando"));
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    record Person (String name){}
    record GreetResponse(String greet, int prueba, List<String> languages, Person person){}

    
}
