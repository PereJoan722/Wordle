package Vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CDatePicker extends JPanel{
	
	JTextField DiaSeleccionado;
	private JLabel Boton;
	public LocalDate fecha = LocalDate.now();
	public Date fechav = new Date();

	DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/u");
	String fechatexto = fecha.format(formato);	
	SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");
 
	
	
	public CDatePicker() {
		
		
		this.setBounds(20, 20, 200, 58);

		
		DiaSeleccionado = new JTextField();
		DiaSeleccionado.setText(fechatexto);
		DiaSeleccionado.setBounds(36, 15, 100, 26);
		DiaSeleccionado.setColumns(10);
		setLayout(null);
		add(DiaSeleccionado);
		
		Boton = new JLabel(" V");
		Boton.setForeground(new Color(0, 255, 0));
		Boton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Boton.setToolTipText("");
		Boton.setBounds(146, 14, 30, 26);
		Boton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		add(Boton);
		

				   
				
	
		Boton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				String txt = DiaSeleccionado.getText();
				
				
					
				try {
					fechav = formatoDate.parse(txt);
				} catch (ParseException e1) {
	
				}
				
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Instant instant = fechav.toInstant();
				LocalDate fechabb = instant
				    .atZone(defaultZoneId).toLocalDate();
				
			
		        
		        new Calendario(fechabb, CDatePicker.this);
		        
			}});
		
		
		repaint();
		revalidate();
        
		
	}
	/*
	public CDatePicker(LocalDate f) {
		
		
		this.setBounds(20, 20, 200, 58);
		
		String ff = f.format(formato);
		
		DiaSeleccionado = new JTextField();
		DiaSeleccionado.setText(ff);
		DiaSeleccionado.setBounds(36, 15, 100, 26);
		DiaSeleccionado.setColumns(10);
		setLayout(null);
		add(DiaSeleccionado);
		
		Boton = new JLabel(" V");
		Boton.setForeground(new Color(0, 255, 0));
		Boton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Boton.setToolTipText("");
		Boton.setBounds(146, 14, 30, 26);
		Boton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		add(Boton);
		

				   
				
	
		Boton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				String txt = DiaSeleccionado.getText();
					
				try {
					fechav = formatoDate.parse(txt);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Instant instant = fechav.toInstant();
				LocalDate fechabb = instant
				    .atZone(defaultZoneId).toLocalDate();
				
				
		        //LocalDate fechab = LocalDate.parse(txt, formato);
		        
		        new Calendario(fechabb);
		        
			}});
		
		
		repaint();
		revalidate();
        
		
	}

*/

	public void setBounds(int a, int b, int c, int d){	
		super.setBounds(a, b, 200, 58);
	
	}
	


}
