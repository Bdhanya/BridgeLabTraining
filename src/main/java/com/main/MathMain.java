package com.main;

import com.interfaces.MathInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MathMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Main method for Math");

        MathInterface add = (a, b) -> {
            return (a + b);
        };
        System.out.println("Addition " + add.calculate(5, 4));

        MathInterface sub = (a, b) -> {
            return (a - b);
        };
        System.out.println("Subbbbbb " + sub.calculate(5, 4));
        MathInterface mul = (int a, int b) -> {
            return (a * b);
        };
        System.out.println("MUL " + mul.calculate(5, 4));

        System.out.println("Cal static Method " + MathInterface.cal(mul, 20, 30));

        List<Integer> numberList = new ArrayList<>();
        numberList.add(20);
        numberList.add(10);
        numberList.add(5);
        numberList.add(25);
        numberList.add(30);

        System.out.println("Lenght of the List is " + numberList.stream().count());
        numberList.forEach(num -> System.out.println(num));
        numberList.stream().forEach(num -> {
            if (num > 10)
                System.out.println("Number is greater than 10 is " + num);
        });
        Function<Integer, Double> toDouble = Integer::doubleValue;
        numberList.stream().forEach(num -> {
            System.out.println("" + toDouble.apply(num));
        });

        Predicate<Integer>evenOrOdd=num-> num>0 && num%2==0;
        System.out.println(numberList.stream().filter(num->evenOrOdd.test(num)).count());

        numberList.stream().filter(num->evenOrOdd.test(num)).findAny().orElseThrow(Exception::new);
    }
}
