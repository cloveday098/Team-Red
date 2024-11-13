/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author litchar
 */
public class interestCalc {
    public static double findCont(double initial, double interest, int years) {
        double interestRate = interest / 100;
        double e = Math.E;
        double finalAmt = initial * Math.pow(e, (interestRate * years));
        
        return finalAmt;
    }
    
    public static double findIntWithTax(double initial, double tax, double interest, double compound, int years, int months, double inflation, double annualContr, double monthlyContr) {
        double compoundRate = (double) (interest / 100);
        
        if (compound == Math.E) {
            double amt = findCont(initial, interest, years);
            return amt;
        }
        
        double taxRate = tax / 100;
        double contributionsPerYr = annualContr + (monthlyContr * 12);
        int totalDurationInYrs = years + (months /12);
        double totalContributions = contributionsPerYr * totalDurationInYrs;
        
        // find interest on totalContributions and add to final val?????
        double contributionsInt;
        if (contributionsPerYr != 0) {
            contributionsInt = (totalContributions) * Math.pow((1 + (compoundRate/compound)), ((totalDurationInYrs - 1) * compound));
            //System.out.print("interest on total contributions: " + contributionsInt + '\n');
        } else {
            contributionsInt = 0;
        }
        
        double totalInt = (initial) * Math.pow(1 + (compoundRate/compound), (totalDurationInYrs * compound));
        //double totalInt = (initial) * Math.pow(1 + (compoundRate/compound), (totalDurationInYrs * compound));
        double interestYrPrior = (initial) * Math.pow((1 + (compoundRate/compound)),((totalDurationInYrs - 1) * compound));
        //System.out.print("Interest for Year prior to LAST! = " + interestYrPrior + '\n');
        double interestForLastYr = totalInt - interestYrPrior;
        //System.out.print("Interest for Last YR After Tax = " + interestForLastYr + '\n');
        
        double interestForFirstYr = compoundRate * initial;
        //System.out.print("Interest for first After Tax = " + interestForFirstYr + '\n');
        double totalTaxBegin = taxRate * interestForFirstYr;
        double totalTaxEnd = taxRate * interestForLastYr;
        //System.out.print("Interest rate for Last year= " + totalTaxEnd + '\n');
 
        
        double diff = totalTaxEnd - totalTaxBegin;
        double changeInTax = diff / totalDurationInYrs; 
        tax = totalTaxBegin;
        
        totalInt += contributionsInt;
        
        //System.out.print("Ending Balance: " + totalInt +"\n");
        
       //if (inflation != 0) {
            //handleInflation(totalInt, inflation);  
        // }
        return totalInt;     
    }    

}
