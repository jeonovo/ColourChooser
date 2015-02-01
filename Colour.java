import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Colour Chooser shows a colour based on the sliders controlling the RGB values.
 *
 * @author jonnybland
 * @version 1.0.0
 *
 */
public class Colour implements ChangeListener {
	
	// Instance variables for the colour values
	private int r, g, b; 
	
	// Creating the sliders  
	private JSlider red, blue, green;
	
	// Creating the sliders  
	private JPanel colourPanel, sliderPanel; 
	
	// Creating the labels for the sliders 
	private JTextField redText, blueText, greenText; 
	
	/**
	 * Move the sliders to change the RGB values of the colour. 
	 */
	public Colour() {
		
		JFrame frame = new JFrame("Colour Chooser"); 
		JPanel objectsPanel = new JPanel(new GridLayout(2,0));
		colourPanel = new JPanel(); 
		sliderPanel = new JPanel(new GridLayout(6,0));
		
		// Creating sliders
		red = new JSlider(JSlider.HORIZONTAL, 0, 255, 0); 
		green = new JSlider(JSlider.HORIZONTAL, 0, 255, 0); 
		blue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		
		// Setting slider background colours
		red.setBackground(new Color(0,0,0));
		green.setBackground(new Color(0,0,0));
		blue.setBackground(new Color(0,0,0));
		
		// Creating the slider labels, using textfields as they can change depending on listeners
		redText = new JTextField();
		blueText = new JTextField();
		greenText = new JTextField(); 
		
		// Sets the red slider text label
		redText.setBackground(new Color(0,0,0));
		redText.setEditable(false); 
		redText.setBorder(null); 
		redText.setHorizontalAlignment(JTextField.CENTER);
		
		// Sets the blue slider text label
		blueText.setBackground(new Color(0,0,0));
		blueText.setEditable(false); 
		blueText.setBorder(null);
		blueText.setHorizontalAlignment(JTextField.CENTER);
		
		// Sets the green slider text label
		greenText.setBackground(new Color(0,0,0));
		greenText.setEditable(false); 
		greenText.setBorder(null);
		greenText.setHorizontalAlignment(JTextField.CENTER);
		
		// Adding objects to the slider panel
		sliderPanel.add(redText);
		sliderPanel.add(red);
		sliderPanel.add(greenText);
		sliderPanel.add(green);
		sliderPanel.add(blueText);
		sliderPanel.add(blue);
		
		// Adding listeners to the sliders 
		red.addChangeListener(this);
		green.addChangeListener(this);
		blue.addChangeListener(this);
		
		
		// Starting colours for the two main panels 
		colourPanel.setBackground(new Color(0,0,0));
		sliderPanel.setBackground(new Color(0,0,0));
		
		// Adding the panels to the main panel
		objectsPanel.add(colourPanel);
		objectsPanel.add(sliderPanel); getClass();
		
		// Creating a container for the JFrame
		Container con = frame.getContentPane(); 
		con.add(objectsPanel);
		
		// Sets the characteristics of the frame; size, what to do on close and its visibility. 
		frame.setSize(300,300); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
			
	}
	
	/**
	 * Contains the methods to change to colour of the panels and text field colours
	 */
	public void colourChange() {
		
		// Sets the background colour of the sliders.
		red.setBackground(new Color(r,g,b));
		green.setBackground(new Color(r,g,b));
		blue.setBackground(new Color(r,g,b));
		
		// Sets the background colour of the textfields.
		redText.setBackground(new Color(r,g,b));
		greenText.setBackground(new Color(r,g,b));
		blueText.setBackground(new Color(r,g,b));
		
		// Sets the background colour of the panels.
		colourPanel.setBackground(new Color(r,g,b));
		sliderPanel.setBackground(new Color(r,g,b));
		
		// If the colour values are less than 200,200,200 the text is white, otherwise the text is black
		if (r < 200 && g < 200 && b < 200) {
			
			redText.setForeground(new Color(255,255,255));
			greenText.setForeground(new Color(255,255,255));
			blueText.setForeground(new Color(255,255,255));
			
		} else {
			
			redText.setForeground(new Color(0,0,0));
			greenText.setForeground(new Color(0,0,0));
			blueText.setForeground(new Color(0,0,0));
			
		}
	}
	/**
	 * State Change events for the sliders, changing the background colours based on their values. 
	 */
	public void stateChanged (ChangeEvent ce) {
		
		// Creating variable source to attribute 
		JSlider source = (JSlider) ce.getSource();
		
		if (ce.getSource() == red) {
			
			// red colour value equals the slider value
			r = source.getValue(); 
			
			// Creating a string of the slider value
			String number = ""  + r; 
			
			// Sets the slider label to the string value of the slider
			redText.setText(number); 
			
			// Call the colour change method
			colourChange(); 
			
		}
		
		if (ce.getSource() == green) {
			
			// green colour value equals the slider value
			g = source.getValue(); 
			
			// Creating a string of the slider value
			String number = ""  + g; 
			
			// Sets the slider label to the string value of the slider
			greenText.setText(number); 
			
			// Call the colour change method
			colourChange(); 
			
		}
		
		if (ce.getSource() == blue) {
			
			// blue colour value equals the slider value
			b = source.getValue(); 
			
			// Creating a string of the slider value
			String number = ""  + b; 
			
			// Sets the slider label to the string value of the slider
			blueText.setText(number); 
			
			// Call the colour change method
			colourChange(); 
			
		}
		
	}
	
	public static void main(String args[]) {
	
	new Colour(); 
	
	}

}
