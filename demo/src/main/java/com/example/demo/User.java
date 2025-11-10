package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Entity //database entity
@Table(name = "users") //table name in the database
public class User 
{   
    @Id //Marks this as Primary key
    @GeneratedValue //tells the database to generate a unique id for each user
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;
    
    @Email
    private String email;

    //getters and setters
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
