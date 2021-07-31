package com.interfaces;

import com.model.User;
public interface UserServices {
     boolean validateFirstName(String firstName);
     boolean validateLastName(String lastName);
     boolean validateEmailID(String emailId);
     boolean validatePhoneNum(String phoneNum);
     boolean validatePassword(String password);
     boolean validateUser(User user);
}
