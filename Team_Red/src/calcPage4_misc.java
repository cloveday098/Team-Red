
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class calcPage4_misc extends javax.swing.JPanel {

    public calcPage4_misc() {
        
    }
    public static void main(String[] args) {
        try{
            // 1) Auto Loan
            //ImageIcon currencyIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/currencyIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton autoLoanBtn = new JButton("Auto Loan");
            autoLoanBtn.setBounds(200, 200, 215, 97);
            autoLoanBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            // 2) Currency
            ImageIcon currencyIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/currencyIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton currencyBtn = new JButton("Currency", currencyIcon);
            currencyBtn.setBounds(200, 400, 215, 97);
            currencyBtn.setBorderPainted(false);
            currencyBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            
            autoLoanBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    AutoLoanCalculator autoLoan = new AutoLoanCalculator();
                    autoLoan.setSize(1084, 750);
                    autoLoan.setResizable(false);
                    autoLoan.setVisible(true);
                }        
            });
            currencyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    currency_calc currPage = new currency_calc();
                    currPage.setSize(600, 400);
                    currPage.setResizable(false);
                    currPage.setVisible(true);
                }        
            });
            
            
            calcPage4_misc panel = new calcPage4_misc();
            panel.add(autoLoanBtn);
            panel.add(currencyBtn);
            
            JFrame frame = new JFrame("Misc. Calculators");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(panel);
            frame.setVisible(true);
        }
        catch (NullPointerException e) {
            System.out.println("Image not found! Please check the path!");
        }
        
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
