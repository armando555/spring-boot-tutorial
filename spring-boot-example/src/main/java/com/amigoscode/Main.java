package com.amigoscode;

import java.util.List;

//import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String [] args){
        SpringApplication.run(Main.class, args);
        System.out.println("Hello");
    }
    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("Hello",55, List.of("Python","Java"), new Person("Armando"));
    }
    record Person (String name){}
    record GreetResponse(String greet, int prueba, List<String> languages, Person person){}
    //class GreetResponse{
    //    private final String greet;
    //    private final int prueba;
    //    public GreetResponse(String greet, int prueba) {
    //        this.greet = greet;
    //        this.prueba = prueba;
    //    }
    //    public String getGreet() {return greet;}
    //    public int getPrueba() {return prueba;}
    //    public String toString(){
    //        return "GreetResponse{"+
    //                "greet='"+greet+'\''+
    //                "}";
    //    }
    //    @Override
    //    public boolean equals(Object o){
    //        if (this == o) return true;
    //        if(o == null || getClass() != o.getClass()) return false;
    //        GreetResponse that = (GreetResponse) o;
    //        return Objects.equals(greet, that.greet);
    //    }
    //    @Override
    //    public int hashCode(){
    //        return Objects.hash(greet);
    //    }
    //}
    
}
