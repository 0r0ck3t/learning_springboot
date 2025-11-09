package com.example.demo;

//Plain Old Java Object (POJO)
public class Greeting {
    private  String message;

    //Constructor
    public Greeting()
    {
    }
    public Greeting(String message) 
    {
        this.message = message;
    }
    //Setter
    public void setMessage(String message) 
    {
        this.message = message;
    }
    //Getter
    public String getaMessage() {
        return message;
    }
}
/*
Here is the "magic" of how it works:

Your HelloController (a @RestController) returns the Greeting object.

Spring's Jackson library intercepts this object before it's sent.

Jackson scans the Greeting.java class for all public "getter" methods.

It finds your method: public String getMessage().

It automatically converts that method name into a JSON key (it removes "get" and lowercases the first letter: getMessage ➔ message).

It then calls the method (getMessage()) to get its value ("Hello, Teo!").

It builds the final JSON object ({"key":"value"}) and sends that to the browser.
ex:
 public String getaMessage() {
        return message;
    }
        output: {"aMessage":"Hello, david!"}
 */