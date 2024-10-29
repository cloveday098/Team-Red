package groupredproject;


import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gabby
 */
public class rentCalc extends javax.swing.JFrame {

    /**
     * Creates new form rentCalc
     */
    public rentCalc() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        jSlider1.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        rentCalculateButton.setEnabled(false);
        
        
        
                
        KeyAdapter positiveNumberKeyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                JTextField source = (JTextField) e.getSource();
                String currentText = source.getText();

                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // 
                } else if (c == '.' && currentText.contains(".")) {
                    e.consume(); 
                } else if (currentText.isEmpty() && c == '0' && source == incomeInput) {
                    e.consume(); 
                }
            }
        };
        incomeInput.addKeyListener(positiveNumberKeyAdapter);
        debtInput.addKeyListener(positiveNumberKeyAdapter);                
        

    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        taxLabel = new javax.swing.JLabel();
        debtLabel = new javax.swing.JLabel();
        incomeInput = new javax.swing.JTextField();
        debtInput = new javax.swing.JTextField();
        rentCalculateButton = new javax.swing.JButton();
        yearlyMonthlyInput = new javax.swing.JComboBox<>();
        affordLabel = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        titleLabel.setText("Rent Calculator");

        taxLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        taxLabel.setForeground(new java.awt.Color(51, 51, 51));
        taxLabel.setText("Pre-tax income");

        debtLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        debtLabel.setForeground(new java.awt.Color(51, 51, 51));
        debtLabel.setText("Monthly debt payback");
        debtLabel.setToolTipText("");

        debtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debtInputActionPerformed(evt);
            }
        });

        rentCalculateButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rentCalculateButton.setText("Calculate");
        rentCalculateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rentCalculateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentCalculateButtonMouseClicked(evt);
            }
        });

        yearlyMonthlyInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        yearlyMonthlyInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yearly", "Monthly" }));
        yearlyMonthlyInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        affordLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        affordLabel.setText("What Can You Afford?");

        resultLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(62, 142, 224));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Comfortable");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(62, 142, 224));
        jLabel2.setText("Aggressive");

        jSlider1.setBackground(new java.awt.Color(255, 255, 255));
        jSlider1.setForeground(new java.awt.Color(62, 142, 224));
        jSlider1.setPaintTicks(true);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Rent should try to be kept less than 35% of your monthly income ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(affordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 3, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(debtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(debtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rentCalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(137, 137, 137))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(taxLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(incomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(yearlyMonthlyInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(18, 18, Short.MAX_VALUE)))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(affordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(taxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(incomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearlyMonthlyInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(debtLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(debtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rentCalculateButton)
                .addGap(46, 46, 46)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   

    private void rentCalculateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentCalculateButtonMouseClicked
        // TODO add your handling code here:
        
        double income = Double.parseDouble(incomeInput.getText());
        double debt = Double.parseDouble(debtInput.getText());
        String incomeChoice = (String) yearlyMonthlyInput.getSelectedItem();
        jSlider1.setVisible(true);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        
        
        double monthlyIncome;
        if ("Yearly".equals(incomeChoice)){
            monthlyIncome = income /12;
        } else {
            monthlyIncome = income;
        }
        double debtMonthlyIncome = monthlyIncome - debt;
        int defaultPercentage = 35;
        jSlider1.setValue(defaultPercentage);
        double comfyRent = debtMonthlyIncome * .33;
        double maxRent = debtMonthlyIncome * .35;
        double rentAtDefaultPercentage = debtMonthlyIncome * (defaultPercentage / 100.0);
        resultLabel.setText("Comfortable rent: $" + String.format("%.2f", comfyRent) + ", Maximum Rent: $" + String.format("%.2f", maxRent));
        
    }//GEN-LAST:event_rentCalculateButtonMouseClicked

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        double income = Double.parseDouble(incomeInput.getText());
        double debt = Double.parseDouble(debtInput.getText());
        String incomeChoice = (String) yearlyMonthlyInput.getSelectedItem();

        double monthlyIncome;
        if ("Yearly".equals(incomeChoice)){
            monthlyIncome = income /12;
        } else {
            monthlyIncome = income;
        }
        
        double debtMonthlyIncome = monthlyIncome - debt;
        int sliderPercentage = jSlider1.getValue();
        double rentAtSliderPercentage = debtMonthlyIncome * (sliderPercentage / 100.00);
        resultLabel.setText("Rent at " + sliderPercentage + "%: $" + String.format("%.2f", rentAtSliderPercentage));

        
        
    }//GEN-LAST:event_jSlider1StateChanged

    private void debtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_debtInputActionPerformed

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
            java.util.logging.Logger.getLogger(rentCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rentCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rentCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rentCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rentCalc().setVisible(true);
            }
        });
    }
   


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel affordLabel;
    private javax.swing.JTextField debtInput;
    private javax.swing.JLabel debtLabel;
    private javax.swing.JTextField incomeInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton rentCalculateButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> yearlyMonthlyInput;
    // End of variables declaration//GEN-END:variables
}
