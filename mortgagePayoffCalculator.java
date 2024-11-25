package Images;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author gabby
 */
public class mortgagePayoffCalculator extends javax.swing.JDialog {

    /**
     * Creates new form mortgagePayoffCalculator
     */
  
    
    
    public mortgagePayoffCalculator(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        payNormal.setSelected(true);
        this.getContentPane().setBackground(Color.white);

        KeyAdapter positiveNumberKeyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                JTextField source = (JTextField) e.getSource();
                String currentText = source.getText();

                if (!Character.isDigit(c) && c != '.') {
                    e.consume();  
                } else if (c == '.' && currentText.contains(".")) {
                    e.consume(); 
                } else if (currentText.isEmpty() && c == '0' && source == loanAmountInput) {
                    e.consume(); 
                }
            }
            
        };
        loanAmountInput.addKeyListener(positiveNumberKeyAdapter); 
        interestRateInput.addKeyListener(positiveNumberKeyAdapter);

        KeyAdapter numOnlyKeyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); 
                }
            }
     
        };
        originalLoanTermInput.addKeyListener(numOnlyKeyAdapter); 
        remainingTermYearInput.addKeyListener(numOnlyKeyAdapter); 
        remainingTermMonthInput.addKeyListener(numOnlyKeyAdapter); 
        repayMonthInput.addKeyListener(numOnlyKeyAdapter); 
        repayYearInput.addKeyListener(numOnlyKeyAdapter); 
        repayOneInput.addKeyListener(numOnlyKeyAdapter); 
        
        repayMonthInput.setEnabled(false);
        repayYearInput.setEnabled(false);
        repayOneInput.setEnabled(false);
        
   

        
        addFocusListener(repayMonthInput, repayYearInput, repayOneInput);
        addFocusListener(repayYearInput, repayMonthInput, repayOneInput);
        addFocusListener(repayOneInput, repayMonthInput, repayYearInput);
                     
  calculateButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if any required field is empty
        if (loanAmountInput.getText().isEmpty() || interestRateInput.getText().isEmpty() ||
            originalLoanTermInput.getText().isEmpty() || remainingTermYearInput.getText().isEmpty() ||
            remainingTermMonthInput.getText().isEmpty()) {

            errorLabel.setText("Please fill out all fields");
            return;  // Exit if any field is empty
        }

        try {
            // Parse the input values
            double loanAmount = Double.parseDouble(loanAmountInput.getText());
            double interestRate = Double.parseDouble(interestRateInput.getText());
            int originalLoanTerm = Integer.parseInt(originalLoanTermInput.getText());
            int remainingTermYears = Integer.parseInt(remainingTermYearInput.getText());
            int remainingTermMonths = Integer.parseInt(remainingTermMonthInput.getText());

            // Validation for loanAmount, interestRate, originalLoanTerm, and remainingTerm
            if (loanAmount < 30000 || loanAmount > 5000000) {
                errorLabel.setText("Loan amount must be between $30,000 and $5,000,000.");
                return;
            }

            if (interestRate < 0.05 || interestRate > 30) {
                errorLabel.setText("Interest rate must be between 0.05% and 30%.");
                return;
            }

            if (originalLoanTerm <= 1 || originalLoanTerm >= 100) {
                errorLabel.setText("Original loan term must be greater than 1 year and less than 100 years.");
                return;
            }

            if (remainingTermYears < 1 || remainingTermYears > 100) {
                errorLabel.setText("Remaining term (in years) must be greater than 1 year and less than 100 years.");
                return;
            }

            if (remainingTermYears > originalLoanTerm) {
                errorLabel.setText("Remaining term (in years) cannot be greater than the original loan term.");
                return;
            }

            int totalRemainingMonths = remainingTermYears * 12 + remainingTermMonths;

            if (totalRemainingMonths > (originalLoanTerm * 12)) {
                errorLabel.setText("Remaining term (in months) cannot be greater than the original loan term.");
                return;
            }

            // If no errors, clear the error message
            errorLabel.setText("");

            // Proceed based on the selected radio buttons
            if (payNormal.isSelected()) {
                calculateNormalPayment(); 
            } else if (payBiweekly.isSelected()) {
                calculateBiweeklyPayment();
            } else if (payAltogether.isSelected()) {
                calculatePaybackAltogether();
            } else if (repayWith.isSelected()) {
                calculateWithExtraPayments();
            }

        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid numbers.");
        }
    }
});
    } 
