package com.service;

import com.interfaces.UserServices;
import com.model.User;

import java.util.function.Predicate;

public class UserServiceImpl implements UserServices {
    Predicate<String> nameValidator = name -> name.length() >= 3 && (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z');
    Predicate<String> validatePhoneNum = phoneNumber ->
            phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10;
    Predicate<String> emailValidator = emailId -> emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    Predicate<String> passwordValidator = validatePassword ->
            validatePassword.matches("^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$");

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

    @Override
    public boolean validateUser(User user) {
        if (user.getFirstName() != null && user.getLastName() != null && user.getEmailId() != null && user.getPassword() != null
                && user.getMobileNo() != null) {
            if (validateFirstName(user.getFirstName())) {
                if (validateLastName(user.getLastName())) {
                    if (validatePhoneNum(user.getMobileNo())) {
                        if (validateEmailID(user.getEmailId())) {
                            if (validatePassword(user.getPassword())) {
                                return true;
                            } else {
                                System.out.println("Password Validation failed");
                                return false;
                            }
                        } else {
                            System.out.println("Email Validation failed");
                            return false;
                        }
                    } else {
                        System.out.println("User Mobile Number Validation failed");
                        return false;
                    }
                } else {
                    System.out.println("User Last name Validation failed");
                    return false;
                }
            } else {
                System.out.println("User First name Validation failed");
                return false;
            }
        }
        System.out.println("Invalid user details entered");
        return false;
    }
}
