import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Area;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;  
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 5678m
 */
public class PanelRound extends JPanel{
    
    public int getRoundTopLeft(){
        return roundTopLeft;
    }
    
    public void setRoundTopLeft(int roundTopLeft){
        this.roundTopLeft = roundTopLeft;
        repaint();
    }
    
    public int getRoundTopRight(){
        return roundTopRight;
    }
    
    public void setRoundTopRight(int roundTopRight){
        this.roundTopRight = roundTopRight;
        repaint();
    }
    
    public int getRoundButtomLeft(){
        return roundBottomLeft;
    }
    
    public void setRoundButtomLeft(int roundButtomLeft){
        this.roundBottomLeft = roundButtomLeft;
        repaint();
    }
    
    public int getRoundButtomRight(){
        return roundBottomRight;
    }
    
    public void setRoundButtomRight(int roundButtomRight){
        this.roundBottomRight = roundButtomRight;
        repaint();
    }
    
    
    private int roundTopLeft = 0;
    int roundTopRight = 0;
    int roundBottomLeft = 0;
    int roundBottomRight = 0;
    
    public PanelRound(){
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g){
         Graphics2D g2 = (Graphics2D) g.create();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         //g2.setColor(new Color(66,133,244,40));
         g2.setColor(getBackground());
         Area area = new Area(createRoundTopLeft());
         if(roundTopRight >0){
             area.intersect(new Area(createRoundTopRight()));
         }
         if(roundBottomLeft >0){
             area.intersect(new Area(createRoundBottomLeft()));
         }
         if(roundBottomRight >0){
             area.intersect(new Area(createRoundBottomRight()));
         }
         g2.fill(area);
         g2.dispose();
         super.paintComponent(g);
    }
    
    private Shape createRoundTopLeft(){
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX/2, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, width, height-roundY/2)));
        return area;
    }
    
    private Shape createRoundTopRight(){
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, width, height-roundY/2)));
        return area;
    }
    
    private Shape createRoundBottomLeft(){
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundY/2, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0,0, width, height-roundY/2)));
        return area;
    }
    
    private Shape createRoundBottomRight(){
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0,0, width, height-roundY/2)));
        return area;
    }
  
    
}
