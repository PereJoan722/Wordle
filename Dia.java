package Vista;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class Dia extends JPanel{
	private int num;
	private JLabel cont;
	
	public static Color borderColorSelected=new Color(170, 219, 244);
	public static Color borderColor=new Color(207, 207, 207);


	
	public Dia() {
		setBorder(new LineBorder(new Color(207, 207, 207)));
		
		cont = new JLabel();
		cont.setBounds(10, 10, 30, 30);
		cont.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
		add(cont);
		
		this.setBounds(10, 10, 20, 54);
		
		this.setSize(72, 35);
		
		
		repaint();
		revalidate();
		
		
		
	}
	
	
	public void setD(int a) {
		
		this.num=a;
		
		cont.setText(a+"");
		
	}
	
	public int getD() {

		int a = Integer.parseInt(cont.getText());
		 
		return a;
		 
	}

	
	public void setDefault() {
		setBorder(new LineBorder(new Color(207, 207, 207)));
		repaint();
	}
	
	
	public void setSelected() {			
		setBorder(new LineBorder(borderColorSelected, 3, true));
		repaint();	
		}
	
	
	public boolean isSeleccionado() {
		
		if(this.getBorder() == (new LineBorder(borderColorSelected, 3, true))) {
			return true;
		} else {
			return false;
		}
		
	    
	}

	
	
	

}
