package colorcirclemvc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * MVC - Project: View that displays a circle
 * implements ViewListener to update its color
 * based on the value in ColorModel.
 */

public class CircleView extends JPanel implements ViewListener
{
    private static final long serialVersionUID = 1L;
    private Color color;
    
    public CircleView()
    {
        color = Color.RED;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        int diameter = Math.min(getWidth(), getHeight()) - 6;
        g.fillOval(3, 3, diameter, diameter);
    }
    
    public void setColor(Color c)
    {
        color = c;
        repaint();
    }

    public void valueChanged(ColorModel model) 
    {
        setColor(model.getColor());
    }

}
