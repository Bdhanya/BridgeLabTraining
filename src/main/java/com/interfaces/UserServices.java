package com.interfaces;

import java.util.function.Predicate;

public interface UserServices {
    public boolean validateFirstName(String firstName);
    public boolean validateLastName(String lastName);
    public boolean validateEmailID(String emailId);
    public boolean validatePhoneNum(String phoneNum);
}