private void calculateNormalPayment() {
    try {
    
        double loanAmount = Double.parseDouble(loanAmountInput.getText()); 
        double annualInterestRate = Double.parseDouble(interestRateInput.getText()); 
        int originalLoanTerm = Integer.parseInt(originalLoanTermInput.getText()); 
        int remainingTermYears = Integer.parseInt(remainingTermYearInput.getText()); 
        int remainingTermMonths = Integer.parseInt(remainingTermMonthInput.getText()); 

        double monthlyInterestRate = annualInterestRate / 100 / 12; 
        int totalPayments = originalLoanTerm * 12;
        int remainingPayments = (remainingTermYears * 12) + remainingTermMonths; 

        double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments)) /
                                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);

        double remainingBalance = loanAmount * Math.pow(1 + monthlyInterestRate, paymentsMade(totalPayments, remainingPayments)) -
                                  (monthlyPayment * ((Math.pow(1 + monthlyInterestRate, paymentsMade(totalPayments, remainingPayments)) - 1) / monthlyInterestRate));

        double totalPaymentAmount = monthlyPayment * totalPayments;

        double remainingPaymentAmount = monthlyPayment * remainingPayments;

        
        jTable1.setValueAt(String.format("$%.2f", monthlyPayment), 0, 1); 
        jTable1.setValueAt(String.format("$%.2f", totalPaymentAmount), 1, 1);
        jTable1.setValueAt(String.format("$%.2f", remainingBalance), 3, 1); 
        jTable1.setValueAt(String.format("$%.2f", remainingPaymentAmount), 2, 1); 
        jTable1.setValueAt(remainingTermYears + " yrs " + remainingTermMonths + " months", 4, 1);

    } catch (NumberFormatException ex) {
        ResultLabel.setText("Please enter valid inputs.");
    }
}

private int paymentsMade(int totalPayments, int remainingPayments) {
    return totalPayments - remainingPayments;
}
  
