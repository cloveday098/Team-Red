/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loved
 */

// validate funct
// monthlyPayment funct
// Unit tests for both
public class Helper {
    public static int add(int a, int b) {
        return a+b;
    }
    public static boolean isPos(double n) {
        return n>0;
    }

    public static double monthlyPayment(double amt, double annInterestRate, int yrs) {
        
        if (!isPos(yrs)) {
            System.out.println("Nice try. We'll look at 1 year instead.");
            yrs = 1;
        }
        if (!isPos(annInterestRate)) {
            System.out.println("Nice try.");
            annInterestRate = 1;
        }
        // There shouldn't be a need to validate amt > 0
        
        double exp = Math.pow((1+annInterestRate/12), (yrs * 12));
        System.out.println((amt * annInterestRate/1200) / (1 - 1 / (exp)));
        return (amt * annInterestRate/1200) / (1 - 1 / (exp));
        
    }
}
