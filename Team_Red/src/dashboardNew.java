import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        icon = new ImageIcon(new ImageIcon(dashboardNew.class.getResource("/images/Banner_(6).png"))
                .getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH));
        Image background = icon.getImage();
        dashboardNew panel = new dashboardNew(background);
        
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
