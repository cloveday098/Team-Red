
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

public class calcPage1_investment extends javax.swing.JPanel {

    /**
     * Creates new form calcPage1_investment
     */
    public calcPage1_investment() {
        this.setLayout(null);
        
        JLabel title1 = new JLabel("Investment Calculators");
        title1.setForeground(Color.black);
        title1.setFont(new Font("Arial", 0, 24));
        title1.setBounds(350, 50, 400, 50);
        
        try{
            // 1) Interest
            //ImageIcon loanIcon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/loanButtonIcon.png"))
            //        .getImage().getScaledInstance(215, 87, Image.SCALE_SMOOTH));
            JButton interestBtn = new JButton("Interest");
            interestBtn.setBounds(350, 200, 215, 97);
            interestBtn.setBorderPainted(false);
            //autoLoanBtn.setPreferredSize(new Dimension(currencyIcon.getIconWidth(), currencyIcon.getIconHeight()));

            interestBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    interest2 interestPage = new interest2();
                    interestPage.setSize(600, 400);
                    interestPage.setResizable(false);
                    interestPage.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Interest calculator coming soon...", "Interest Calculator", JOptionPane.INFORMATION_MESSAGE);
                }        
            });
            
            this.add(title1);
            this.add(interestBtn);
            
            JFrame frame = new JFrame("Investment Calculators");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 750);
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
