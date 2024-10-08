
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Dictionary;
import java.util.Hashtable;
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
    
    public static Dictionary<String, Double> webScraper() {
        String s = "success";
        String url = "http://www.x-rates.com/table/?from=USD&amount=1";
        Dictionary<String, Double> rateDict = new Hashtable<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.ratesTable > tbody > tr");
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double rate1 = Double.valueOf(tds.get(1).text());
                Double rate2 = Double.valueOf(tds.get(2).text());
                System.out.printf("Currency: %s, rate1: %s, rate2: %s%n", currency, rate1, rate2);
                rateDict.put(currency, rate1);
            }
        }
        catch (IOException ex) {
            s = "fail";
        }
        System.out.printf("%s", rateDict);
        return rateDict;
    }
}
