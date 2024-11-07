import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/* TODOS:
    Right Side btns
    Left side links
    Pop-ups for pages
*/

public class dashboardNew extends javax.swing.JPanel {
    private Image backgroundImage;
    public dashboardNew(Image img) {
        this.backgroundImage = img;
        setLayout(null);
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
            icon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/dashboard.png"))
                    .getImage().getScaledInstance(1550, 950, Image.SCALE_SMOOTH));
            //icon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/Banner_(6).png"))
            //        .getImage().getScaledInstance(1550, 950, Image.SCALE_SMOOTH));
            ImageIcon popupIcon = new ImageIcon("images/CapitalCal_Icon.png");
            Image background = icon.getImage();
            
            //Right-Side Panel Buttons:
            // 1) Loan
            ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton loanBtn = new JButton("Loan", loanIcon);
            loanBtn.setBounds(1231, 84, 215, 87);
            loanBtn.setBorderPainted(false);
            loanBtn.setPreferredSize(new Dimension(loanIcon.getIconWidth(), loanIcon.getIconHeight()));
            
            // 2) Retirement
            ImageIcon retirementIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/RetirementIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton retirementBtn = new JButton("Retirement", retirementIcon);
            retirementBtn.setBounds(1231, 254, 215, 87);
            retirementBtn.setBorderPainted(false);
            retirementBtn.setPreferredSize(new Dimension(retirementIcon.getIconWidth(), retirementIcon.getIconHeight()));
            
            // 3) Currency
            ImageIcon currencyIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/currencyIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton currencyBtn = new JButton("Currency", currencyIcon);
            currencyBtn.setBounds(1231, 424, 215, 97);
            currencyBtn.setBorderPainted(false);
            currencyBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            
            // 4) Mortgage
            ImageIcon mortgageIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/mortgageButtonIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton mortgageBtn = new JButton("Mortgage", mortgageIcon);
            mortgageBtn.setBounds(1231, 594, 215, 97);
            mortgageBtn.setBorderPainted(false);
            mortgageBtn.setPreferredSize(new Dimension(mortgageIcon.getIconWidth(), mortgageIcon.getIconHeight()));
            
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

            dashboardNew panel = new dashboardNew(background);
            panel.add(loanBtn);
            panel.add(retirementBtn);
            panel.add(currencyBtn);
            panel.add(mortgageBtn);

            //JLabel label = new JLabel("Hello on an Image!");
            //label.setBounds(50, 50, 200, 30); // Absolute positioning
            //JButton button = new JButton("Click Me");
            //button.setBounds(100, 100, 100, 30);
            //panel.add(label);
            //panel.add(button);

            JFrame frame = new JFrame("Image Background with Components");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(panel);
            frame.setVisible(true);
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
