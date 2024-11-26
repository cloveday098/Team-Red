
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author litchar
 */
public class refinanceHelper {
    
    public static double findAPR(double P, double MP, double newLoanTerm, double costs) {
        //cashOUt only change!!!!!!
        double S = costs + MP * newLoanTerm * 12;
        double APR;
        double val = (Math.log(S) - Math.log(P)) / newLoanTerm;
        APR = Math.pow(10, val) - 1;
        return APR;
        
    }
    
    public static double findMP(double loanAmt, double years, double interestRate) {
        double months = years * 12;
        double i = interestRate / 12;
        double compound = 1 + i;
        double compoundRate = Math.pow(compound, months);
        double num = i * compoundRate;
        double denom = compoundRate - 1;
        double monthlyPayment = loanAmt * (num / denom);
        return monthlyPayment;
    }
    
    public static double findRemainingBal(double originalLoan, double loanTerm, double timeLeft, double interestRate) {
        double timePassed = loanTerm - timeLeft;
        double i = interestRate / 12;
        double paymentsNeeded = loanTerm * 12; // n 
        double paymentsMade = timePassed * 12; // t
        
        double allPaymentsRate = Math.pow((1 + i), paymentsNeeded);
        double paymentsMadeRate = Math.pow((1 + i), paymentsMade);
        
        double num = allPaymentsRate - paymentsMadeRate;
        double denom = allPaymentsRate - 1;
        double currentAmt = originalLoan * (num / denom);
        
        return currentAmt;
    }

}
