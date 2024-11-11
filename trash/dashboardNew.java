/**
 *
 * @author loved
 */
import javax.swing.*;
import java.awt.*;
public class dashboardNew extends JPanel {

    /**
     * Creates new form dashboardNew
     */
    private Image backgroundImage;
    public dashboardNew(Image image) {
        this.backgroundImage = image;
        setLayout(null);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    public void main(String[] args) {
        // Load image
        ImageIcon icon = new ImageIcon("images/dashboard.jpg");
        Image background = icon.getImage();
        
        dashboardNew panel = new dashboardNew(background);
        JLabel label = new JLabel("Hello on an Image!");
        label.setBounds(50, 50, 200, 30); // Absolute positioning

        JButton button = new JButton("Click Me");
        button.setBounds(100, 100, 100, 30); // Absolute positioning

        panel.add(label);
        panel.add(button);

        // Create a frame and add the panel to it
        JFrame frame = new JFrame("Image Background with Components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(panel);
        frame.setVisible(true);
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

