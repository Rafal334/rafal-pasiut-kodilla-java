package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args){
        String testUserName = "theForumUser";
        int a=10, b=5;

        SimpleUser simpleUser = new SimpleUser(testUserName);
        String result = simpleUser.getUsername();

        if(testUserName.equals(result)){
            System.out.println("test OK");
        }else{
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        if(calculator.add(a,b)==(a+b)){
            System.out.println("test OK");
        }else{
            System.out.println("Error!");
        }

        if(calculator.subtract(a,b)==(a-b)){
            System.out.println("test OK");
        }else{
            System.out.println("Error!");
        }
    }
}
