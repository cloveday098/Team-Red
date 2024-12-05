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
           
            
            //Right-Side Panel Buttons:
            // 1) Auto Loan
            ImageIcon autoIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/autoLoanButton.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton autoLoanBtn = new JButton("Auto Loan", autoIcon);
            autoLoanBtn.setBounds(1400, 200, 215, 97);
            autoLoanBtn.setBorderPainted(false);
            autoLoanBtn.setPreferredSize(new Dimension(autoIcon.getIconWidth(), autoIcon.getIconHeight()));

            // 2) Currency
            ImageIcon currencyIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/currencyIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton currencyBtn = new JButton("Currency", currencyIcon);
            currencyBtn.setBounds(1400, 500, 215, 97);
            currencyBtn.setBorderPainted(false);
            currencyBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            

            // Labels for Left-Side Panel
            JLabel aboutLabel = new JLabel("About");
            aboutLabel.setForeground(Color.white);
            aboutLabel.setFont(new Font("Arial", 0, 18));
            aboutLabel.setBounds(40, 200, 200, 50);
            aboutLabel.setVisible(false);
            
            JLabel authorLabel = new JLabel("Author");
            authorLabel.setForeground(Color.white);
            authorLabel.setFont(new Font("Arial", 0, 18));
            authorLabel.setBounds(40, 240, 200, 50);
            authorLabel.setVisible(false);
            
            JLabel resourcesLabel = new JLabel("Resources");
            resourcesLabel.setForeground(Color.white);
            resourcesLabel.setFont(new Font("Arial", 0, 18));
            resourcesLabel.setBounds(40, 280, 200, 50);
            resourcesLabel.setVisible(false);
            
            
            JLabel investLabel = new JLabel("Investment");
            investLabel.setForeground(Color.white);
            investLabel.setFont(new Font("Arial", 0, 18));
            investLabel.setBounds(40, 250, 200, 50);
            
            JLabel mortgageLabel = new JLabel("Real Estate");
            mortgageLabel.setForeground(Color.white);
            mortgageLabel.setFont(new Font("Arial", 0, 18));
            mortgageLabel.setBounds(40, 350, 200, 50);
            
            JLabel retireLabel = new JLabel("Retirement");
            retireLabel.setForeground(Color.white);
            retireLabel.setFont(new Font("Arial", 0, 18));
            retireLabel.setBounds(40, 450, 200, 50);
            
            JLabel miscLabel = new JLabel("Misc. Calculators");
            miscLabel.setForeground(Color.white);
            miscLabel.setFont(new Font("Arial", 0, 18));
            miscLabel.setBounds(40, 550, 200, 50);
            
            
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
            panel.add(autoLoanBtn);
            panel.add(currencyBtn);
            
            panel.add(aboutLabel);
            panel.add(authorLabel);
            panel.add(resourcesLabel);
            panel.add(investLabel);
            panel.add(mortgageLabel);
            panel.add(retireLabel);
            panel.add(miscLabel);
            
            
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
            
            autoLoanBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    AutoLoanCalculator autoLoan = new AutoLoanCalculator();
                    autoLoan.setSize(1200, 800);
                    autoLoan.setResizable(false);
                    autoLoan.setVisible(true);
                    frame.dispose();
                }        
            });
            currencyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    currency_calc currPage = new currency_calc();
                    currPage.setSize(1650, 1800);
                    currPage.setResizable(false);
                    currPage.setVisible(true);
                    frame.dispose();
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
