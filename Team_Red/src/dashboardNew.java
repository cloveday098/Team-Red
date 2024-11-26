import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/* TODOS:
    Right Side btns
    Left side links
    Pop-ups for pages
*/

public class dashboardNew extends javax.swing.JPanel {
    private Image backgroundImage;
    public dashboardNew(Image img) {
        this.backgroundImage = img;
        this.setLayout(null);
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    public static void main(String[] args) {
        ImageIcon icon = null;
        try {
            //icon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/dashboard.png"))
            //        .getImage().getScaledInstance(1550, 950, Image.SCALE_SMOOTH));
            icon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/dashboard_noSide.png"))
                    .getImage().getScaledInstance(1550, 950, Image.SCALE_SMOOTH));
            ImageIcon popupIcon = new ImageIcon("images/CapitalCal_Icon.png");
            Image background = icon.getImage();
            
            // X Btn
            JButton XBtn = new JButton();
            XBtn.setFont(new java.awt.Font("Segoe UI", 3, 12));
            XBtn.setForeground(new java.awt.Color(255,51,51));
            XBtn.setText("X");
            XBtn.setBounds(1590, 0, 43, 43);
            XBtn.setBorderPainted(false); 
            //XBtn.setContentAreaFilled(false); 
            XBtn.setFocusPainted(false);
            XBtn.setHorizontalAlignment(SwingConstants.CENTER);
            XBtn.setVerticalAlignment(SwingConstants.CENTER);
            
            //Right-Side Panel Buttons:
            // 1) Loan
            ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton loanBtn = new JButton("Loan", loanIcon);
            loanBtn.setBounds(1231, 84, 215, 87);
            loanBtn.setBorderPainted(false);
            loanBtn.setPreferredSize(new Dimension(loanIcon.getIconWidth(), loanIcon.getIconHeight()));
            loanBtn.setVisible(false);
            
            // 2) Retirement
            ImageIcon retirementIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/RetirementIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton retirementBtn = new JButton("Retirement", retirementIcon);
            retirementBtn.setBounds(1231, 254, 215, 87);
            retirementBtn.setBorderPainted(false);
            retirementBtn.setPreferredSize(new Dimension(retirementIcon.getIconWidth(), retirementIcon.getIconHeight()));
            retirementBtn.setVisible(false);
            
            // 3) Currency
            ImageIcon currencyIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/currencyIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton currencyBtn = new JButton("Currency", currencyIcon);
            currencyBtn.setBounds(1231, 424, 215, 97);
            currencyBtn.setBorderPainted(false);
            currencyBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            currencyBtn.setVisible(false);
            
            // 4) Mortgage
            ImageIcon mortgageIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/mortgageButtonIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton mortgageBtn = new JButton("Mortgage", mortgageIcon);
            mortgageBtn.setBounds(1231, 594, 215, 97);
            mortgageBtn.setBorderPainted(false);
            mortgageBtn.setPreferredSize(new Dimension(mortgageIcon.getIconWidth(), mortgageIcon.getIconHeight()));
            mortgageBtn.setVisible(false);
            
            
            // Action Listeners for Buttons
            loanBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Loan");
                    AutoLoanCalculator autoLoan = new AutoLoanCalculator();
                    autoLoan.setSize(1084, 750);
                    autoLoan.setResizable(false);
                    autoLoan.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This page is under construction...", "Loan Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }        
            });
            retirementBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Retirement");
                    JOptionPane.showMessageDialog(null, "This page is under construction...", "Retirement Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }        
            });
            currencyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Currency");
                    currency_calc currPage = new currency_calc();
                    currPage.setSize(600, 400);
                    currPage.setResizable(false);
                    currPage.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This page is under construction...", "Currency Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }        
            });
            mortgageBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Mortgage");
                    JOptionPane.showMessageDialog(null, "This page is under construction...", "Mortgage Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }        
            });


            // Labels for Left-Side Panel
            JLabel aboutLabel = new JLabel("About");
            aboutLabel.setForeground(Color.white);
            aboutLabel.setFont(new Font("Arial", 0, 18));
            aboutLabel.setBounds(40, 200, 200, 50);
            
            JLabel authorLabel = new JLabel("Author");
            authorLabel.setForeground(Color.white);
            authorLabel.setFont(new Font("Arial", 0, 18));
            authorLabel.setBounds(40, 240, 200, 50);
            
            JLabel resourcesLabel = new JLabel("Resources");
            resourcesLabel.setForeground(Color.white);
            resourcesLabel.setFont(new Font("Arial", 0, 18));
            resourcesLabel.setBounds(40, 280, 200, 50);
            
            
            JLabel investLabel = new JLabel("Investment");
            investLabel.setForeground(Color.white);
            investLabel.setFont(new Font("Arial", 0, 18));
            investLabel.setBounds(40, 400, 200, 50);
            
            JLabel mortgageLabel = new JLabel("Real Estate");
            mortgageLabel.setForeground(Color.white);
            mortgageLabel.setFont(new Font("Arial", 0, 18));
            mortgageLabel.setBounds(40, 460, 200, 50);
            
            JLabel retireLabel = new JLabel("Retirement");
            retireLabel.setForeground(Color.white);
            retireLabel.setFont(new Font("Arial", 0, 18));
            retireLabel.setBounds(40, 520, 200, 50);
            
            JLabel miscLabel = new JLabel("Misc. Calculators");
            miscLabel.setForeground(Color.white);
            miscLabel.setFont(new Font("Arial", 0, 18));
            miscLabel.setBounds(40, 580, 200, 50);
            
            
            aboutLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("About");
                    JOptionPane.showMessageDialog(null, "This page is under construction...", "About Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            authorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Authors");
                    JOptionPane.showMessageDialog(null, "This page is under construction...", "Authors Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            resourcesLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Resources");
                    JOptionPane.showMessageDialog(null, "This page is under construction...", "Resources Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            investLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Investment");
                    calcPage1_investment calc1 = new calcPage1_investment();
                    calc1.setSize(1650, 1800);
                    //calc1.setResizable(false);
                    calc1.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This page is under construction...", "Investment Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            mortgageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Real-Estate");
                    calcPage2_mortgage calc2 = new calcPage2_mortgage();
                    calc2.setSize(1650, 1800);
                    calc2.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This page is under construction...", "Real Estate Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            retireLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Retirement");
                    calcPage3_retirement calc3 = new calcPage3_retirement();
                    calc3.setSize(1650, 1800);
                    calc3.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This page is under construction...", "Retirement Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            miscLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Misc");
                    calcPage4_misc calc4 = new calcPage4_misc();
                    calc4.setSize(1650, 1800);
                    //calc4.setResizable(false);
                    calc4.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This page is under construction...", "Misc. Calculators Page", JOptionPane.INFORMATION_MESSAGE, popupIcon);
                }
            });
            
            dashboardNew panel = new dashboardNew(background);
            panel.add(loanBtn);
            panel.add(retirementBtn);
            panel.add(currencyBtn);
            panel.add(mortgageBtn);
            
            panel.add(aboutLabel);
            panel.add(authorLabel);
            panel.add(resourcesLabel);
            panel.add(investLabel);
            panel.add(mortgageLabel);
            panel.add(retireLabel);
            panel.add(miscLabel);
            panel.add(XBtn);
            
            
            //JLabel label = new JLabel("Hello on an Image!");
            //label.setBounds(50, 50, 200, 30); // Absolute positioning
            //JButton button = new JButton("Click Me");
            //button.setBounds(100, 100, 100, 30);
            //panel.add(label);
            //panel.add(button);

            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1650, 1800);
            frame.add(panel);
            frame.setVisible(true);
            
            XBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {                                  
                    frame.dispose();
                    //System.exit(1);
                }  
            });
        } catch (NullPointerException e) {
            System.out.println("Image not found! Please check the path: /images/Banner_(6).png");
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