private void calculateBiweeklyPayment() {
    try {
        double loanAmount = Double.parseDouble(loanAmountInput.getText()); 
        double annualInterestRate = Double.parseDouble(interestRateInput.getText()); 
        int originalLoanTerm = Integer.parseInt(originalLoanTermInput.getText());

        double monthlyInterestRate = annualInterestRate / 100 / 12;

        int totalMonthlyPayments = originalLoanTerm * 12;

        double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonthlyPayments)) / 
                (Math.pow(1 + monthlyInterestRate, totalMonthlyPayments) - 1);

        double biweeklyPayment = monthlyPayment / 2;  

        double totalPayments = biweeklyPayment * 26 * originalLoanTerm; 
        int remainingLoanTermInYears = originalLoanTerm - 5; 
        double remainingPayments = biweeklyPayment * 26 * remainingLoanTermInYears;

        double totalInterest = totalPayments - loanAmount;

        int paymentsMade = 5 * 26; 
        double remainingBalance = loanAmount * 
            (Math.pow(1 + monthlyInterestRate, totalMonthlyPayments) - Math.pow(1 + monthlyInterestRate, paymentsMade)) /
            (Math.pow(1 + monthlyInterestRate, totalMonthlyPayments) - 1);

        double remainingInterest = remainingPayments - remainingBalance;


        jTable1.setValueAt(String.format("$%.2f", biweeklyPayment), 0, 2); 
        jTable1.setValueAt(String.format("$%.2f", totalPayments), 1, 2); 
        jTable1.setValueAt(String.format("$%.2f", remainingPayments), 2, 2); 
        jTable1.setValueAt(String.format("$%.2f", totalInterest), 3, 2); 
        jTable1.setValueAt(String.format("$%.2f", remainingInterest), 4, 2); 
    } catch (NumberFormatException ex) {
        resultinfoLabel.setText("Please enter valid numbers.");
    }
}











 

  

   
private void calculatePaybackAltogether() {
    try {
        double loanAmount = Double.parseDouble(loanAmountInput.getText()); 
        double annualInterestRate = Double.parseDouble(interestRateInput.getText()); 
        int originalLoanTerm = Integer.parseInt(originalLoanTermInput.getText()); 
        int remainingTermYears = Integer.parseInt(remainingTermYearInput.getText()); 
        int remainingTermMonths = Integer.parseInt(remainingTermMonthInput.getText()); 

        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int totalPayments = originalLoanTerm * 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments)) /
                                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);

        int paymentsMade = (originalLoanTerm - remainingTermYears) * 12 + remainingTermMonths;
        int remainingPayments = (remainingTermYears * 12) + remainingTermMonths;

        double remainingBalance = loanAmount * 
            (Math.pow(1 + monthlyInterestRate, totalPayments) - Math.pow(1 + monthlyInterestRate, paymentsMade)) /
            (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);

        double totalPaidSoFar = monthlyPayment * paymentsMade;  

        double totalPayment = totalPaidSoFar + remainingBalance;


        double totalPaymentsAltogether = remainingBalance; 

        String payoffTime = "0 years, 0 months"; 
        jTable1.setValueAt(String.format("$%.2f", totalPaymentsAltogether), 0, 2); 
        jTable1.setValueAt(String.format("$%.2f", totalPayment), 1, 2); 
        jTable1.setValueAt("0.00", 2, 2);  
        jTable1.setValueAt("0.00", 3, 2);
        jTable1.setValueAt(payoffTime, 4, 2); 
        //resultlabel.setText("Paying your loan back altogether will result in a saving amount of: "+ String.format("$%.2f", saving));

    } catch (NumberFormatException ex) {
        resultinfoLabel.setText("Please enter valid numbers.");
    }
}




  

    
    
    
     private void calculateWithExtraPayments() {
        try {
            double loanAmount = Double.parseDouble(loanAmountInput.getText());
            double annualInterestRate = Double.parseDouble(interestRateInput.getText());
            int originalLoanTerm = Integer.parseInt(originalLoanTermInput.getText());
            int remainingTermYears = Integer.parseInt(remainingTermYearInput.getText());
            int remainingTermMonths = Integer.parseInt(remainingTermMonthInput.getText());

            double monthlyInterestRate = annualInterestRate / 100 / 12;
            int totalPayments = originalLoanTerm * 12;
            int paymentsMade = (originalLoanTerm - remainingTermYears) * 12 + remainingTermMonths;

            double remainingBalance = loanAmount * 
                (Math.pow(1 + monthlyInterestRate, totalPayments) - Math.pow(1 + monthlyInterestRate, paymentsMade)) /
                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);
            
            double extraMonthly = 0, extraYearly = 0, extraOneTime = 0;

            if (!repayMonthInput.getText().isEmpty()) {
                extraMonthly = Double.parseDouble(repayMonthInput.getText());
              
                calculatePayoffWithMonthlyExtra(remainingBalance, monthlyInterestRate, extraMonthly);
            } else if (!repayYearInput.getText().isEmpty()) {
                extraYearly = Double.parseDouble(repayYearInput.getText());
              
                calculatePayoffWithYearlyExtra(remainingBalance, monthlyInterestRate, extraYearly);
            } else if (!repayOneInput.getText().isEmpty()) {
                extraOneTime = Double.parseDouble(repayOneInput.getText());
             
                calculatePayoffWithOneTimeExtra(remainingBalance, monthlyInterestRate, extraOneTime);
            } else {
                errorLabel.setText("Please enter an extra payment amount.");
            }  
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid numbers.");
        }
    }  

 private void calculatePayoffWithMonthlyExtra(double remainingBalance, double monthlyInterestRate, double extraMonthly) {
    // Calculate the normal monthly payment based on the remaining balance and interest rate
    double monthlyPayment = remainingBalance * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -1));
    
    // Add the extra monthly payment to the normal monthly payment
    double totalMonthlyPayment = monthlyPayment + extraMonthly;

    double adjustedBalance = remainingBalance;
    int months = 0;

    // Loop to calculate how many months it will take to pay off the loan with the extra monthly payment
    while (adjustedBalance > 0) {
        // Calculate interest for the current month
        double interestForMonth = adjustedBalance * monthlyInterestRate;

        // Update the adjusted balance after subtracting the total monthly payment
        adjustedBalance = adjustedBalance + interestForMonth - totalMonthlyPayment;
        
        // Prevent going negative if the final payment overshoots the remaining balance
        if (adjustedBalance < 0) {
            adjustedBalance = 0;
        }

        months++;
    }

    // Calculate the years and months it will take to pay off the loan
    int yearsToPayoff = months / 12;
    int remainingMonths = months % 12;

    // Calculate the total interest paid without the extra monthly payment (standard payment)
    double totalInterestWithoutExtra = (monthlyPayment * months) - remainingBalance;

    // Calculate the total interest paid with the extra monthly payment
    double totalInterestPaidWithExtra = (totalMonthlyPayment * months) - remainingBalance;

    // Calculate the interest savings due to the extra monthly payment
    double interestSavings = totalInterestWithoutExtra - totalInterestPaidWithExtra;

    // Prepare the result message to display to the user
    String resultMessage = String.format("<html>Payoff in %d years and %d months<br>" +
                                          "Remaining balance: $%.2f.<br>By paying an extra $%.2f per month, " +
                                          "the loan will be paid off in %d years and %d months.<br>" +
                                          "Interest savings: $%.2f</html>",
                                          yearsToPayoff, remainingMonths, 
                                          remainingBalance, extraMonthly, 
                                          yearsToPayoff, remainingMonths,
                                          interestSavings);

    // Update the monthly payment including the extra amount in the table
    jTable1.setValueAt(String.format("$%.2f", totalMonthlyPayment), 0, 2);  // New monthly payment with extra
    jTable1.setValueAt(String.format("$%.2f", monthlyPayment), 1, 2);  // Normal monthly payment without extra
    jTable1.setValueAt(String.format("$%.2f", adjustedBalance), 2, 2);  // Remaining balance after extra payments
    jTable1.setValueAt(String.format("$%.2f", interestSavings), 3, 2);  // Interest savings from extra payments

    // Display the result message to the user
    resultinfoLabel.setText(resultMessage);
}


