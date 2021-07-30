package com.interfaces;
@FunctionalInterface
public interface MathInterface {
 public int calculate(int a,int b);
 public static int cal(MathInterface a, int b,int c)
 {
     System.out.println("Here ");
     a.calculate(b,c);
     return a.calculate(b,c);
 }

}
