package colorcirclemvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Combines Model, View and Controllers.
 *
 */
public class ColorCircleMVC extends JFrame
{
    public ColorCircleMVC(ColorModel model, String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel total = new JPanel(new BorderLayout());
        JPanel circlePanel = new CircleView();
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0));
        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        
        redButton.setBackground(Color.RED);
        greenButton.setBackground(Color.GREEN);
        
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        
        total.add(circlePanel, BorderLayout.CENTER);
        total.add(buttonPanel, BorderLayout.SOUTH);
        add(total);
        
        Controller controller = new Controller(model);
        redButton.addActionListener(controller);
        greenButton.addActionListener(controller);
        
        model.addViewListener((ViewListener) circlePanel);
        
        setLocation(200, 200);
        setSize(150, 150);
        setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
        ColorModel model = new ColorModel();
        new ColorCircleMVC(model, "Test Frame with one model");
        new ColorCircleMVC(model, "Test Frame with the same model");
    }

}
