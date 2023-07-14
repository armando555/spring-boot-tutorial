package com.amigoscode;

import java.util.List;
import java.util.Optional;

//import java.util.Objects;
import com.amigoscode.models.Customer;
import com.amigoscode.repositories.CustomerRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    //-----------------------------------------------CUSTOMER OPERATIONS
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    record NewCustomerRequest(String name, String email, Integer age){}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest newCustomerRequest){
        Customer customer = new Customer();
        customer.setEmail(newCustomerRequest.email);
        customer.setName(newCustomerRequest.name);
        customer.setAge(newCustomerRequest.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public void updateCustomer(@RequestBody NewCustomerRequest updateCustomerRequest, @PathVariable("id") Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        Customer customer2 = customer.get();
        if (updateCustomerRequest.age != null ) customer2.setAge(updateCustomerRequest.age);
        if (updateCustomerRequest.email != null ) customer2.setEmail(updateCustomerRequest.email);
        if (updateCustomerRequest.name != null ) customer2.setName(updateCustomerRequest.name);
        customerRepository.saveAndFlush(customer2);
    }
   //---------------------------------------------------------------------------------------------













    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("Hello",55, List.of("Python","Java"), new Person("Armando"));
    }
    record Person (String name){}
    record GreetResponse(String greet, int prueba, List<String> languages, Person person){}

    
}
