/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author loved
 */

public class currency_calc extends javax.swing.JFrame {

    /**
     * Creates new form currency_calc
     */
    
    // Stopped referencing from Helper for some reason
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
        String currencyCode = switch (currencyName) {
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
    
    public static boolean isValidNumber(String test){
        test = test.replace(".", "");
        if (test.isEmpty()) {
            return false;
        }

        char firstChar = test.charAt(0);
        if (!Character.isDigit(firstChar)) {
            return false;
        }

        for (int i = 1; i < test.length(); i++) {
            if (!Character.isDigit(test.charAt(i))) {
                System.out.println(test.charAt(i));
                return false;
            }
        }

        return true;
    }
    
    // Mortgage Calculator
    public static int intFromMonth(String month) {
        String num = switch (month) {   // Symbols not displaying
                case "Jan" -> "1";
                case "Feb" -> "2";
                case "Mar" -> "3";
                case "Apr" -> "4";
                case "May" -> "5";
                case "Jun" -> "6";
                case "Jul" -> "7";
                case "Aug" -> "8";
                case "Sep" -> "9";
                case "Oct" -> "10";
                case "Nov" -> "11";
                case "Dec" -> "12";
                default -> null;
            };
        return Integer.parseInt(num);
    }
    public static String monthFromInt(String n) {
        String month = switch (n) {   // Symbols not displaying
                case "1" -> "Jan";
                case "2" -> "Feb";
                case "3" -> "Mar";
                case "4" -> "Apr";
                case "5" -> "May";
                case "6" -> "Jun";
                case "7" -> "Jul";
                case "8" -> "Aug";
                case "9" -> "Sep";
                case "10" -> "Oct";
                case "11" -> "Nov";
                case "0" -> "Dec";
                default -> null;
            };
        return month;
    }
    
    Map<String, Double> conversionTable = webScraper();
    Map<String, Double> populars = new HashMap<>();
    DefaultComboBoxModel<String> popComboModel = new DefaultComboBoxModel <String>();
    DefaultComboBoxModel<String> comboModel1 = new DefaultComboBoxModel <String>();
    DefaultComboBoxModel<String> comboModel2 = new DefaultComboBoxModel <String>();
    Map<String, String> images = new HashMap<>();
    
    public currency_calc() {
        initComponents();
        this.setBackground(Color.white);
        
        curr1.setText("");
        curr2.setText("");
        /*fromFlag.setIcon(new ImageIcon(new ImageIcon(currency_calc.class.getResource("/images/flags/America.gif"))
                    .getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH)));*/
        
        // Popular Currencies
        String[] pops = {"Australian Dollar",
                         "Brazilian Real",
                         "Canadian Dollar",
                         "Swiss Franc",
                         "Chinese Yuan Renminbi",
                         "Euro",
                         "British Pound",
                         "Hong Kong Dollar",
                         "Indian Rupee",
                         "Japanese Yen",
                         "South Korean Won",
                         "Mexican Peso",
                         "Russian Ruble",
                         "Singapore Dollar",
                         "US Dollar",
                         "South African Rand"
        };
        for (String key : conversionTable.keySet()){
            if (Arrays.asList(pops).contains(key)) {
                populars.put(key, conversionTable.get(key));
                popComboModel.addElement(key);
            }
        }
        
        // Populate images dict
        images.put("Argentine Peso", "Argentina.gif");
        images.put("Australian Dollar", "Australia.gif");
        images.put("Bahraini Dinar", "Bahrain.png");
        images.put("Botswana Pula", "Botswana.png");
        images.put("Brazilian Real", "Brazil.gif");
        images.put("British Pound", "UK.png");
        images.put("Bruneian Dollar", "Brunei.png");
        images.put("Bulgarian Lev", "Bulgaria.png");
        images.put("Canadian Dollar", "Canada.gif");
        images.put("Chilean Peso", "Chile.gif");
        images.put("Chinese Yuan Renminbi", "China.png");
        images.put("Colombian Peso", "Colombia.png");
        images.put("Czech Koruna", "Czech.png");
        images.put("Danish Krone", "Denmark.png");
        images.put("Emirati Dirham", "Emirates.png");
        images.put("Euro", "Europe.png");
        images.put("Hong Kong Dollar", "Hong Kong.gif");
        images.put("Hungarian Forint", "Hungary.gif");
        images.put("Icelandic Krona", "Iceland.png");
        images.put("Indian Rupee", "India.png");
        images.put("Indonesian Rupiah", "Indonesia.png");
        images.put("Iranian Rial", "Iran.png");
        images.put("Israeli Shekel", "Israel.png");
        images.put("Japanese Yen", "Japan.png");
        images.put("Kazakhstani Tenge", "Kazakhstan.png");
        images.put("Kuwaiti Dinar", "Kuwait.png");
        images.put("Libyan Dinar", "Libya.png");
        images.put("Malaysian Ringgit", "Malaysia.png");
        images.put("Mauritian Rupee", "Mauritius.png");
        images.put("Mexican Peso", "Mexico.gif");
        images.put("New Zealand Dollar", "New Zealand.gif");
        images.put("Nepalese Rupee", "Nepal.png");
        images.put("Norwegian Krone", "Norway.gif");
        images.put("Omani Rial", "Oman.png");
        images.put("Pakistani Rupee", "Pakistan.png");
        images.put("Philippine Peso", "Philippines.png");
        images.put("Polish Zloty", "Poland.png");
        images.put("Qatari Riyal", "Qatar.png");
        images.put("Romanian New Leu", "Romania.png");
        images.put("Russian Ruble", "Russia.gif");
        images.put("Saudi Arabian Riyal", "Saudi_arabia.gif");
        images.put("Singapore Dollar", "Singapore.gif");
        images.put("South African Rand", "South_africa.gif");
        images.put("South Korean Won", "South_korea.png");
        images.put("Sri Lankan Rupee", "Sri_lanka.png");
        images.put("Swedish Krona", "Sweden.gif");
        images.put("Swiss Franc", "Switzerland.gif");
        images.put("Taiwan New Dollar", "Taiwan.png");
        images.put("Thai Baht", "Thailand.png");
        images.put("Trinidadian Dollar", "Trinidad.png");
        images.put("Turkish Lira", "Turkey.png");
        images.put("US Dollar", "America.gif");
        images.put("Venezuelan Bolivar", "Venezuela.png");
        
        errLabel.setVisible(false);
        
        // Making a dictionary to hold the webscraped currencies and their exchange rates
        // Adding them to the two combo boxes
        //Map<String, Double> conversionTable = Helper.webScraper();
        System.out.println("\n" + conversionTable.get("Euro"));
        for (String key : conversionTable.keySet()){
            comboModel1.addElement(key);
            comboModel2.addElement(key);
        }
        oldCurrDrop.setModel(comboModel1);
        newCurrDrop.setModel(comboModel2);
        
        /*ImageIcon currencyIcon = new ImageIcon(new ImageIcon(currency_calc.class.getResource("/images/Currency.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
        JLabel currencyPic = new JLabel(currencyIcon);
        currencyPic.setBounds(50, 100, 100, 100);
        this.add(currencyPic);
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oldCurrDrop = new javax.swing.JComboBox<>();
        newCurrDrop = new javax.swing.JComboBox<>();
        oldCurrAmt = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        errLabel = new javax.swing.JLabel();
        flip = new javax.swing.JButton();
        XBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();
        newCurrAmt = new javax.swing.JTextField();
        fromFlag = new javax.swing.JLabel();
        toFlag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        curr1 = new javax.swing.JLabel();
        curr2 = new javax.swing.JLabel();
        curr3 = new javax.swing.JLabel();
        curr4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1650, 1800));
        setPreferredSize(new java.awt.Dimension(1650, 1800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        logo1 = new JLabel();
        logo1.setBackground(new java.awt.Color(66, 133, 244));
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CapitalLogo.png")));
        logo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 133, 244)));
        logo1.setBounds(0, 5, 180, 87);
        logo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo1MouseClicked(evt);
            }
        });
        getContentPane().add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 180, 87));
        
        logo2 = new JLabel("Capital Calc");
        logo2.setBackground(new java.awt.Color(66, 133, 244));
        logo2.setForeground(Color.white);
        logo2.setFont(new Font("Arial", 0, 36));
        logo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 133, 244)));
        logo2.setBounds(200, 5, 300, 87);
        logo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo2MouseClicked(evt);
            }
        });
        getContentPane().add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 5, 300, 87));
        
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title = new JLabel("Currency Converter");
        title.setOpaque(true);
        title.setBackground(new Color(66, 133, 244));
        title.setForeground(Color.white);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", 1, 36));
        title.setAlignmentX(0.5F);
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 500, 50));
        
        XBtn.setFont(new java.awt.Font("Segoe UI", 3, 12));
        XBtn.setForeground(new java.awt.Color(255,51,51));
        XBtn.setText("X");
        XBtn.setBounds(1590, 0, 43, 43);
        XBtn.setBackground(java.awt.Color.white);
        XBtn.setBorderPainted(true);
        XBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3 ,true));
        XBtn.setFocusPainted(false);
        XBtn.setHorizontalAlignment(SwingConstants.CENTER);
        XBtn.setVerticalAlignment(SwingConstants.CENTER);
        XBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XbtnMouseClicked(evt);
            }
        });
        getContentPane().add(XBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 0, 43, 43));
        
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(new java.awt.Color(66, 133, 244));
        jPanel3.setBounds(0, 0, 1650, 100);
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, 100));
        
        clearBtn.setBackground(new java.awt.Color(0, 0, 0));
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearbtnMouseClicked(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, -1, -1));
        
        quitBtn.setBackground(new java.awt.Color(0, 0, 0));
        quitBtn.setForeground(new java.awt.Color(255, 255, 255));
        quitBtn.setText("Quit");
        quitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitbtnMouseClicked(evt);
            }
        });
        getContentPane().add(quitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, -1, -1));
        
        oldCurrDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        oldCurrDrop.setName(""); // NOI18N
        oldCurrDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCurrDropActionPerformed(evt);
            }
        });
        getContentPane().add(oldCurrDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, -1));

        newCurrDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        newCurrDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCurrDropActionPerformed(evt);
            }
        });
        getContentPane().add(newCurrDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 200, -1));

        oldCurrAmt.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        oldCurrAmt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oldCurrAmtKeyTyped(evt);
            }
        });
        getContentPane().add(oldCurrAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 200, 50));

        errLabel.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        errLabel.setForeground(new java.awt.Color(255, 51, 51));
        errLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errLabel.setText("N/A");
        errLabel.setAlignmentX(0.5F);
        getContentPane().add(errLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 140, 40));

        ImageIcon flipIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/double-sided_arrow.png")).getImage().getScaledInstance(105, 35, Image.SCALE_SMOOTH));
        JButton flip = new JButton(flipIcon);
        flip.setPreferredSize(new Dimension(flipIcon.getIconWidth()+10, flipIcon.getIconHeight()+10));
        
        //flip.setBackground(new java.awt.Color(0, 102, 255));
        //flip.setForeground(new java.awt.Color(255, 255, 255));
        //flip.setFont(new java.awt.Font("Segoe UI", 1, 24));
        //flip.setText("<-->");
        flip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flipMouseClicked(evt);
            }
        });
        getContentPane().add(flip, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        newCurrAmt.setEditable(false);
        newCurrAmt.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        newCurrAmt.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(newCurrAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 200, 50));
        getContentPane().add(fromFlag, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 120, 80));
        getContentPane().add(toFlag, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 120, 80));

        jLabel1.setText("From");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        jLabel2.setText("To");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, -1, -1));

        setLabelFont(curr1);
        curr1.setText("Currency1");
        getContentPane().add(curr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, -1, -1));

        setLabelFont(curr2);
        curr2.setText("Currency2");
        getContentPane().add(curr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 540, -1, -1));
        
        curr3.setFont(new java.awt.Font("Noto Sans", 1, 16));
        curr3.setText("₹");
        curr3.setVisible(false);
        getContentPane().add(curr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 540, 20, -1));
        
        curr4.setFont(new java.awt.Font("Noto Sans", 1, 16));
        curr4.setText("₹");
        curr4.setVisible(false);
        getContentPane().add(curr4, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 540, 20, -1));
        
        jCheckBox1.setText("Popular currencies only");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void oldCurrDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCurrDropActionPerformed
        currencyValidate(oldCurrDrop.getSelectedItem(), newCurrDrop.getSelectedItem(), oldCurrAmt.getText());
    }//GEN-LAST:event_oldCurrDropActionPerformed

    private void newCurrDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCurrDropActionPerformed
        currencyValidate(oldCurrDrop.getSelectedItem(), newCurrDrop.getSelectedItem(), oldCurrAmt.getText());
    }//GEN-LAST:event_newCurrDropActionPerformed

    private void oldCurrAmtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldCurrAmtActionPerformed
        validateInput(oldCurrAmt, evt);
        currencyValidate(oldCurrDrop.getSelectedItem(), newCurrDrop.getSelectedItem(), oldCurrAmt.getText());
    }//GEN-LAST:event_oldCurrAmtActionPerformed

    private void flipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flipMouseClicked
        Object oldCurr = oldCurrDrop.getSelectedItem();
        Object newCurr = newCurrDrop.getSelectedItem();
        oldCurrDrop.setSelectedItem(newCurr);
        newCurrDrop.setSelectedItem(oldCurr);
    }//GEN-LAST:event_flipMouseClicked

    private void XbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flipMouseClicked
        this.dispose();
    }
    
    private void clearbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flipMouseClicked
        oldCurrAmt.setText("");
        newCurrAmt.setText("");
    }
    
    private void quitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flipMouseClicked
        this.dispose();
    }//GEN-LAST:event_flipMouseClicked
    
    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        if (oldCurrDrop.getModel() == popComboModel) {
            oldCurrDrop.setModel(comboModel1);
            newCurrDrop.setModel(comboModel2);
        }
        else {
            oldCurrDrop.setModel(popComboModel);
            newCurrDrop.setModel(popComboModel);
        }
    }//GEN-LAST:event_jCheckBox1MouseClicked
    
    private void logo1MouseClicked(java.awt.event.MouseEvent evt) {                                        
        calcPage4_misc calc4 = new calcPage4_misc();
        calc4.setSize(1650, 1800);
        calc4.setVisible(true);
        this.dispose();
    }                                       

    private void logo2MouseClicked(java.awt.event.MouseEvent evt) {                                            
        calcPage4_misc calc4 = new calcPage4_misc();
        calc4.setSize(1650, 1800);
        calc4.setVisible(true);
        this.dispose();
    }      
    
    /**
     * @param oldCurr
     * @param newCurr
     * @param oldAmt
     * @param args the command line arguments
     * @return 
     */
    
    public void setLabelFont(JLabel lbl){
                // Custom font for IndianDevanagari Characters
        try {
            // Load Noto Sans Devanagari font file
            Font notoSansDevanagari = Font.createFont(
                Font.TRUETYPE_FONT,
                new File("src/fonts/NotoSansDevanagari-VariableFont_wdth,wght.ttf")
            ).deriveFont(Font.PLAIN, 16);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(notoSansDevanagari);
            System.out.println("\nLoaded font");
            
            Font compositeFont = new Font(Map.of(
                TextAttribute.FAMILY, "Noto Sans Devanagari, Arial Unicode MS",
                TextAttribute.SIZE, 16,
                TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD // for Font.BOLD equivalent
            ));
        lbl.setFont(compositeFont);
        
        }
        catch (IOException | FontFormatException e) {
            System.out.println("\nCouldn't load font");
        }
    }
    
    public Double convert(Object oldCurr, Object newCurr, String oldAmt){
        // oldCurr to USD
        Double newAmt = Double.valueOf(oldAmt) / conversionTable.get(String.valueOf(oldCurr));
        // USD to newCurr
        //System.out.println(String.valueOf(newCurr));
        newAmt *= conversionTable.get(String.valueOf(newCurr));
        return newAmt;
    }
    
    public void currencyValidate(Object oldCurr, Object newCurr, String oldAmt) {
        if (oldCurr != "" && newCurr != "" && !oldAmt.equals("")) {
            Double newAmt = 0.0;
            oldAmt = String.valueOf(Math.abs(Double.valueOf(oldAmt)));
            curr1.setText(String.valueOf(oldCurr));
            curr2.setText(String.valueOf(newCurr));
            
            try {
                // Converting to same currency
                if (oldCurr == newCurr) {
                    newAmt = Double.valueOf(oldAmt);
                }
                // Converting to different currency with number validation
                else if (isValidNumber(oldAmt)) {
                    newAmt = convert(oldCurr, newCurr, oldAmt);   
                }
                else {
                    throw new NumberFormatException("Not a Valid Number");
                }
                // Formatting to 5 decimal places like seen on the online calculator
                
                System.out.println(String.valueOf(oldCurr));
                System.out.println(images.get(String.valueOf(oldCurr)));
                fromFlag.setIcon(new ImageIcon(new ImageIcon(currency_calc.class.getResource("images/flags/" + images.get(String.valueOf(oldCurr)))).getImage().getScaledInstance(120,80, Image.SCALE_SMOOTH)));
                toFlag.setIcon(new ImageIcon(new ImageIcon(currency_calc.class.getResource("images/flags/" + images.get(String.valueOf(newCurr)))).getImage().getScaledInstance(120,80, Image.SCALE_SMOOTH)));
                
                String initial = getSymbol(oldCurr, Double.valueOf(oldAmt));
                curr1.setText(initial);
                curr4.setVisible(false);
                if (oldCurr.equals("Nepalese Rupee")) {
                    curr1.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
                }
                else if (oldCurr.equals("Indian Rupee")) {
                    curr1.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
                    String wosymb = curr1.getText().substring(1);
                    curr1.setText(wosymb);
                    curr4.setVisible(true);
                }
                else {
                    setLabelFont(curr1);
                }
                
                String result = getSymbol(newCurr, newAmt);
                newCurrAmt.setText(String.valueOf((int) Math.round(newAmt)));
                curr2.setText(result);
                curr3.setVisible(false);
                if (newCurr.equals("Nepalese Rupee")) {
                    curr2.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
                }
                else if (newCurr.equals("Indian Rupee")) {
                    curr2.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
                    String wosymb = curr2.getText().substring(1);
                    curr2.setText(wosymb);
                    curr3.setVisible(true);
                }
                else {
                    setLabelFont(curr2);
                }
                
                errLabel.setText("");
            }
            catch (NumberFormatException e) {
                errLabel.setText("Not a valid number");
            }
        }
        else {
            errLabel.setText("Missing values!");
        }
        
        if (errLabel.getText() != "") {
            errLabel.setVisible(true);
            newCurrAmt.setText("");
        }
        else {
            errLabel.setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(currency_calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(currency_calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(currency_calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(currency_calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new currency_calc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel title;
    private javax.swing.JLabel curr1;
    private javax.swing.JLabel curr2;
    private javax.swing.JLabel curr3;
    private javax.swing.JLabel curr4;
    private javax.swing.JLabel errLabel;
    private javax.swing.JButton flip;
    private javax.swing.JLabel fromFlag;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField newCurrAmt;
    private javax.swing.JComboBox<String> newCurrDrop;
    private javax.swing.JTextField oldCurrAmt;
    private javax.swing.JComboBox<String> oldCurrDrop;
    private javax.swing.JLabel toFlag;
    private javax.swing.JButton XBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton quitBtn;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    // End of variables declaration//GEN-END:variables
}
