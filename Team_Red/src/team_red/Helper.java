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
    public static boolean isPos(double n) {
        return n>0;
    }

    public static double monthlyPayment(double amt, double annInterestRate, int yrs) {
        String msg = "";
        if (!isPos(yrs)) {
            msg += "Years must be > 0!\n";
        }
        if (!isPos(annInterestRate)) {
            System.out.println("Nice try.");
            msg += "Annual interest rate must be > 0!\n";
        }
        
        if (amt > 999999999 || annInterestRate > 999999999) {
            msg += "Amount too large!\n";
        }
        
        if (!msg.equals("")) {
            System.out.println(msg);
            return -1;
        }
        
        // Check for values more precise than pennies ( < 0.01)

        // There shouldn't be a need to validate amt > 0
        double exp = Math.pow((1+annInterestRate/1200), (yrs * 12));
        System.out.println((amt * annInterestRate/1200) / (1 - 1 / (exp)));
        return (amt * annInterestRate/1200) / (1 - 1 / (exp));
    }
}
