package com.service;

import com.interfaces.UserServices;

import java.util.function.Predicate;

public class UserServiceImpl implements UserServices {
    Predicate nameValidator = name -> name.toString().length() >= 3 && (name.toString().charAt(0) >= 'A' && name.toString().charAt(0) <= 'Z');

    @Override
    public boolean validateFirstName(String firstName) {

        // boolean valid = firstName.length() >= 3 && (firstName.charAt(0) >= 'A' && firstName.charAt(0) < 'Z');
        return nameValidator.test(firstName);
    }

    @Override
    public boolean validateLastName(String lastName) {
        return nameValidator.test(lastName);
    }

    @Override
    public boolean validateEmailID(String emailId) {
        return false;
    }

    @Override
    public boolean validatePhoneNum(String phoneNum) {
        String[] phoneN=phoneNum.split(" ");
       // System.out.println(phoneN.length);
        return false;
    }
}
