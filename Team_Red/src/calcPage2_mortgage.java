
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class calcPage2_mortgage extends javax.swing.JPanel {

    /**
     * Creates new form calcPage2_mortgage
     */
    public calcPage2_mortgage() {
        this.setLayout(null);
        
        JLabel title1 = new JLabel("Real-Estate Calculators");
        title1.setForeground(Color.black);
        title1.setFont(new Font("Arial", 0, 24));
        title1.setBounds(350, 50, 400, 50);
        
        try{
            // X Btn
            JButton XBtn = new JButton();
            XBtn.setFont(new java.awt.Font("Segoe UI", 3, 12));
            XBtn.setForeground(new java.awt.Color(255,51,51));
            XBtn.setText("X");
            XBtn.setBounds(1590, 0, 43, 43);
            XBtn.setBorderPainted(false);
            XBtn.setFocusPainted(false);
            XBtn.setHorizontalAlignment(SwingConstants.CENTER);
            XBtn.setVerticalAlignment(SwingConstants.CENTER);
            
            // 1) Down Payment
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton downPayBtn = new JButton("Down Payment");
            downPayBtn.setBounds(200, 200, 215, 97);
            downPayBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            downPayBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    DownPaymentCalculator dpPage = new DownPaymentCalculator();
                    dpPage.setSize(1650, 1800);
                    dpPage.setResizable(false);
                    dpPage.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Down Payment calculator coming soon...", "Down Payment Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            // 2) House Affordability
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton houseAffordBtn = new JButton("House Affordability");
            houseAffordBtn.setBounds(500, 200, 215, 97);
            houseAffordBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            houseAffordBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "House Affordability calculator coming soon...", "House Affordability Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            // 3) Mortgage
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton mortgageBtn = new JButton("Mortgage");
            mortgageBtn.setBounds(200, 350, 215, 97);
            mortgageBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            mortgageBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    mortgageCalc mortPage = new mortgageCalc();
                    mortPage.setSize(1650, 1800);
                    mortPage.setResizable(false);
                    mortPage.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Mortgage calculator coming soon...", "Mortgage Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            // 4) Mortgage Payoff
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton mortPayoffBtn = new JButton("Mortgage Payoff");
            mortPayoffBtn.setBounds(500, 350, 215, 97);
            mortPayoffBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            mortPayoffBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "Mortgage Payoff calculator coming soon...", "Mortgage Payoff Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            // 5) Refinance
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton refinanceBtn = new JButton("Refinance");
            refinanceBtn.setBounds(200, 500, 215, 97);
            refinanceBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            refinanceBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    refinanceCalc refinPage = new refinanceCalc();
                    refinPage.setSize(1650, 1800);
                    refinPage.setResizable(false);
                    refinPage.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Refinance calculator coming soon...", "Refinance Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            // 6) Rent
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton rentBtn = new JButton("Rent");
            rentBtn.setBounds(500, 500, 215, 97);
            rentBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            rentBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Rent Calc not recognized??
                    rentCalc rentPage = new rentCalc();
                    rentPage.setSize(675, 540);
                    rentPage.setResizable(false);
                    rentPage.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Rent calculator coming soon...", "Rent Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            // 7) Rent vs. Buy
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton rentBuyBtn = new JButton("Rent Vs. Buy");
            rentBuyBtn.setBounds(200, 650, 215, 97);
            rentBuyBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            rentBuyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "Rent vs. Buy calculator coming soon...", "Rent vs. Buy Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            this.add(title1);
            this.add(downPayBtn);
            this.add(houseAffordBtn);
            this.add(mortgageBtn);
            this.add(mortPayoffBtn);
            this.add(refinanceBtn);
            this.add(rentBtn);
            this.add(rentBuyBtn);
            this.add(XBtn);
            
            JFrame frame = new JFrame("Real-Estate Calculators");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1650, 1800);
            frame.add(this);
            frame.setVisible(true);
            
            XBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {                                  
                    frame.dispose();
                    //System.exit(1);
                }  
            });
        }
        catch (NullPointerException e) {
            System.out.println("Image not found! Please check the path!");
        }
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calcPage2_mortgage().setVisible(true);
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
