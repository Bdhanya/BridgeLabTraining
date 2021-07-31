package com.main;

import com.interfaces.UserServices;
import com.model.User;
import com.service.UserServiceImpl;

public class UserMain {
    public static void main(String[] args) {
        System.out.println("User Class !!!");
        User user = new User("Bharath", "Dhanya", "bharathsdhanya@gmail.com",
                "91 9965433243", "3Rq3p6543E@");
        UserServices userServices=new UserServiceImpl();
        System.out.println("User Validation result:::: "+ userServices.validateUser(user));
    }

}
