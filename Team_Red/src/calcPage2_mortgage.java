
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
        this.setBackground(Color.white);
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(new java.awt.Color(66, 133, 244));
        jPanel3.setBounds(0, 0, 1650, 100);
        
        JLabel logo1 = new JLabel();
        logo1.setBackground(new java.awt.Color(66, 133, 244));
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CapitalLogo.png")));
        logo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 133, 244)));
        logo1.setBounds(0, 5, 180, 87);
        
        JLabel logo2 = new JLabel("Capital Calc");
        logo2.setBackground(new java.awt.Color(66, 133, 244));
        logo2.setForeground(Color.white);
        logo2.setFont(new Font("Arial", 0, 36));
        logo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 133, 244)));
        logo2.setBounds(200, 5, 300, 87);
        
        JLabel title2 = new JLabel("Real-Estate Calculators");
        title2.setOpaque(true);
        title2.setBackground(new Color(66, 133, 244));
        title2.setForeground(Color.white);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setFont(new Font("Arial", 1, 36));
        title2.setBounds(530, 150, 500, 50);
        
        try{
            // X Btn
            JButton XBtn = new JButton();
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
            
            // 1) Down Payment
            ImageIcon downPayIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/downPayLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton downPayBtn = new JButton("Down Payment", downPayIcon);
            downPayBtn.setBounds(400, 300, 215, 97);
            downPayBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 2) House Affordability
            ImageIcon houseAffIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/houseAffLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton houseAffordBtn = new JButton("House Affordability", houseAffIcon);
            houseAffordBtn.setBounds(900, 300, 215, 97);
            houseAffordBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 3) Mortgage
            ImageIcon mortgageIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/mortgageLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton mortgageBtn = new JButton("Mortgage", mortgageIcon);
            mortgageBtn.setBounds(400, 450, 215, 97);
            mortgageBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            
            // 4) Mortgage Payoff
            ImageIcon mortPayIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/mortgagePayoffLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton mortPayoffBtn = new JButton("Mortgage Payoff", mortPayIcon);
            mortPayoffBtn.setBounds(900, 450, 215, 97);
            mortPayoffBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 5) Refinance
            ImageIcon refinanceIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/refinanceLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton refinanceBtn = new JButton("Refinance", refinanceIcon);
            refinanceBtn.setBounds(400, 600, 215, 97);
            refinanceBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 6) Rent
            ImageIcon rentIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/rentLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton rentBtn = new JButton("Rent", rentIcon);
            rentBtn.setBounds(900, 600, 215, 97);
            rentBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 7) Rent vs. Buy
            ImageIcon rbIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/rent_v_buyLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton rentBuyBtn = new JButton("Rent Vs. Buy", rbIcon);
            rentBuyBtn.setBounds(400, 750, 215, 97);
            rentBuyBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            rentBuyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "Rent vs. Buy calculator coming soon...", "Rent vs. Buy Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            this.add(logo1);
            this.add(logo2);
            this.add(jPanel3);
            this.add(title2);
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
            
            logo1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    frame.dispose();
                }
            });
            logo2.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    frame.dispose();
                }
            });
            
            downPayBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    DownPaymentCalculator dpPage = new DownPaymentCalculator();
                    //dpPage.setSize(1109, 749);
                    dpPage.setResizable(false);
                    dpPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Down Payment calculator coming soon...", "Down Payment Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            houseAffordBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    HouseAffordabilityCalculator houseaffPage = new HouseAffordabilityCalculator();
                    houseaffPage.setResizable(false);
                    houseaffPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "House Affordability calculator coming soon...", "House Affordability Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            mortgageBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    mortgageCalc mortPage = new mortgageCalc();
                    mortPage.setSize(1650, 1800);
                    mortPage.setResizable(false);
                    mortPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Mortgage calculator coming soon...", "Mortgage Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            mortPayoffBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    mortgagePayoffCalculator mortPayPage = new mortgagePayoffCalculator();
                    mortPayPage.setSize(1650, 1800);
                    mortPayPage.setResizable(false);
                    mortPayPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Mortgage Payoff calculator coming soon...", "Mortgage Payoff Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            refinanceBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    refinanceCalc refinPage = new refinanceCalc();
                    refinPage.setSize(1650, 1800);
                    refinPage.setResizable(false);
                    refinPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Refinance calculator coming soon...", "Refinance Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            rentBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Rent Calc not recognized??
                    rentCalc rentPage = new rentCalc();
                    rentPage.setSize(675, 540);
                    rentPage.setResizable(false);
                    rentPage.setVisible(true);
                    //frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Rent calculator coming soon...", "Rent Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
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
