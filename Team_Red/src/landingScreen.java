/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*
*/
package groupredproject;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author gabby
 */
public class landingScreen extends javax.swing.JFrame {

    /**
     * Creates new form landingScree
     */
  public landingScreen() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("CapitalCalcLogo.png")).getImage()));
        Image icon = new javax.swing.ImageIcon("CapitalCalcLogo.png").getImage();
        this.setIconImage(icon);
        this.getContentPane().setBackground(Color.decode("#172d13"));
        buttonPanel.setPreferredSize(new java.awt.Dimension(750, 400));
 

      

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        MortgagePanel = new javax.swing.JPanel();
        btnMortgage = new javax.swing.JButton();
        mortgageCalcLabel = new javax.swing.JLabel();
        downPaymentCalcLabel = new javax.swing.JLabel();
        LoansPanel = new javax.swing.JPanel();
        btnLoans = new javax.swing.JButton();
        autoLoanCalcLabel = new javax.swing.JLabel();
        InterestCalcLabel = new javax.swing.JLabel();
        RetirementPanel = new javax.swing.JPanel();
        btnRetirement = new javax.swing.JButton();
        retirementCalcLabel = new javax.swing.JLabel();
        rothIRACalcLabel = new javax.swing.JLabel();
        CurrencyPanel = new javax.swing.JPanel();
        btnCurrency = new javax.swing.JButton();
        currencyCalcLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jSeparator1 = new javax.swing.JSeparator();
        downPaymentCalcLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        popupMenu1.setLabel("Menu");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 200));

        buttonPanel.setBackground(new java.awt.Color(107, 183, 123));
        buttonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MortgagePanel.setBackground(new java.awt.Color(107, 183, 123));

        btnMortgage.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnMortgage.setForeground(new java.awt.Color(215, 87, 48));
        btnMortgage.setText("Mortgage ");
        btnMortgage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMortgage.setPreferredSize(new java.awt.Dimension(150, 75));

        mortgageCalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        mortgageCalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        mortgageCalcLabel.setText("Mortgage Calculator");
        mortgageCalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        downPaymentCalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        downPaymentCalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        downPaymentCalcLabel.setText("Down Payment Calculator");
        downPaymentCalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout MortgagePanelLayout = new javax.swing.GroupLayout(MortgagePanel);
        MortgagePanel.setLayout(MortgagePanelLayout);
        MortgagePanelLayout.setHorizontalGroup(
            MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MortgagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mortgageCalcLabel)
                    .addComponent(downPaymentCalcLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MortgagePanelLayout.createSequentialGroup()
                .addComponent(btnMortgage, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MortgagePanelLayout.setVerticalGroup(
            MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MortgagePanelLayout.createSequentialGroup()
                .addComponent(btnMortgage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mortgageCalcLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downPaymentCalcLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnMortgage.getAccessibleContext().setAccessibleName("btnMortgage");

        LoansPanel.setBackground(new java.awt.Color(107, 183, 123));

        btnLoans.setBackground(new java.awt.Color(215, 87, 48));
        btnLoans.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnLoans.setForeground(new java.awt.Color(255, 255, 255));
        btnLoans.setText("Loans");
        btnLoans.setPreferredSize(new java.awt.Dimension(150, 75));

        autoLoanCalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        autoLoanCalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        autoLoanCalcLabel.setText("Auto Loan Calculator");
        autoLoanCalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        InterestCalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        InterestCalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        InterestCalcLabel.setText("Interest Calculator");
        InterestCalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout LoansPanelLayout = new javax.swing.GroupLayout(LoansPanel);
        LoansPanel.setLayout(LoansPanelLayout);
        LoansPanelLayout.setHorizontalGroup(
            LoansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoansPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoansPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoansPanelLayout.createSequentialGroup()
                        .addGroup(LoansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(autoLoanCalcLabel)
                            .addComponent(InterestCalcLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        LoansPanelLayout.setVerticalGroup(
            LoansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoansPanelLayout.createSequentialGroup()
                .addComponent(btnLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autoLoanCalcLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InterestCalcLabel)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnLoans.getAccessibleContext().setAccessibleName("btnLoans");

        RetirementPanel.setBackground(new java.awt.Color(107, 183, 123));

        btnRetirement.setBackground(new java.awt.Color(215, 87, 48));
        btnRetirement.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnRetirement.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirement.setText("Retirement");
        btnRetirement.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRetirement.setPreferredSize(new java.awt.Dimension(150, 75));

        retirementCalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        retirementCalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        retirementCalcLabel.setText("Retirement Calculator");
        retirementCalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rothIRACalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        rothIRACalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        rothIRACalcLabel.setText("Roth IRA Calculator");
        rothIRACalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout RetirementPanelLayout = new javax.swing.GroupLayout(RetirementPanel);
        RetirementPanel.setLayout(RetirementPanelLayout);
        RetirementPanelLayout.setHorizontalGroup(
            RetirementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RetirementPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(RetirementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rothIRACalcLabel)
                    .addComponent(retirementCalcLabel)
                    .addComponent(btnRetirement, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        RetirementPanelLayout.setVerticalGroup(
            RetirementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RetirementPanelLayout.createSequentialGroup()
                .addComponent(btnRetirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retirementCalcLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rothIRACalcLabel)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        btnRetirement.getAccessibleContext().setAccessibleName("btnRetirement");

        CurrencyPanel.setBackground(new java.awt.Color(107, 183, 123));

        btnCurrency.setBackground(new java.awt.Color(215, 87, 48));
        btnCurrency.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnCurrency.setForeground(new java.awt.Color(255, 255, 255));
        btnCurrency.setText("Currency  ");
        btnCurrency.setPreferredSize(new java.awt.Dimension(150, 75));

        currencyCalcLabel.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        currencyCalcLabel.setForeground(new java.awt.Color(255, 255, 255));
        currencyCalcLabel.setText("Currency Calculator");
        currencyCalcLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout CurrencyPanelLayout = new javax.swing.GroupLayout(CurrencyPanel);
        CurrencyPanel.setLayout(CurrencyPanelLayout);
        CurrencyPanelLayout.setHorizontalGroup(
            CurrencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurrencyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CurrencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CurrencyPanelLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(CurrencyPanelLayout.createSequentialGroup()
                        .addComponent(currencyCalcLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CurrencyPanelLayout.setVerticalGroup(
            CurrencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurrencyPanelLayout.createSequentialGroup()
                .addGroup(CurrencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CurrencyPanelLayout.createSequentialGroup()
                        .addComponent(btnCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CurrencyPanelLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(currencyCalcLabel)
                .addGap(0, 58, Short.MAX_VALUE))
        );

        downPaymentCalcLabel1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        downPaymentCalcLabel1.setForeground(new java.awt.Color(255, 255, 255));
        downPaymentCalcLabel1.setText("Rent Affordability Calculator");
        downPaymentCalcLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downPaymentCalcLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downPaymentCalcLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RetirementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(downPaymentCalcLabel1))
                            .addComponent(MortgagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CurrencyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoansPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoansPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(MortgagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downPaymentCalcLabel1)))
                .addGap(39, 39, 39)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RetirementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(CurrencyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)))
                .addGap(118, 118, 118))
        );

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 50)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Your Finances");

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 50)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Predict and Protect ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 408, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downPaymentCalcLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downPaymentCalcLabel1MouseClicked
        // TODO add your handling code here:
      // new RentCalculator().setVisible(true);
    }//GEN-LAST:event_downPaymentCalcLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(landingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(landingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(landingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(landingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new landingScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CurrencyPanel;
    private javax.swing.JLabel InterestCalcLabel;
    private javax.swing.JPanel LoansPanel;
    private javax.swing.JPanel MortgagePanel;
    private javax.swing.JPanel RetirementPanel;
    private javax.swing.JLabel autoLoanCalcLabel;
    private javax.swing.JButton btnCurrency;
    private javax.swing.JButton btnLoans;
    private javax.swing.JButton btnMortgage;
    private javax.swing.JButton btnRetirement;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel currencyCalcLabel;
    private javax.swing.JLabel downPaymentCalcLabel;
    private javax.swing.JLabel downPaymentCalcLabel1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mortgageCalcLabel;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JLabel retirementCalcLabel;
    private javax.swing.JLabel rothIRACalcLabel;
    // End of variables declaration//GEN-END:variables
}