private void calculatePayoffWithYearlyExtra(double remainingBalance, double monthlyInterestRate, double extraYearly) {
    double adjustedBalance = remainingBalance;
    int months = 0;

    double monthlyPayment = (remainingBalance * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -1));

    double totalPaid = 0;
    double totalInterestWithoutExtra = 0;
    double totalInterestPaidWithExtra = 0;

    while (adjustedBalance > 0) {
        double interestForMonth = adjustedBalance * monthlyInterestRate;

        if (months % 12 == 0 && months != 0) {
            adjustedBalance -= extraYearly;  
        }

        adjustedBalance = adjustedBalance + interestForMonth - monthlyPayment;

        if (adjustedBalance < 0) {
            adjustedBalance = 0;
        }

        totalPaid += monthlyPayment;  
        totalInterestWithoutExtra += interestForMonth;  

        totalInterestPaidWithExtra = (totalPaid + (extraYearly * (months / 12))) - remainingBalance;

        months++;
    }

    int yearsToPayoff = months / 12;
    int remainingMonths = months % 12;
    double interestSavings = totalInterestWithoutExtra - totalInterestPaidWithExtra;

   


    jTable1.setValueAt(String.format("$%.2f", monthlyPayment), 0, 2);
    jTable1.setValueAt(String.format("$%.2f", totalPaid), 1, 2); 
    jTable1.setValueAt(String.format("$%.2f", totalInterestPaidWithExtra), 2, 2);
    jTable1.setValueAt(String.format("$%.2f", remainingBalance), 3, 2);
    jTable1.setValueAt(yearsToPayoff + " yrs " + remainingMonths + " months", 4, 2);
  
    
}



 
private void calculatePayoffWithOneTimeExtra(double remainingBalance, double monthlyInterestRate, double extraOneTime) {
    try {
        // Assume you have some predefined values or inputs for loanAmount, originalLoanTerm, etc.
        double loanAmount = 400000;  // Example
        int originalLoanTerm = 30;   // Example
        int totalPayments = originalLoanTerm * 12;  // Total number of payments for the original term

        // Calculate original monthly payment based on the full loan amount
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalPayments));

        // Adjust the loan balance based on the extra payment
        double adjustedBalance = remainingBalance - extraOneTime;

        // Recalculate the remaining months and payoff time
        int months = 0;

        while (adjustedBalance > 0) {
            double interestForMonth = adjustedBalance * monthlyInterestRate;
            adjustedBalance = adjustedBalance + interestForMonth - monthlyPayment;
            months++;
        }

        // Calculate years and months for payoff
        int yearsToPayoff = months / 12;
        int remainingMonths = months % 12;

        // Calculate total interest saved
        double totalInterestWithoutExtra = (monthlyPayment * totalPayments) - loanAmount;  // Without the extra payment
        double totalInterestPaidWithExtra = (monthlyPayment * months) - loanAmount;  // With the extra payment
        double interestSavings = totalInterestWithoutExtra - totalInterestPaidWithExtra;

        // Fill the JTable with the results
        jTable1.setValueAt(String.format("$%.2f", monthlyPayment), 0, 2);               // Monthly payment
        jTable1.setValueAt(String.format("$%.2f", adjustedBalance), 1, 2);              // Remaining balance
        jTable1.setValueAt(String.format("$%.2f", interestSavings), 2, 2);               // Interest savings
        jTable1.setValueAt(String.format("%d years, %d months", yearsToPayoff, remainingMonths), 3, 2);  // Payoff time

    } catch (NumberFormatException ex) {
        // Handle invalid input
        resultinfoLabel.setText("Please enter valid numbers.");
    }
}

 
    
    
    private void addFocusListener(JTextField mainField, JTextField disableField1, JTextField disableField2) {
    
        mainField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                disableField1.setEnabled(false);
                disableField2.setEnabled(false);
            }

            public void focusLost(FocusEvent e) {
                if (mainField.getText().isEmpty()) {
                    disableField1.setEnabled(true);
                    disableField2.setEnabled(true);
                }
            }
        });

        mainField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                if (!mainField.getText().isEmpty()) {
                    disableField1.setText("");
                    disableField2.setText("");
                }
                return true;
            }
        });
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        loanAmountLabel = new javax.swing.JLabel();
        originalLoanTermLabel = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        remainingLabel = new javax.swing.JLabel();
        interestRateInput = new javax.swing.JTextField();
        originalLoanTermInput = new javax.swing.JTextField();
        remainingTermYearInput = new javax.swing.JTextField();
        dollarLoan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        remainingTermMonthInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        loanAmountInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        repayLabel = new javax.swing.JLabel();
        payAltogether = new javax.swing.JRadioButton();
        payBiweekly = new javax.swing.JRadioButton();
        payNormal = new javax.swing.JRadioButton();
        repayWith = new javax.swing.JRadioButton();
        repayMonthInput = new javax.swing.JTextField();
        repayYearInput = new javax.swing.JTextField();
        repayOneInput = new javax.swing.JTextField();
        repayMonthLabel = new javax.swing.JLabel();
        repayYearLabel = new javax.swing.JLabel();
        repayOneLabel = new javax.swing.JLabel();
        calculateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        ResultLabel = new javax.swing.JLabel();
        resultinfoLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        resultlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/icon.png")).getImage());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        loanAmountLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        loanAmountLabel.setText("Original loan amount");

        originalLoanTermLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        originalLoanTermLabel.setText("Original loan term");

        interestRateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        interestRateLabel.setText("Interest rate");

        remainingLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        remainingLabel.setText("Remaining Term ");

        interestRateInput.setText("6");

        originalLoanTermInput.setText("30");

        remainingTermYearInput.setText("25");

        dollarLoan.setText("($)");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("(years)");

        remainingTermMonthInput.setText("0");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("(%)");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("years");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("months");

        loanAmountInput.setText("400000");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        repayLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        repayLabel.setText("Repaymement options:");

        buttonGroup1.add(payAltogether);
        payAltogether.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        payAltogether.setText("Payback Altogether");

        buttonGroup1.add(payBiweekly);
        payBiweekly.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        payBiweekly.setText("Biweekly");

        buttonGroup1.add(payNormal);
        payNormal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        payNormal.setText("Normal Repayment");

        buttonGroup1.add(repayWith);
        repayWith.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        repayWith.setText("Repayment with extra payments ");
        repayWith.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repayWithActionPerformed(evt);
            }
        });

        repayMonthLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        repayMonthLabel.setText("$ per month");

        repayYearLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        repayYearLabel.setText("$ per year");

        repayOneLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        repayOneLabel.setText("$ one time");

        calculateButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        calculateButton.setText("Calculate");
        calculateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateButtonMouseClicked(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 51));
        errorLabel.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(payBiweekly, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(payNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(repayMonthInput, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(repayMonthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repayYearInput, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(repayOneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repayOneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(repayYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(payAltogether)
                        .addGap(28, 28, 28)
                        .addComponent(repayWith, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(repayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(payAltogether)
                                    .addComponent(repayWith))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(payBiweekly)
                                    .addComponent(repayMonthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(repayMonthLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(payNormal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(repayYearInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(repayYearLabel))))
                        .addGap(7, 7, 7)
                        .addComponent(repayOneLabel))
                    .addComponent(repayOneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(calculateButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(originalLoanTermLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loanAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(interestRateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dollarLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(remainingLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originalLoanTermInput, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestRateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(remainingTermYearInput, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(remainingTermMonthInput, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 130, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loanAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dollarLoan)
                    .addComponent(loanAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(originalLoanTermLabel)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(originalLoanTermInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(interestRateLabel)
                        .addComponent(jLabel3))
                    .addComponent(interestRateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remainingTermYearInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remainingLabel)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remainingTermMonthInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        resultinfoLabel.setForeground(new java.awt.Color(0, 51, 0));

        jPanel3.setBackground(new java.awt.Color(62, 142, 224));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Capital Calc");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CapitalLogo (3).png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(62, 142, 224));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mortgage Payoff");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(62, 142, 224));

        jLabel8.setBackground(new java.awt.Color(62, 142, 224));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Results");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pay Per Period", null, null},
                {"Total Payments", null, null},
                {"Remaining Payments", null, null},
                {"Remaining Interest", null, null},
                {"Payoff In", null, null}
            },
            new String [] {
                "", "Original", "With Payoff"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        resultlabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        resultlabel.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(resultlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resultlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultinfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resultinfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(ResultLabel)
                        .addGap(160, 160, 160))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void calculateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculateButtonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_calculateButtonMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        
        originalLoanTermInput.setText(""); 
        remainingTermYearInput.setText("");
        remainingTermMonthInput.setText(""); 
        repayMonthInput.setText("");
        repayYearInput.setText(""); 
        repayOneInput.setText("");
        interestRateInput.setText("");
        loanAmountInput.setText("");
        payNormal.setSelected(true);
        repayMonthInput.setEnabled(false);
        repayYearInput.setEnabled(false);
        repayOneInput.setEnabled(false);
        errorLabel.setText("");
        
        jTable1.setValueAt("", 0, 1); 
        jTable1.setValueAt("", 0, 2);
        jTable1.setValueAt("", 1, 1);
        jTable1.setValueAt("", 1, 2);
        jTable1.setValueAt("", 2, 1);
        jTable1.setValueAt("", 2, 2);
        jTable1.setValueAt("", 3, 1);
        jTable1.setValueAt("", 3, 2);
        
    }//GEN-LAST:event_clearButtonActionPerformed

    private void repayWithActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repayWithActionPerformed
        // TODO add your handling code here:
        repayMonthInput.setEnabled(true);
        repayYearInput.setEnabled(true);
        repayOneInput.setEnabled(true);
        
    }//GEN-LAST:event_repayWithActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();

    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mortgagePayoffCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mortgagePayoffCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mortgagePayoffCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mortgagePayoffCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mortgagePayoffCalculator dialog = new mortgagePayoffCalculator(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ResultLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel dollarLoan;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField interestRateInput;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField loanAmountInput;
    private javax.swing.JLabel loanAmountLabel;
    private javax.swing.JTextField originalLoanTermInput;
    private javax.swing.JLabel originalLoanTermLabel;
    private javax.swing.JRadioButton payAltogether;
    private javax.swing.JRadioButton payBiweekly;
    private javax.swing.JRadioButton payNormal;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JTextField remainingTermMonthInput;
    private javax.swing.JTextField remainingTermYearInput;
    private javax.swing.JLabel repayLabel;
    private javax.swing.JTextField repayMonthInput;
    private javax.swing.JLabel repayMonthLabel;
    private javax.swing.JTextField repayOneInput;
    private javax.swing.JLabel repayOneLabel;
    private javax.swing.JRadioButton repayWith;
    private javax.swing.JTextField repayYearInput;
    private javax.swing.JLabel repayYearLabel;
    private javax.swing.JLabel resultinfoLabel;
    private javax.swing.JLabel resultlabel;
    // End of variables declaration//GEN-END:variables
}
