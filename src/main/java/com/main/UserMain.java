package com.main;
import java.util.function.Predicate;

public class UserMain {
    public static void main(String[] args) {
        System.out.println("User Class !!!");

        Predicate firstNameCheck = name -> name.toString().length() >= 3 && (name.toString().charAt(0) >= 'A' && name.toString().charAt(0) <= 'Z');
        String test = "Arr";
        System.out.println("Test the values" + firstNameCheck.test(test));
        String phoneNum = "91 9901762345";
        String[] phoneN = phoneNum.split(" ");
        System.out.println(phoneN.length);

    }

}
