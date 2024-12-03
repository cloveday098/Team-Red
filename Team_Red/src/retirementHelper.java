/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author litchar
 */
public class retirementHelper {
    
    public static double amtNeeded(double retirementAge, double lifeExpectancy, double income, double incomeNeededRatio, double otherIncome) {
         double percentNeeded = incomeNeededRatio / 100;
         double retirementDuration = lifeExpectancy - retirementAge;
         double amountNeeded = percentNeeded * income * retirementDuration - (otherIncome * retirementDuration * 12);
         return amountNeeded;
     } 
     
    public static double amtObtained(double age, double retirementAge, double income, double currentSavings, double futureSavings) {
        double yearsUntilRet = retirementAge - age; 
        double futureSavingsPercent = futureSavings / 100;    
        double amountObtained = currentSavings + (income * futureSavingsPercent * yearsUntilRet);        
        return amountObtained;
    }
    
    
}
