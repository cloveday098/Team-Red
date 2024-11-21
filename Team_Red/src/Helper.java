
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Currency;
import java.util.Map;
import java.util.TreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import java.util.Enumeration;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loved
 * @author 5678m
 */

// validate funct
// monthlyPayment funct
// Unit tests for both
public class Helper {
    public static boolean isValidNumber(String test) 
    {
        try {
            float num = Float.parseFloat(test);
        }
        catch (NumberFormatException e) {
            System.out.println(test + " caused " + e);
            return false;
        }
        return true;
    }
    
    public static boolean isPos(String num) 
    {
        if (isValidNumber(num)) {
            if (Float.parseFloat(num) > 0) {
                return true;
            }
            //System.out.println("You cannot have a height or weight <= 0!");
        }
        //System.out.println(num + " is not a number.");
        return false;
    }
    
    public static double monthlyPayment(double amt, double annInterestRate, int yrs) {
        String msg = "";
        if (!isPos(String.valueOf(yrs))) {
            msg += "Years must be > 0!\n";
        }
        if (!isPos(String.valueOf(annInterestRate))) {
            System.out.println("Nice try.");
            msg += "Annual interest rate must be > 0!\n";
        }
        if (amt < 0) {
            msg += "Amount must be > 0!\n";
        }
        
        if (amt > 999999999 || annInterestRate > 999999999) {
            msg += "Amount too large!\n";
        }
        
        if (!msg.equals("")) {
            System.out.println(msg);
            return -1;
        }

        // There shouldn't be a need to validate amt > 0
        double exp = Math.pow((1+annInterestRate/1200), (yrs * 12));
        double result = (amt * annInterestRate/1200) / (1 - 1 / (exp));
        
        // Trying to round to two decimal places
        //BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);  
        //result = bd.doubleValue();
        
        System.out.println(result);
        return result;
    }
    

    // Currency Convertor
    public static boolean isCurrValidNumber(String test) {
    return test.matches("\\d*"); // Matches an empty string or digits only
}

    public static void validateInput(JTextField textField, KeyEvent evt) {
        if (evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_DELETE) {
            String currentText = textField.getText() + evt.getKeyChar();
            if (!isCurrValidNumber(currentText)) {
                evt.consume(); // Block invalid characters
            }
        }
    }
    
    public static Map<String, Double> webScraper() {
        String s = "success";
        String url = "http://www.x-rates.com/table/?from=USD&amount=1";
        Map<String, Double> rateDict = new Hashtable();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.ratesTable > tbody > tr");
            
            // Blank to avoid default currency selection
            rateDict.put("", 0.0);
            rateDict.put("US Dollar", 1.0);
            System.out.println(rateDict.get(""));
            
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double rate1 = Double.valueOf(tds.get(1).text());
                Double rate2 = Double.valueOf(tds.get(2).text());
                //System.out.printf("Currency: %s, rate1: %s, rate2: %s%n", currency, rate1, rate2);
                rateDict.put(currency, rate1);
            }
            rateDict = new TreeMap<String, Double>(rateDict);
        }
        catch (IOException ex) {
            s = "fail";
        }
        System.out.printf("%s", rateDict);
        return rateDict;
    }
    
    // Format the amount using deciamls/commas and currency symbols
    public static String getSymbol(Object currency, Double newAmt) {
        // Arial Unicode MS for symbol font
        double d = newAmt;
        // Checking locale function;
        //String currencyName = NumberFormat.getCurrencyInstance(getLocaleFromCurrency(String.valueOf(currency))).getCurrency().getDisplayName();
        NumberFormat nf
            = NumberFormat.getCurrencyInstance(getLocaleFromCurrency(String.valueOf(currency)));
        //System.out.println("\n" + nf.getCurrency().getDisplayName() + " vs. " + currencyName);
        System.out.println("\n" + currency + " representation of " + d
                           + " : " + nf.format(d));
        return nf.format(d);
    }
    
    // Mapping 
    public static Locale getLocaleFromCurrency(String currencyName) {
        String currencyCode = switch (currencyName) {   // Symbols not displaying
            case "Argentine Peso" -> "ARS";
            case "Australian Dollar" -> "AUD";
            case "Bahraini Dinar" -> "BHD";
            case "Botswana Pula" -> "BWP";
            case "Brazilian Real" -> "BRL";
            case "British Pound" -> "GBP";
            case "Bruneian Dollar" -> "BND";
            case "Bulgarian Lev" -> "BGN";
            case "Canadian Dollar" -> "CAD";
            case "Chilean Peso" -> "CLP";
            case "Chinese Yuan Renminbi" -> "CNY";
            case "Colombian Peso" -> "COP";
            case "Czech Koruna" -> "CZK";
            case "Danish Krone" -> "DKK";
            case "Emirati Dirham" -> "AED";
            case "Euro" -> "EUR";
            case "Hong Kong Dollar" -> "HKD";
            case "Hungarian Forint" -> "HUF";
            case "Icelandic Krona" -> "ISK";
            case "Indian Rupee" -> "INR";
            case "Indonesian Rupiah" -> "IDR";
            case "Iranian Rial" -> "IRR";
            case "Israeli Shekel" -> "ILS";
            case "Japanese Yen" -> "JPY";
            case "Kazakhstani Tenge" -> "KZT";
            case "Kuwaiti Dinar" -> "KWD";
            case "Libyan Dinar" -> "LYD";
            case "Malaysian Ringgit" -> "MYR";
            case "Mauritian Rupee" -> "MUR";
            case "Mexican Peso" -> "MXN";
            case "Nepalese Rupee" -> "NPR";
            case "New Zealand Dollar" -> "NZD";
            case "Norwegian Krone" -> "NOK";
            case "Omani Rial" -> "OMR";
            case "Pakistani Rupee" -> "PKR";
            case "Philippine Peso" -> "PHP";
            case "Polish Zloty" -> "PLN";
            case "Qatari Riyal" -> "QAR";
            case "Romanian New Leu" -> "RON";
            case "Russian Ruble" -> "RUB";
            case "Saudi Arabian Riyal" -> "SAR";
            case "Singapore Dollar" -> "SGD";
            case "South African Rand" -> "ZAR";
            case "South Korean Won" -> "KRW";
            case "Sri Lankan Rupee" -> "LKR";
            case "Swedish Krona" -> "SEK";
            case "Swiss Franc" -> "CHF";
            case "Taiwan New Dollar" -> "TWD";
            case "Thai Baht" -> "THB";
            case "Trinidadian Dollar" -> "TTD";
            case "Turkish Lira" -> "TRY";
            case "US Dollar" -> "USD";
            case "Venezuelan Bolivar" -> "VES";
            
            default -> null;
        };
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                //System.out.println("case " + "\"" + NumberFormat.getCurrencyInstance(locale).getCurrency().getDisplayName()+ "\" -> \"" + currency + "\";");
                //System.out.println(currency.getCurrencyCode().equals(currencyCode));
                if (currency != null && currency.getCurrencyCode().equals(currencyCode)) {
                    return locale;
                }
            } catch (Exception e) {
            }
        }
        System.out.println("Couldn't find " + currencyName);
        return null;
    }

    // Auto Loan Calculator
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