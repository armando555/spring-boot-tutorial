package com.amigoscode.models;

import java.util.Objects;

public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Customer(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Customer(){

    }
    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Integer getAge(){
        return this.age;
    }
    public String getEmail(){
        return this.email;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id,customer.id) && Objects.equals(name,customer.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, name, email, age);
    }

    @Override
    public String toString(){
        return "Customer{"+
                "id="+id+
                ",name="+name+
                ",email="+email+
                ",age="+age+
                '}';
    }
}
