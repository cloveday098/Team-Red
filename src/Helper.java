/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 5678m
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Helper {
    public static boolean isAutoValidNumber(String test){
        if (test.isEmpty()) {
            return false;
        }

        char firstChar = test.charAt(0);
        if (!Character.isDigit(firstChar)) {
            return false;
        }

        for (int i = 1; i < test.length(); i++) {
            if (!Character.isDigit(test.charAt(i))) {
                return false;
            }
        }

        return true;
    }
    
    public static void validateSingleInput(JTextField textField, KeyEvent evt) {
        if (evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_DELETE) {
            String currentText = textField.getText() + evt.getKeyChar();

            if (!isAutoValidNumber(currentText)) {
                evt.consume();
            }
        }
    }
    
    public static void validateDoubleInput(JTextField textField, KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        } else if (c == '.' && textField.getText().contains(".")) {
            evt.consume();
        }
        
        String currentText = textField.getText();
        if (currentText.contains(".")) {
            String[] nums = currentText.split("\\.");
            if (nums.length > 1 && nums[1].length() >= 2) {
                if (Character.isDigit(c)) {
                    evt.consume();
                }
            }
        }
    }
    
    public static boolean isAllZeroInputs(double autoPrice, int loanTerm, double interestRate, double cashIncentives, double downPayment, double tradeInValue, double amtOwedTradeIn, double salesTax, double otherFees) {
        if (autoPrice == 0 && loanTerm == 0 && interestRate == 0 && cashIncentives == 0 && downPayment == 0 && tradeInValue == 0 && amtOwedTradeIn == 0 && salesTax == 0 && otherFees == 0){
            return true;
        }
        return false;
    }
    
    
    public static boolean  isInputEmpty(String autoPrice, String loanTerm, String interestRate, String cashIncentives, String downPayment, String tradeInValue, String amtOwedTradeIn, String salesTax, String otherFees){
        if(autoPrice.isEmpty() || loanTerm.isEmpty() || interestRate.isEmpty() || cashIncentives.isEmpty() || downPayment.isEmpty() || tradeInValue.isEmpty() || amtOwedTradeIn.isEmpty() || salesTax.isEmpty() || otherFees.isEmpty()){
            return true;
        }
        return false;
    }
    
    public static boolean  isAnyOnlyDecimal(String autoPrice, String loanTerm, String interestRate, String cashIncentives, String downPayment, String tradeInValue, String amtOwedTradeIn, String salesTax, String otherFees){
        
        if(autoPrice.matches("\\.+") || loanTerm.matches("\\.+") || interestRate.matches("\\.+") || cashIncentives.matches("\\.+") || downPayment.matches("\\.+") || tradeInValue.matches("\\.+") || amtOwedTradeIn.matches("\\.+") || salesTax.matches("\\.+") || otherFees.matches("\\.+")){
            return true;
        }
        return false;
    }
    
    public static boolean validateAllInputs(String autoPrice, String loanTerm, String interestRate, String cashIncentives, String downPayment, String tradeInValue, String amtOwedTradeIn, String salesTax, String otherFees) {
        
        if(isInputEmpty(autoPrice, loanTerm, interestRate, cashIncentives, downPayment, tradeInValue, amtOwedTradeIn, salesTax, otherFees)){
            JOptionPane.showMessageDialog(null, "Make sure all text fields have an input!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
         if(isAnyOnlyDecimal(autoPrice, loanTerm, interestRate, cashIncentives, downPayment, tradeInValue, amtOwedTradeIn, salesTax, otherFees)){
            JOptionPane.showMessageDialog(null, "Make sure no text fields only have '.' !", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        double autoPriceNum = Double.parseDouble(autoPrice);
        int loanTermNum = Integer.parseInt(loanTerm);
        double interestRateNum = Double.parseDouble(interestRate);
        double cashIncentivesNum = Double.parseDouble(cashIncentives);
        double downPaymentNum = Double.parseDouble(downPayment);
        double tradeInValueNum = Double.parseDouble(tradeInValue);
        double amtOwedTradeInNum = Double.parseDouble(amtOwedTradeIn);
        double salesTaxNum = Double.parseDouble(salesTax);
        double otherFeesNum = Double.parseDouble(otherFees);
        
        
        if (isAllZeroInputs(autoPriceNum, loanTermNum, interestRateNum, cashIncentivesNum, downPaymentNum, tradeInValueNum, amtOwedTradeInNum, salesTaxNum, otherFeesNum)) {
            JOptionPane.showMessageDialog(null, "All values can not be zero.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        

        if (loanTermNum == 0) {
            JOptionPane.showMessageDialog(null, "Loan term can not be zero.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (autoPriceNum > 140000000) {
            JOptionPane.showMessageDialog(null, "Auto price can not exceed $140000000.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (autoPriceNum == 0) {
            JOptionPane.showMessageDialog(null, "Auto price can not be $0.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (downPaymentNum >= autoPriceNum) {
            JOptionPane.showMessageDialog(null, "Down payment can not be more than or equal to the auto price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public static double[] autoLoanCalculatorWithFees(double autoPrice, int loanTerm, double interestRate, double cashIncentives, double downPayment, double tradeInValue, double amtOwedTradeIn, double salesTax, double otherFees){
        
        // Calculation for netAutoPrice
        double netAutoPrice = autoPrice - cashIncentives;
        
        // Calculation for totalLoan Amount
        double totalLoanAmount = netAutoPrice - downPayment + amtOwedTradeIn - tradeInValue;
        
        //Calcualtion for Sales Tax
        double salesTaxAmount = (autoPrice - tradeInValue) * (salesTax / 100);
        
        //Here adding the fees to the total loan amount
        totalLoanAmount += salesTaxAmount + otherFees; 
        
        //Interest rate calculations and creating monthlyPayment
        double monthlyInterestRate = (interestRate / 100) / 12;
        double monthlyPayment;
        
        //The calcuation on how to get the monthly payment
        if (interestRate == 0) {
            monthlyPayment = totalLoanAmount / loanTerm;
        } else {
            monthlyPayment= (totalLoanAmount * monthlyInterestRate) /
                                  (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
        }
        
        //Formatting the answer
        
        double netTradeInValue = tradeInValue - amtOwedTradeIn;
        double totalSalesTax = salesTaxAmount;
        double totalUpPayment = downPayment; //+ salesTaxAmount + otherFees- netTradeInValue;
        double totalLoanPayments = monthlyPayment*loanTerm;
        double totalLoanInterest = totalLoanPayments - totalLoanAmount;
        double totalCost = totalLoanPayments + totalUpPayment;
        
        
        
        
        double roundedLoanAmount = Math.round(totalLoanAmount * 100) / 100.0;
        double roundedMonthlyPayment = Math.round(monthlyPayment * 100) / 100.0;
        
        double roundedtotalUpPayment = Math.round(totalUpPayment * 100) / 100.0;
        double roundedtotalLoanPayments = Math.round(totalLoanPayments * 100) / 100.0;
        double roundedtotalLoanInterest = Math.round(totalLoanInterest * 100) / 100.0;
        double roundedtotalSalesTax = Math.round(totalSalesTax * 100) / 100.0;
        double roundedtotalCost = Math.round(totalCost * 100) / 100.0;
        
        
        return new double[]{roundedMonthlyPayment, roundedLoanAmount,roundedtotalSalesTax, roundedtotalUpPayment, roundedtotalLoanPayments, roundedtotalLoanInterest, roundedtotalCost};
    }
    
    public static double[] autoLoanCalculatorWithoutFee(double autoPrice, int loanTerm, double interestRate, double cashIncentives, double downPayment, double tradeInValue, double amtOwedTradeIn, double salesTax, double otherFees){
        
        //Calculation for netAutoPrice 
        double netAutoPrice = autoPrice - cashIncentives;
        
        // Calculation for totalLoan Amount
        double totalLoanAmount = netAutoPrice - downPayment + amtOwedTradeIn - tradeInValue;
        
        //Calcualtion for monthly interest rate
        double monthlyInterestRate = (interestRate / 100) / 12;
        double monthlyPayment;
        
        //The calcuation on how to get the monthly payment
        if (interestRate == 0) {
            monthlyPayment = totalLoanAmount / loanTerm;
        } else {
            monthlyPayment = (totalLoanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm)) 
                             / (Math.pow(1 + monthlyInterestRate, loanTerm) - 1);
        }

        double salesTaxAmount = (autoPrice - tradeInValue) * (salesTax / 100);
        double netTradeInValue = tradeInValue - amtOwedTradeIn;
        double totalUpPayment = downPayment + salesTaxAmount + otherFees- netTradeInValue;
        double totalLoanPayments = monthlyPayment*loanTerm;
        double totalLoanInterest = totalLoanPayments - totalLoanAmount;
        double totalSalesTax = salesTaxAmount;
        double totalCost = totalLoanPayments + totalUpPayment;
        
        double roundedLoanAmount = Math.round(totalLoanAmount * 100) / 100.0;
        double roundedMonthlyPayment = Math.round(monthlyPayment * 100) / 100.0;

        double roundedtotalUpPayment = Math.round(totalUpPayment * 100) / 100.0;
        double roundedtotalLoanPayments = Math.round(totalLoanPayments * 100) / 100.0;
        double roundedtotalLoanInterest = Math.round(totalLoanInterest * 100) / 100.0;
        double roundedtotalSalesTax = Math.round(totalSalesTax * 100) / 100.0;
        double roundedtotalCost = Math.round(totalCost * 100) / 100.0;

        return new double[]{roundedMonthlyPayment, roundedLoanAmount,roundedtotalSalesTax, roundedtotalUpPayment, roundedtotalLoanPayments, roundedtotalLoanInterest, roundedtotalCost};
    }
    
    public static double[] autoLoanCalculatorWithoutSalesTaxWithFees(double autoPrice, int loanTerm, double interestRate, double cashIncentives, double downPayment, double tradeInValue, double amtOwedTradeIn, double salesTax, double otherFees){
        // Calculation for netAutoPrice
        double netAutoPrice = autoPrice - cashIncentives;
        
        // Calculation for totalLoan Amount
        double totalLoanAmount = netAutoPrice - downPayment + amtOwedTradeIn - tradeInValue;
        
        //Calcualtion for Sales Tax
        double salesTaxAmount = (autoPrice - tradeInValue) * (salesTax / 100);
        
        double specialTaxAmount = 0;
        //Here adding the fees to the total loan amount
        totalLoanAmount += specialTaxAmount + otherFees; 
        
        //Interest rate calculations and creating monthlyPayment
        double monthlyInterestRate = (interestRate / 100) / 12;
        double monthlyPayment;
        
        //The calcuation on how to get the monthly payment
        if (interestRate == 0) {
            monthlyPayment = totalLoanAmount / loanTerm;
        } else {
            monthlyPayment= (totalLoanAmount * monthlyInterestRate) /
                                  (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
        }
        
        //Formatting the answer
        
        double netTradeInValue = tradeInValue - amtOwedTradeIn;
        double totalSalesTax = salesTaxAmount;
        double totalUpPayment = downPayment; //+ salesTaxAmount + otherFees- netTradeInValue;
        double totalLoanPayments = monthlyPayment*loanTerm;
        double totalLoanInterest = totalLoanPayments - totalLoanAmount;
        //double totalCost = totalLoanPayments + totalUpPayment;
        
        
        
        
        double roundedLoanAmount = Math.round(totalLoanAmount * 100) / 100.0;
        double roundedMonthlyPayment = Math.round(monthlyPayment * 100) / 100.0;
        
        double roundedtotalUpPayment = Math.round(totalUpPayment * 100) / 100.0;
        double roundedtotalLoanPayments = Math.round(totalLoanPayments * 100) / 100.0;
        double roundedtotalLoanInterest = Math.round(totalLoanInterest * 100) / 100.0;
        double roundedtotalSalesTax = Math.round(totalSalesTax * 100) / 100.0;
        double roundedtotalCost = Math.round((roundedtotalLoanPayments + totalUpPayment) * 100) / 100.0;
        
        
        return new double[]{roundedMonthlyPayment, roundedLoanAmount,roundedtotalSalesTax, roundedtotalUpPayment, roundedtotalLoanPayments, roundedtotalLoanInterest, roundedtotalCost};
    }
    
}
