/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package team_red;

/**
 *
 * @author loved
 */
public class InterestCalc1 extends javax.swing.JFrame {

    /**
     * Creates new form InterestCalc1
     */
    public class interestCalc {
    public static double findCont(double initial, double interest, int years) {
        double interestRate = interest / 100;
        double e = Math.E;
        double finalAmt = initial * Math.pow(e, (interestRate * years));
        
        return finalAmt;
    }
    
    public static double findIntWithTax(double initial, double tax, double interest, double compound, int years, int months, double inflation, double annualContr, double monthlyContr) {
        double compoundRate = (double) (interest / 100);
        
        if (compound == Math.E) {
            double amt = findCont(initial, interest, years);
            return amt;
        }
        
        double taxRate = tax / 100;
        double contributionsPerYr = annualContr + (monthlyContr * 12);
        int totalDurationInYrs = years + (months /12);
        double totalContributions = contributionsPerYr * totalDurationInYrs;
        
        // find interest on totalContributions and add to final val?????
        double contributionsInt;
        if (contributionsPerYr != 0) {
            contributionsInt = (totalContributions) * Math.pow((1 + (compoundRate/compound)), ((totalDurationInYrs - 1) * compound));
            //System.out.print("interest on total contributions: " + contributionsInt + '\n');
        } else {
            contributionsInt = 0;
        }
        
        double totalInt = (initial) * Math.pow(1 + (compoundRate/compound), (totalDurationInYrs * compound));
        //double totalInt = (initial) * Math.pow(1 + (compoundRate/compound), (totalDurationInYrs * compound));
        double interestYrPrior = (initial) * Math.pow((1 + (compoundRate/compound)),((totalDurationInYrs - 1) * compound));
        //System.out.print("Interest for Year prior to LAST! = " + interestYrPrior + '\n');
        double interestForLastYr = totalInt - interestYrPrior;
        //System.out.print("Interest for Last YR After Tax = " + interestForLastYr + '\n');
        
        double interestForFirstYr = compoundRate * initial;
        //System.out.print("Interest for first After Tax = " + interestForFirstYr + '\n');
        double totalTaxBegin = taxRate * interestForFirstYr;
        double totalTaxEnd = taxRate * interestForLastYr;
        //System.out.print("Interest rate for Last year= " + totalTaxEnd + '\n');
 
        
        double diff = totalTaxEnd - totalTaxBegin;
        double changeInTax = diff / totalDurationInYrs; 
        tax = totalTaxBegin;
        
        totalInt += contributionsInt;
        
        //System.out.print("Ending Balance: " + totalInt +"\n");
        
       //if (inflation != 0) {
            //handleInflation(totalInt, inflation);  
        // }
        return totalInt;     
    }    

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InterestCalc1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterestCalc1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterestCalc1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterestCalc1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterestCalc1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
