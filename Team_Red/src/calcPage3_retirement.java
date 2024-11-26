
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        JLabel title1 = new JLabel("Retirement Calculators");
        title1.setForeground(Color.black);
        title1.setFont(new Font("Arial", 0, 24));
        title1.setBounds(350, 50, 400, 50);
        
        try{
            // 1) Retirement
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton retireBtn = new JButton("Retirement");
            retireBtn.setBounds(200, 200, 215, 97);
            retireBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            
            // 2) Roth IRA
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton rothBtn = new JButton("Roth IRA");
            rothBtn.setBounds(500, 200, 215, 97);
            rothBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            JButton XBtn = new JButton();
            XBtn.setFont(new java.awt.Font("Segoe UI", 3, 12));
            XBtn.setForeground(new java.awt.Color(255,51,51));
            XBtn.setText("X");
            XBtn.setBounds(1590, 0, 43, 43);
            XBtn.setBorderPainted(false);
            XBtn.setFocusPainted(false);
            XBtn.setHorizontalAlignment(SwingConstants.CENTER);
            XBtn.setVerticalAlignment(SwingConstants.CENTER);
            
            this.add(title1);
            this.add(retireBtn);
            this.add(rothBtn);
            this.add(XBtn);
            
            JFrame frame = new JFrame("Retirement Calculators");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1650, 1800);
            frame.add(this);
            frame.setVisible(true);
            
            retireBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    retirementCalForm retirePage = new retirementCalForm();
                    retirePage.setSize(847, 720);
                    retirePage.setResizable(false);
                    retirePage.setVisible(true);
                    frame.dispose();
                    //JOptionPane.showMessageDialog(null, "Retirement calculator coming soon...", "Retirement Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            rothBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    rothIRA rothPage = new rothIRA();
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
