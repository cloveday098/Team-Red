
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

public class calcPage3_retirement extends javax.swing.JPanel {

    /**
     * Creates new form calcPage3_retirement
     */
    public calcPage3_retirement() {
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
        
        JLabel title3 = new JLabel("Retirement Calculators");
        title3.setOpaque(true);
        title3.setBackground(new Color(66, 133, 244));
        title3.setForeground(Color.white);
        title3.setHorizontalAlignment(SwingConstants.CENTER);
        title3.setFont(new Font("Arial", 1, 36));
        title3.setBounds(530, 150, 500, 50);
        
        try{
            // 1) Retirement
            ImageIcon retireIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/RetirementIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton retireBtn = new JButton("Retirement", retireIcon);
            retireBtn.setBounds(400, 300, 215, 97);
            retireBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 2) Roth IRA
            ImageIcon rothIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/RothIcon.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton rothBtn = new JButton("Roth IRA", rothIcon);
            rothBtn.setBounds(900, 300, 215, 97);
            rothBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

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
            
            this.add(logo1);
            this.add(logo2);
            this.add(jPanel3);
            this.add(title3);
            this.add(retireBtn);
            this.add(rothBtn);
            this.add(XBtn);
            
            JFrame frame = new JFrame("Retirement Calculators");
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
            
            retireBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    retirementCalForm retirePage = new retirementCalForm();
                    //retirePage.setSize(847, 720);
                    retirePage.setResizable(false);
                    retirePage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Retirement calculator coming soon...", "Retirement Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            rothBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    rothIRA_new rothPage = new rothIRA_new();
                    rothPage.setSize(1650, 1800);
                    rothPage.setResizable(false);
                    rothPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Roth IRA calculator coming soon...", "Roth IRA Calculator", JOptionPane.INFORMATION_MESSAGE);
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
                new calcPage3_retirement().setVisible(true);
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
