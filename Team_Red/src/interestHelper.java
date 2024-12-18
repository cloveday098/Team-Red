/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author litchar
 */
public class interestHelper {
    
    public static double findCont(double initial, double interest, double years) {
        double interestRate = interest / 100;
        double e = Math.E;
        double finalAmt = initial * Math.pow(e, (interestRate * years));
        return finalAmt;
        
    }
    
    public static double findIntWithTax(double initial, double tax, double interest, double compound, double years, double months, double inflation, double annualContr, double monthlyContr) {
        double compoundRate = (double) (interest / 100);
        double totalDurationInYrs = (double) (years + (months /12));
        double taxRate = tax / 100;
        double contributionsPerYr = annualContr + (monthlyContr * 12);
        
        if (compound == Math.E) {
            if (annualContr == 0 & monthlyContr == 0) {
                double amt = findCont(initial, interest, totalDurationInYrs);
                return amt;
            } else {
                double amt = findCont(initial, interest, totalDurationInYrs);
                double e = Math.E;
                double contsAfterInt =  totalDurationInYrs * contributionsPerYr * Math.pow(e, (compoundRate * totalDurationInYrs)); 
                return amt + contsAfterInt;
            }
        }
       
        double contributionsInt;
        if (contributionsPerYr != 0) {
            double contrGrowth = (1 + (compoundRate / compound));
            double contrGrowth2 = Math.pow(contrGrowth, (compound * (totalDurationInYrs - 1)));
            contributionsInt = contributionsPerYr + ((totalDurationInYrs - 1) * contributionsPerYr * contrGrowth2);
            
            System.out.print("Total Contribution Amount: " + contributionsInt + '\n');
        } else {
            contributionsInt = 0;
        }
        
        double totalInt = (initial) * Math.pow(1 + (compoundRate/compound), (totalDurationInYrs * compound));
        double interestYrPrior = (initial) * Math.pow((1 + (compoundRate/compound)),((totalDurationInYrs - 1) * compound));
        System.out.print("Interest for Year prior to LAST! = " + interestYrPrior + '\n');
        double interestForLastYr = totalInt - interestYrPrior;
        System.out.print("Interest for Last YR After Tax = " + interestForLastYr + '\n');
        double interestForFirstYr = compoundRate * initial;
        System.out.print("Interest for first After Tax = " + interestForFirstYr + '\n');
        
        totalInt += contributionsInt;        
        System.out.print("Ending Balance: " + totalInt +"\n");
        
        return totalInt;     
    }   
    
    public static double handleInflation(double finalAmt, double inflation, double years, double months) {
        double inflationRate = inflation / 100;
        double length = years + (months / 12);
        double denom = Math.pow((1 + inflationRate), length);
        double inflatedAmount = finalAmt / denom;
        return inflatedAmount;
    }
    
    public static double displayContributions(double interest, double compound, double years, double months, double annualContr, double monthlyContr) {
        double compoundRate = (double) (interest / 100);
        double totalDurationInYrs = (double) (years + (months /12));
        double contributionsPerYr = annualContr + (monthlyContr * 12);
        double contributionsInt;
        if (contributionsPerYr != 0) {
            double contrGrowth = (1 + (compoundRate / compound));
            double contrGrowth2 = Math.pow(contrGrowth, (compound * (totalDurationInYrs - 1)));
            contributionsInt = contributionsPerYr + ((totalDurationInYrs - 1) * contributionsPerYr * contrGrowth2);
            
            System.out.print("Total Contribution Amount: " + contributionsInt + '\n');
        } else {
            contributionsInt = 0;
        }
        return contributionsInt; 
    }
    
    public static double contributionsNoInt(double years, double months, double annualContributions, double monthlyContributions) {
        double totalDurationInYrs = (double) (years + (months/12));
        double contributionsPerYr = annualContributions + (monthlyContributions * 12);
        double contributions;
        if (contributionsPerYr != 0) {
            contributions = contributionsPerYr * totalDurationInYrs;
        } else {
            contributions = 0;
        }
        return contributions;
    }
    
}
