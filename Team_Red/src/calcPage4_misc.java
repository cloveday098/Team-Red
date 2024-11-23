
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class calcPage4_misc extends javax.swing.JPanel {

    public calcPage4_misc() {
        this.setLayout(null);
        
        JLabel title4 = new JLabel("Miscellaneous Calculators");
        title4.setForeground(Color.black);
        title4.setFont(new Font("Arial", 0, 24));
        title4.setBounds(350, 50, 400, 50);
        
        try{
            // 1) Auto Loan
            ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton autoLoanBtn = new JButton("Auto Loan");
            autoLoanBtn.setBounds(200, 200, 215, 97);
            autoLoanBtn.setBorderPainted(false);
            autoLoanBtn.setPreferredSize(new Dimension(loanIcon.getIconWidth(), loanIcon.getIconHeight()));

            // 2) Currency
            ImageIcon currencyIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/currencyIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton currencyBtn = new JButton("Currency", currencyIcon);
            currencyBtn.setBounds(500, 200, 215, 97);
            currencyBtn.setBorderPainted(false);
            currencyBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            
            autoLoanBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    AutoLoanCalculator autoLoan = new AutoLoanCalculator();
                    autoLoan.setSize(1200, 800);
                    autoLoan.setResizable(false);
                    autoLoan.setVisible(true);
                }        
            });
            currencyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    currency_calc currPage = new currency_calc();
                    currPage.setSize(1200, 800);
                    currPage.setResizable(false);
                    currPage.setVisible(true);
                }        
            });
            
            this.add(title4);
            this.add(autoLoanBtn);
            this.add(currencyBtn);
            
            JFrame frame = new JFrame("Misc. Calculators");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2880, 1800);
            frame.add(this);
            frame.setVisible(true);
        }
        catch (NullPointerException e) {
            System.out.println("Image not found! Please check the path!");
        }
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calcPage4_misc().setVisible(true);
            }
        });
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
