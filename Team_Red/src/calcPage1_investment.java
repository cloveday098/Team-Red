
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
import javax.swing.SwingConstants;

public class calcPage1_investment extends javax.swing.JPanel {

    /**
     * Creates new form calcPage1_investment
     */
    public calcPage1_investment() {
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
        
        JLabel title1 = new JLabel("Investment Calculators");
        title1.setOpaque(true);
        title1.setBackground(new Color(66, 133, 244));
        title1.setForeground(Color.white);
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setFont(new Font("Arial", 1, 36));
        title1.setBounds(530, 150, 500, 50);
        
        try{
            //X Btn
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

            // 1) Interest
            ImageIcon interestIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/interestLogo.png"))
                    .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton interestBtn = new JButton("Interest", interestIcon);
            interestBtn.setBounds(650, 400, 215, 97);
            interestBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));
            
            this.add(logo1);
            this.add(logo2);
            this.add(jPanel3);
            this.add(title1);
            this.add(interestBtn);
            this.add(XBtn);
            
            JFrame frame = new JFrame("Investment Calculators");
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
            
            interestBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    interest2 interestPage = new interest2();
                    //interestPage.setSize(1650, 1800);
                    interestPage.setResizable(false);
                    interestPage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Interest calculator coming soon...", "Interest Calculator", JOptionPane.INFORMATION_MESSAGE);
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
                new calcPage1_investment().setVisible(true);
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
