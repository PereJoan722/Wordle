package Vista;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class MyJFrame extends JFrame{
	

	
	public MyJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(20, 20, 400, 400);
		setVisible(true);
		getContentPane().setLayout(null);
		
		CDatePicker datePicker = new CDatePicker();
		datePicker.setBounds(69, 42, 200, 58);
		getContentPane().add(datePicker);
		
		this.repaint();
		this.revalidate();
		
		
	}
}
