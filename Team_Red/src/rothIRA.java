/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author gabby
 */
public class rothIRA extends javax.swing.JFrame {

    /**
     * Creates new form rothIRA
     */
    public rothIRA() {
        initComponents();
        rothInfoPic.setVisible(false);
        
        
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
                } else if (currentText.isEmpty() && c == '0' && source == ageInput) {
                    e.consume(); 
                }
            }
            
        };
        currentBalanceInput.addKeyListener(positiveNumberKeyAdapter);
        annualContributionInput.addKeyListener(positiveNumberKeyAdapter);
        rateOfReturnInput.addKeyListener(positiveNumberKeyAdapter);
        taxRateInput.addKeyListener(positiveNumberKeyAdapter);
        
        
        
          KeyAdapter numOnlyKeyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); 
                }
            }
     
        };
          ageInput.addKeyListener(numOnlyKeyAdapter);
          retirementAgeInput.addKeyListener(numOnlyKeyAdapter);
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
        ResultLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        differenceLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        maxContributionYes = new javax.swing.JRadioButton();
        maxContributionNo = new javax.swing.JRadioButton();
        ageInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        retirementAgeInput = new javax.swing.JTextField();
        calculateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        ageError = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        taxRateInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        annualContributionInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rateOfReturnInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        currentBalanceInput = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        marginalTaxImg = new javax.swing.JLabel();
        rothInfo = new javax.swing.JLabel();
        rothInfoPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1653, 1800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ResultLabel.setForeground(java.awt.Color.red);
        getContentPane().add(ResultLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, 564, 64));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Marginal Tax Rate ");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 228, 58));

        differenceLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(differenceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 340, 560, 28));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Max Contribution ");

        buttonGroup1.add(maxContributionYes);
        maxContributionYes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxContributionYes.setText("Yes");
        maxContributionYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxContributionYesMouseClicked(evt);
            }
        });
        maxContributionYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxContributionYesActionPerformed(evt);
            }
        });

        buttonGroup1.add(maxContributionNo);
        maxContributionNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxContributionNo.setText("No");
        maxContributionNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxContributionNoMouseClicked(evt);
            }
        });

        ageInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Current Age");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Retirement Age");

        retirementAgeInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        calculateButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        calculateButton.setText("Calculate");
        calculateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateButtonMouseClicked(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        ageError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ageError.setText(" ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Marginal Tax rate");

        taxRateInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxRateInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Annual Contribution");

        annualContributionInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        annualContributionInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annualContributionInputActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Rate of Return ");

        rateOfReturnInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rateOfReturnInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Current Balance");

        currentBalanceInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(taxRateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rateOfReturnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(258, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(currentBalanceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(maxContributionYes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maxContributionNo))
                                    .addComponent(annualContributionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(clearButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(calculateButton)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ageError, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(retirementAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(41, 41, 41)
                                                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addContainerGap())))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(currentBalanceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annualContributionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxContributionYes)
                    .addComponent(maxContributionNo)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(retirementAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rateOfReturnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(taxRateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calculateButton)
                    .addComponent(clearButton))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ageError)
                .addGap(109, 109, 109))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 270));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel10.setText("Roth IRA ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 37, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("X");
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 0, -1, -1));

        marginalTaxImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/marginalTax.png"))); // NOI18N
        marginalTaxImg.setMaximumSize(new java.awt.Dimension(1771, 640));
        marginalTaxImg.setPreferredSize(new java.awt.Dimension(1200, 433));
        getContentPane().add(marginalTaxImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, 430));

        rothInfo.setBackground(new java.awt.Color(199, 219, 252));
        rothInfo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rothInfo.setForeground(new java.awt.Color(66, 133, 244));
        rothInfo.setText(" ? ");
        rothInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 133, 244), 4, true));
        rothInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rothInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rothInfoMouseExited(evt);
            }
        });
        getContentPane().add(rothInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        rothInfoPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RothIRAInfo.png"))); // NOI18N
        rothInfoPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 133, 244)));
        getContentPane().add(rothInfoPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annualContributionInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annualContributionInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_annualContributionInputActionPerformed

    private void maxContributionYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxContributionYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxContributionYesActionPerformed

    private void calculateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculateButtonMouseClicked
        // TODO add your handling code here:
        //int currentAge = Integer.parseInt(ageInput.getText());

        if (currentBalanceInput.getText().isEmpty() || annualContributionInput.getText().isEmpty() || rateOfReturnInput.getText().isEmpty() || ageInput.getText().isEmpty() || retirementAgeInput.getText().isEmpty() || taxRateInput.getText().isEmpty() )
            {
                ResultLabel.setForeground(Color.RED);
                ResultLabel.setText("Please Fill Out All Fields");
                
        } 
        
        
        else 
            {
    
                double currentBalance = Double.parseDouble(currentBalanceInput.getText());
                double annualContribution = Double.parseDouble(annualContributionInput.getText());
                double expectedRateOfReturn = Double.parseDouble(rateOfReturnInput.getText()) / 100;
                int currentAge = Integer.parseInt(ageInput.getText());
                int retirementAge = Integer.parseInt(retirementAgeInput.getText());
                double marginalTaxRate = Double.parseDouble(taxRateInput.getText()) / 100;
                
                if (expectedRateOfReturn >.20) {
                    ResultLabel.setText("Rate of Return cannot exceed 20%");
                    rateOfReturnInput.requestFocus();
                    return;
            }
                if (marginalTaxRate > .37) {
                    ResultLabel.setText("Marginal tax rate cannot exceed 37%");
                    taxRateInput.requestFocus();
                    return;         
            }
                      if (retirementAge > 120){
                    ResultLabel.setText("Retirement Age cannot exceed 120");
                    retirementAgeInput.requestFocus();
                    return;
                }
                  if (currentBalance > 800000){
                    ResultLabel.setText("Current Balance must not exceed 8 Million");
                    retirementAgeInput.requestFocus();
                    return;
                }
                              
            if (maxContributionNo.isSelected()) {
                if (currentAge <= 50 && annualContribution > 7000) {
                    ResultLabel.setText("For age 50 or under, the maximum contribution is $7,000.");
                    return; // Exit the method to prevent further calculations
                } else if (currentAge > 50 && annualContribution > 8000) {
                    ResultLabel.setText("For age over 50, the maximum contribution is $8,000.");
                    return; // Exit the method to prevent further calculations
                }
            }
                
                if (currentAge < 18 || currentAge > 120) {
                ageError.setText("Age must be between 18 and 120.");
                ageInput.setText("");
                return; 
            } else {
                ageError.setText(""); 
            }
                if (maxContributionYes.isSelected()) {
                annualContribution = currentAge >= 50 ? 8000 : 7000; 
              //  annualContributionInput.setText(String.valueOf(annualContribution)); 
              //  annualContributionInput.setEnabled(true);
            }
            

                double afterTaxContribution = annualContribution * (1 - marginalTaxRate);
                int yearsToRetirement = retirementAge - currentAge;

                double futureValue = currentBalance * Math.pow(1 + expectedRateOfReturn, yearsToRetirement) + 
                                     afterTaxContribution * (((Math.pow(1 + expectedRateOfReturn, yearsToRetirement) - 1) / expectedRateOfReturn));
                double futureValueTraditional = currentBalance * Math.pow(1 + expectedRateOfReturn, yearsToRetirement) + 
                                                annualContribution * (((Math.pow(1 + expectedRateOfReturn, yearsToRetirement) - 1) / expectedRateOfReturn));

                double futureValueTraditionalAfterTax = futureValueTraditional * (1 - 0.25);
                double differenceInValue = futureValue - futureValueTraditionalAfterTax;
                differenceLabel.setText("With the given information, the Roth IRA account can accumulate " + String.format("%.2f", differenceInValue) + "more than a traditional IRA account");


                ResultLabel.setText("<html>" + "Roth IRA will have a balance of: $" + String.format("%.2f", futureValue) + ". Traditional IRA will have a balance of:" + String.format("%.2f", futureValueTraditionalAfterTax) + "</html>");
               
                
            }

    }//GEN-LAST:event_calculateButtonMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        currentBalanceInput.setText("");
        annualContributionInput.setText("");
        rateOfReturnInput.setText("");
        taxRateInput.setText("");
        differenceLabel.setText("");
        ResultLabel.setText("");
        ageInput.setText("");
        retirementAgeInput.setText("");
        annualContributionInput.setEnabled(true);
        buttonGroup1.clearSelection();
        maxContributionYes.setSelected(false);
        maxContributionNo.setSelected(true);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void maxContributionYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxContributionYesMouseClicked
        // TODO add your handling code here:
        if (ageInput.getText().isEmpty()){
       
        ageInput.setText("18");
    }
          int currentAge = Integer.parseInt(ageInput.getText());
          annualContributionInput.setEnabled(true);
    
    if (currentAge >= 50) {
        annualContributionInput.setText("8000");
        annualContributionInput.setEnabled(false);
    } else {
        annualContributionInput.setText("7000");
        annualContributionInput.setEnabled(false);
    }
    }//GEN-LAST:event_maxContributionYesMouseClicked

    private void maxContributionNoMouseClicked(java.awt.event.MouseEvent evt){
        if (ageInput.getText().isEmpty()){
            ageInput.setText("");
            return;
        }
        String contributionText = annualContributionInput.getText().trim();
        if (contributionText.isEmpty()){
            annualContributionInput.setText("");
            annualContributionInput.setEnabled(true);
            return;
            
        }
        try {
            double annualContribution = Double.parseDouble(contributionText);
            if (annualContribution == 8000){
                annualContributionInput.setText("");
                annualContributionInput.setEnabled(true);
            } else if (annualContribution == 7000){
                annualContributionInput.setText("");
                annualContributionInput.setEnabled(true);
                
            }
        } catch (NumberFormatException e){
            annualContributionInput.setText("");
            annualContributionInput.setEnabled(true);
        }
        
        
    }
    /*
    private void maxContributionNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxContributionNoMouseClicked
        // TODO add your handling code here:
           if (ageInput.getText().isEmpty()){
          ageInput.setText("");
    }
        double annualContribution = Double.parseDouble(annualContributionInput.getText());
        if (annualContribution == 8000){
            annualContributionInput.setText("");
            annualContributionInput.setEnabled(true);   
        }
        if (annualContribution == 7000){
            annualContributionInput.setText("");
            annualContributionInput.setEnabled(true);
        }
        else{
      
        }
    }//GEN-LAST:event_maxContributionNoMouseClicked
*/
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void rothInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rothInfoMouseEntered
        rothInfoPic.setVisible(true);
    }//GEN-LAST:event_rothInfoMouseEntered

    private void rothInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rothInfoMouseExited
        rothInfoPic.setVisible(false);
    }//GEN-LAST:event_rothInfoMouseExited

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
            java.util.logging.Logger.getLogger(rothIRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rothIRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rothIRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rothIRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rothIRA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ResultLabel;
    private javax.swing.JLabel ageError;
    private javax.swing.JTextField ageInput;
    private javax.swing.JTextField annualContributionInput;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField currentBalanceInput;
    private javax.swing.JLabel differenceLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel marginalTaxImg;
    private javax.swing.JRadioButton maxContributionNo;
    private javax.swing.JRadioButton maxContributionYes;
    private javax.swing.JTextField rateOfReturnInput;
    private javax.swing.JTextField retirementAgeInput;
    private javax.swing.JLabel rothInfo;
    private javax.swing.JLabel rothInfoPic;
    private javax.swing.JTextField taxRateInput;
    // End of variables declaration//GEN-END:variables
}
