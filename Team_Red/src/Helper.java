
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    
    public static Map<String, Double> webScraper() {
        String s = "success";
        String url = "http://www.x-rates.com/table/?from=USD&amount=1";
        Map<String, Double> rateDict = new Hashtable();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.ratesTable > tbody > tr");
            
            // Blank to avoid default currency selection
            rateDict.put("", 0.0);
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
}
