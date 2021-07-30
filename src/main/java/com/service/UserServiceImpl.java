package com.service;

import com.interfaces.UserServices;

import java.util.function.Predicate;

public class UserServiceImpl implements UserServices {
    Predicate nameValidator = name -> name.toString().length() >= 3 && (name.toString().charAt(0) >= 'A' && name.toString().charAt(0) <= 'Z');
    Predicate validatePhoneNum = phoneNumber ->
            phoneNumber.toString().matches("[0-9]+") && phoneNumber.toString().length() == 10;
    Predicate emailValidator = emailId -> emailId.toString().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    Predicate passwordValidator = validatePassword ->
            validatePassword.toString().matches("^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$");

    @Override
    public boolean validateFirstName(String firstName) {
        return nameValidator.test(firstName);
    }

    @Override
    public boolean validateLastName(String lastName) {
        return nameValidator.test(lastName);
    }

    @Override
    public boolean validateEmailID(String emailId) {
        return emailValidator.test(emailId);
    }

    @Override
    public boolean validatePhoneNum(String phoneNum) {
        String[] phoneN = phoneNum.split(" ");
        String num = phoneN[1];
        return validatePhoneNum.test(num);
    }

    @Override
    public boolean validatePassword(String password) {
        return passwordValidator.test(password);
    }
}
