package Vista;

import javax.swing.JFrame;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Calendario extends JDialog{
	Dia[][] ArrayDias = new Dia[6][7];
	
	public Dia DiaAnt = null;
	public boolean Select1 = true;
	public int a;
	
	public CDatePicker cd;
	
	
  
	
	public Calendario(LocalDate d, CDatePicker cd) {
		getContentPane().setLayout(null);
		this.cd=cd;

		a = cd.fecha.getDayOfMonth();
		
		this.setBounds(150, 150, 400, 400);
		
		getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(199, 42, 85, 22);
		getContentPane().add(spinner);
		
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Enero");
        comboBox.addItem("Febrero");
        comboBox.addItem("Marzo");
        comboBox.addItem("Abril");
        comboBox.addItem("Mayo");
        comboBox.addItem("Junio");
        comboBox.addItem("Julio");
        comboBox.addItem("Agosto");
        comboBox.addItem("Septiembre");
        comboBox.addItem("Octubre");
        comboBox.addItem("Noviembre");
        comboBox.addItem("Diciembre");
		comboBox.setBounds(68, 41, 121, 22);
		getContentPane().add(comboBox);
		
		
		
		JLabel lblL = new JLabel("L");
		lblL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblL.setBounds(57, 74, 15, 14);
		getContentPane().add(lblL);
		
		JLabel lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblM.setBounds(93, 74, 15, 14);
		getContentPane().add(lblM);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblX.setBounds(134, 74, 15, 14);
		getContentPane().add(lblX);
		
		JLabel lblJ = new JLabel("J");
		lblJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJ.setBounds(173, 75, 15, 14);
		getContentPane().add(lblJ);
		
		JLabel lblV = new JLabel("V");
		lblV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblV.setBounds(214, 75, 15, 14);
		getContentPane().add(lblV);
		
		JLabel lblS = new JLabel("S");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblS.setBounds(254, 75, 15, 14);
		getContentPane().add(lblS);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblD.setBounds(295, 75, 15, 14);
		getContentPane().add(lblD);
		
			
		spinner.setValue(d.getYear());
		comboBox.setSelectedIndex(d.getMonthValue() - 1);
		
		JLabel Cancelar = new JLabel(" Cancelar");
		Cancelar.setToolTipText("");
		Cancelar.setForeground(new Color(59, 59, 59));
		Cancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Cancelar.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		Cancelar.setBounds(183, 313, 86, 26);
		getContentPane().add(Cancelar);
		
		JLabel OK = new JLabel("  OK");
		OK.setToolTipText("");
		OK.setForeground(new Color(59, 59, 59));
		OK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		OK.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		OK.setBounds(332, 308, 42, 37);
		getContentPane().add(OK);
		
		JLabel Hoy = new JLabel(" HOY");
		Hoy.setToolTipText("");
		Hoy.setForeground(new Color(59, 59, 59));
		Hoy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Hoy.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		Hoy.setBounds(280, 308, 42, 37);
		getContentPane().add(Hoy);
		
		
		
		
		
		
		RellenarCalendario(d);
		
		
		Hoy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				
				LocalDate hoy = LocalDate.now();
	            
				 spinner.setValue(hoy.getYear());
			     comboBox.setSelectedIndex(hoy.getMonthValue() - 1);
			     a = hoy.getDayOfMonth();
			     Select1 = true;
		         RellenarCalendario(hoy);
		        
		         
		        
			}});
		
		
		
		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				if(DiaAnt == null) {
					dispose();
				} else {
					
					int nuevoAño = (int) spinner.getValue();
		            int nuevoMes = comboBox.getSelectedIndex() + 1;
		            
		            LocalDate ad = LocalDate.of(nuevoAño, nuevoMes, a);
		            DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/u");
		            
		            
		            cd.fecha = ad;
		            String fechatexto = ad.format(formato);
		            
		            cd.DiaSeleccionado.setText(fechatexto);
					
					
				    dispose();
					
					
				}
				
			        
		        
			}});
		
		
		Cancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				dispose();
		        
			}});
		 
		
		
        spinner.addChangeListener(e -> {
        	
        	DiaAnt = null;
            int nuevoAño = (int) spinner.getValue();
            int nuevoMes = comboBox.getSelectedIndex() + 1;
            LocalDate ad = LocalDate.of(nuevoAño, nuevoMes, d.getDayOfMonth());
           
           
           RellenarCalendario(ad);
        });
        
        
        
        comboBox.addActionListener(e -> {
        	
        	DiaAnt = null;

            int nuevoAño = (int) spinner.getValue();
            int nuevoMes = comboBox.getSelectedIndex() + 1;
            LocalDate ad = LocalDate.of(nuevoAño, nuevoMes, d.getDayOfMonth());
            
            
            RellenarCalendario(ad);
        });
        
        
        
		
		setModal(true);
		this.repaint();
		this.revalidate();
		setVisible(true);
		
		
	}
	
	
		 
	    
	
	public void RellenarCalendario(LocalDate d) {
		
			       
	    	
		    for (int i = 0; i < ArrayDias.length; i++) {
		        for (int j = 0; j < ArrayDias[i].length; j++) {
		            Dia dia = ArrayDias[i][j];
		            if (dia != null) {
		                getContentPane().remove(dia);
		                ArrayDias[i][j] = null;
		            }
		        }
		    }

		    LocalDate primerDia = d.withDayOfMonth(1);
		    DayOfWeek dia1 = primerDia.getDayOfWeek();
		    int d1 = dia1.getValue(); // Dilluns = 1 - Diumenge = 7
		    int contador = 1;
		    boolean ver = false;
		    int dd = 1;

		    int ultimoDia = d.lengthOfMonth();
		    int diaSeleccionado = d.getDayOfMonth();
		    Date fecha = new Date();
		    
		    
		   

		    for (int i = 0; i < ArrayDias.length; i++) {
		        for (int j = 0; j < ArrayDias[i].length; j++) {
		            Dia dia = new Dia();
		            dia.setBounds(43 + (40 * j), 97 + (40 * i), 30, 30);
		            ArrayDias[i][j] = dia;

		            getContentPane().add(dia);
		            dia.setVisible(ver);

		            if (contador >= d1) {
		                ver = true;
		                dia.setVisible(ver);
		                dia.setD(dd);
		                
		                if (dd == diaSeleccionado && Select1 == true) {
		                	Select1 = false;
			                dia.setSelected(); 
			                DiaAnt = dia;
			                a = dia.getD();
			            }
		                
		                
		                dd++;
		            }

		            contador++;

		           

		            dia.addMouseListener(new MouseAdapter() {
		                public void mouseClicked(MouseEvent me) {
		                    Dia ds = (Dia) me.getSource();

		                    if (DiaAnt != null) {
		                        DiaAnt.setDefault();
		                    }

		                    ds.setSelected();
		                    DiaAnt = ds;
		                    a = ds.getD();
		                }
		            });

		            if (dd > ultimoDia) {
		                break;
		            }
		        }

		        if (dd > ultimoDia) {
		            break;
		        }
		    }

		    this.repaint();
		    this.revalidate();

	    }	
	  
	}

	
	
		 
		 

