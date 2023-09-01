
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TemperatureGui {
	
	public static void openFrame() {
		//--------GUI Set Up -------
		JFrame f = new JFrame();					//Creates the Frame
		f.setSize(1100, 600);	
		f.setLayout(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel result = new JLabel();						//Label 1 - ºF-ºC Output 
		result.setBounds(300, 250, 400,50);
		
		JLabel result2 = new JLabel();						//Label 2 - ºC->ºF Output
		result2.setBounds(600, 250, 400,50);
	

		JLabel l = new JLabel("Enter Temp in ºC...");		
		l.setBounds(300, 100, 200 ,50 );
		f.add(l);
		
		JLabel l2 = new JLabel("Enter Temp in ºF...");	
		l2.setBounds(600, 100, 200 ,50 );
		f.add(l2);
		
		JTextField tf = new JTextField();					//TextField 1 - Input.
		tf.setBounds(300, 150, 200, 50);	
		f.add(tf);
		
		JTextField tf2 = new JTextField();				//TextField 2 - Input.
		tf2.setBounds(600, 150, 200, 50);
		f.add(tf2);
	
		
		//--------Buttons-------
		JButton b = new JButton("Convert to ºF");	//Button 1 - Converter
		b.setBounds(300, 200, 200, 50);
		f.add(b);
		
		
		JButton b2 = new JButton("Convert to ºC");	//Button 2 - converter
		b2.setBounds(600, 200, 200, 50);
		f.add(b2);
		
		JButton resetButton = new JButton("Reset");	//Button 3 - Reset
		resetButton.setBounds(450, 300, 200, 50);
		f.add(resetButton);
		
		
		////--------Button Actions-------
		b.addActionListener(new ActionListener() {						//Converter Button Action		
			
			public void actionPerformed(ActionEvent e) {			
				try {
						String tempInString = tf.getText();
						float tempInFloat = Float.parseFloat(tempInString);
						float tempInFar = (tempInFloat *9/5) +32;  
					
						System.out.println("Temperature in " + tempInFloat);
						f.add(result); 
					
						result.setText(tempInFloat + "ºC in Fahrenheit is "+  String.valueOf(tempInFar) + "ºF");	
						
				} catch(NumberFormatException f) {
					System.out.println("No Temperature Entered.. Please enter a temperature to convert");
				}
			}
		});	
		
	
		b2.addActionListener(new ActionListener() {					//Converter Button 2 Action
			
			public void actionPerformed(ActionEvent e) {			
				try {			
					String tempInString2 = tf2.getText();
					float tempInFloat2 = Float.parseFloat(tempInString2);
					float tempInCel = (tempInFloat2 - 32) * 5/9; 
				
				
					System.out.println("Temperature in " + tempInFloat2);
					f.add(result2);
					result2.setText(tempInFloat2 + "ºF in Celcius is "+  String.valueOf(tempInCel) + "ºC");
				
				} catch(NumberFormatException f) {
					System.out.println("No Temperature Entered.. Please enter a temperature to convert");
				}
			}
		});
		
		
		//----- Reset Button -----
		resetButton.addActionListener(new ActionListener() {			//Reset Button Action 
			public void  actionPerformed(ActionEvent e) {
				System.out.println("Reset in progress. Please Wait");
				result.setText("");
				result2.setText("");
				tf.setText("");
				tf2.setText("");
			}
		});
	
		
		f.setVisible(true);									//Make frame visible
		System.out.println("Frame running ...");
		
	}

}
