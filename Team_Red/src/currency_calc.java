/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.Image;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author loved
 */

// TODOS:
/*
    Popular currencies
    Flags?
*/


public class currency_calc extends javax.swing.JFrame {

    /**
     * Creates new form currency_calc
     */
    Map<String, Double> conversionTable = Helper.webScraper();
    Map<String, Double> populars = new HashMap<>();
    DefaultComboBoxModel<String> popComboModel = new DefaultComboBoxModel <String>();
    DefaultComboBoxModel<String> comboModel1 = new DefaultComboBoxModel <String>();
    DefaultComboBoxModel<String> comboModel2 = new DefaultComboBoxModel <String>();
    Map<String, String> images = new HashMap<>();
    
    public currency_calc() {
        initComponents();
        curr1.setText("");
        curr2.setText("");
        
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
        images.put("Argentine Peso", "Argetina.gif");
        images.put("Australian Dollar", "Australia.gif");
        images.put("Brazilian Real", "Brazil.gif");
        images.put("Canadian Dollar", "Canada.gif");
        images.put("Chilean Pes", "Chile.gif");
        images.put("Hong Kong Dollar", "Hong Kong.gif");
        images.put("Hungarian Forint", "Hungary.gif");
        images.put("Mexican Peso", "Mexcio.gif");
        images.put("New Zealand Dollar", "New Zealand.gif");
        images.put("Norwegian Krone", "Norway.gif");
        images.put("Russian Ruble", "Russia.gif");
        images.put("Saudi Arabian Riyal", "Saudi Arabia .gif");
        images.put("\"Singapore Dollar\"", "Singapore.gif");
        images.put("South African Randt", "South Africa gif");
        images.put("Swedish Krona", "Sweden.gif");
        images.put("Swiss Franc", "Switzerland.gif");
        
        
        images.put("US Dollar", "America.gif");
        
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
        errLabel = new javax.swing.JLabel();
        flip = new javax.swing.JButton();
        newCurrAmt = new javax.swing.JTextField();
        fromFlag = new javax.swing.JLabel();
        toFlag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        curr1 = new javax.swing.JLabel();
        curr2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(550, 375));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oldCurrDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        oldCurrDrop.setName(""); // NOI18N
        oldCurrDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCurrDropActionPerformed(evt);
            }
        });
        getContentPane().add(oldCurrDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, -1));

        newCurrDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        newCurrDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCurrDropActionPerformed(evt);
            }
        });
        getContentPane().add(newCurrDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 130, -1));

        oldCurrAmt.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        oldCurrAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCurrAmtActionPerformed(evt);
            }
        });
        getContentPane().add(oldCurrAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 49));

        errLabel.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        errLabel.setForeground(new java.awt.Color(255, 51, 51));
        errLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errLabel.setText("N/A");
        errLabel.setAlignmentX(0.5F);
        getContentPane().add(errLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 180, 140, 40));

        flip.setBackground(new java.awt.Color(0, 102, 255));
        flip.setForeground(new java.awt.Color(255, 255, 255));
        flip.setText("<-->");
        flip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flipMouseClicked(evt);
            }
        });
        getContentPane().add(flip, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        newCurrAmt.setEditable(false);
        newCurrAmt.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(newCurrAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 130, 49));
        getContentPane().add(fromFlag, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 70));
        getContentPane().add(toFlag, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 120, 70));

        jLabel1.setText("From");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel2.setText("To");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        curr1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        curr1.setText("Currency1");
        getContentPane().add(curr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        curr2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        curr2.setText("Currency2");
        getContentPane().add(curr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jCheckBox1.setText("Popular currencies only");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oldCurrDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCurrDropActionPerformed
        currencyValidate(oldCurrDrop.getSelectedItem(), newCurrDrop.getSelectedItem(), oldCurrAmt.getText());
    }//GEN-LAST:event_oldCurrDropActionPerformed

    private void newCurrDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCurrDropActionPerformed
        currencyValidate(oldCurrDrop.getSelectedItem(), newCurrDrop.getSelectedItem(), oldCurrAmt.getText());
    }//GEN-LAST:event_newCurrDropActionPerformed

    private void oldCurrAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCurrAmtActionPerformed
        currencyValidate(oldCurrDrop.getSelectedItem(), newCurrDrop.getSelectedItem(), oldCurrAmt.getText());
    }//GEN-LAST:event_oldCurrAmtActionPerformed

    private void flipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flipMouseClicked
        Object oldCurr = oldCurrDrop.getSelectedItem();
        Object newCurr = newCurrDrop.getSelectedItem();
        oldCurrDrop.setSelectedItem(newCurr);
        newCurrDrop.setSelectedItem(oldCurr);
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

    /**
     * @param oldCurr
     * @param newCurr
     * @param oldAmt
     * @param args the command line arguments
     * @return 
     */
    
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
                else if (Helper.isValidNumber(oldAmt)) {
                    System.out.println("Good to go!");
                    //fromFlag.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/" + images.get(String.valueOf(oldCurr)))).getImage().getScaledInstance(120,70, Image.SCALE_SMOOTH)));
                    //toFlag.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/" + images.get(String.valueOf(newCurr)))).getImage().getScaledInstance(120,70, Image.SCALE_SMOOTH)));
                    newAmt = convert(oldCurr, newCurr, oldAmt);   
                }
                else {
                    throw new NumberFormatException("Not a Valid Number");
                }
                // Formatting to 5 decimal places like seen on the online calculator
                
                String result = Helper.getSymbol(newCurr, newAmt);
                newCurrAmt.setText(result);
                String initial = Helper.getSymbol(oldCurr, Double.valueOf(oldAmt));
                oldCurrAmt.setText(initial);
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
    private javax.swing.JLabel curr1;
    private javax.swing.JLabel curr2;
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
    // End of variables declaration//GEN-END:variables
}
