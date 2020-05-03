package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IoDatos.IOdatos;
import motivos.Salidas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.swing.event.ChangeListener;

import Individuos.Persona;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InterfazPolicia extends JFrame {

	private JPanel contentPane;
	private JLabel lblpolicia;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_hora;
	private JTextField textField_dni;
	private JComboBox comboBox_personas;
	private JLabel lblNewLabel_personas;
	private JLabel lblNewLabel_dia;
	private JLabel lblNewLabel_info;
	private JTextArea textArea_infoCiudadano;
	private JButton btn_atras;
	private JButton btn_multar;
	private JToggleButton tglbtn_mostrartodo;
	private JButton btn_revisar;
	private DefaultComboBoxModel cbList;
	private ArrayList<Salida> vSalidas;
	private ArrayList<Persona> vPersonas;
	private JCalendar calendar;
	private JSpinner spinner_hora;
	private JSpinner spinner_minutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPolicia frame = new InterfazPolicia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazPolicia() {
		vSalidas = IOdatos.cargarSalida();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblpolicia = new JLabel("Policia");
		lblpolicia.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblpolicia.setBounds(182, 33, 118, 45);
		contentPane.add(lblpolicia);

		lblNewLabel = new JLabel("dni a comprobar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(60, 116, 107, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_hora = new JLabel("hora a comprobar");
		lblNewLabel_hora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_hora.setBounds(60, 157, 124, 14);
		contentPane.add(lblNewLabel_hora);

		textField_dni = new JTextField();
		textField_dni.addKeyListener(new TextField_dniKeyListener());
		textField_dni.setBounds(223, 113, 182, 20);
		contentPane.add(textField_dni);
		textField_dni.setColumns(10);

		comboBox_personas = new JComboBox();
		comboBox_personas.addMouseListener(new ComboBox_personasMouseListener());
		cbList = new DefaultComboBoxModel<>();
		comboBox_personas.setModel(cbList);
		comboBox_personas.setBounds(77, 390, 107, 22);
		contentPane.add(comboBox_personas);

		lblNewLabel_personas = new JLabel("personas en el momento seleccionado");
		lblNewLabel_personas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_personas.setBounds(206, 394, 193, 14);
		contentPane.add(lblNewLabel_personas);

		lblNewLabel_dia = new JLabel("dia");
		lblNewLabel_dia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_dia.setBounds(60, 206, 107, 14);
		contentPane.add(lblNewLabel_dia);

		lblNewLabel_info = new JLabel("informacion del ciudadano");
		lblNewLabel_info.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_info.setBounds(77, 472, 167, 14);
		contentPane.add(lblNewLabel_info);

		textArea_infoCiudadano = new JTextArea();
		textArea_infoCiudadano.setEditable(false);
		textArea_infoCiudadano.setBounds(60, 497, 362, 178);
		contentPane.add(textArea_infoCiudadano);

		btn_atras = new JButton("atras");
		btn_atras.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_atras.addMouseListener(new Btn_atrasMouseListener());
		btn_atras.setBounds(60, 720, 89, 23);
		contentPane.add(btn_atras);

		btn_multar = new JButton("multar");
		btn_multar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_multar.addMouseListener(new Btn_multarMouseListener());
		btn_multar.setBounds(333, 720, 89, 23);
		contentPane.add(btn_multar);

		tglbtn_mostrartodo = new JToggleButton("mostrar todos");
		tglbtn_mostrartodo.setFont(new Font("Tahoma", Font.BOLD, 13));
		tglbtn_mostrartodo.addChangeListener(new Tglbtn_mostrartodoChangeListener());
		tglbtn_mostrartodo.setBounds(248, 419, 121, 23);
		contentPane.add(tglbtn_mostrartodo);

		btn_revisar = new JButton("revisar");
		btn_revisar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_revisar.addMouseListener(new Btn_revisarMouseListener());
		btn_revisar.setBounds(195, 720, 89, 23);
		contentPane.add(btn_revisar);

		calendar = new JCalendar();
		calendar.setBounds(177, 189, 258, 170);
		contentPane.add(calendar);

		spinner_hora = new JSpinner();
		spinner_hora.setModel(new SpinnerNumberModel(-1, -1, 23, 1));
		spinner_hora.setBounds(223, 155, 77, 20);
		contentPane.add(spinner_hora);

		spinner_minutos = new JSpinner();
		spinner_minutos.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_minutos.setBounds(321, 155, 84, 20);
		contentPane.add(spinner_minutos);

		iniciarModelo();
	}

	private void iniciarModelo() {
		cbList.removeAllElements();
		for (Salida s : vSalidas) {
			cbList.addElement(s);
		}

	}

	private void actualizarModelo(boolean todos) {
		cbList.removeAllElements();
		String dni = "";
		int hora = (int) spinner_hora.getValue();
		int minutos = (int) spinner_minutos.getValue();
		String hora_concreta = "";
		String fecha = "";
		boolean concuerda = false;

		String patdni = "dddddddd[A-Z]";
		String pat2dni = "[A-Z]ddddddd[A-Z]";

		if (Pattern.matches(patdni, dni) || Pattern.matches(pat2dni, dni)) {
			concuerda = true;
		}

		if (hora < 10 && hora >= 0) {
			hora_concreta = "0" + hora + ":";
		} else if (hora != -1) {
			hora_concreta = hora + ":";
		}

		if (minutos < 10 && minutos >= 0) {
			hora_concreta += "0" + minutos + "";
		} else {
			hora_concreta += minutos + "";
		}
		// supongamos que esta el jotacalenda
		
		
        int dia= calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes= calendar.getCalendar().get(Calendar.MONTH);
        int año= calendar.getCalendar().get(Calendar.YEAR);
        fecha=dia+"/"+mes+"/"+año;

		if (hora < 0) {
			if (concuerda) {
				for (Salida sal : vSalidas) {
					if (sal.getdni().equalsIgnoreCase(dni) && sal.getFecha().equalsIgnoreCase(dia)) {
						cbList.addElement(sal.getdni());
					}
				}
			} else {
				for (Salida sal : vSalidas) {
					if (sal.getFecha().equalsIgnoreCase(dia)) {
						cbList.addElement(sal.getdni());
					}
				}
			}

		} else {
			if (concuerda) {
				for (Salida sal : vSalidas) {
					if (sal.getdni().equalsIgnoreCase(dni) && sal.getFecha().equalsIgnoreCase(dia)
							&& sal.getHora().equalsIgnoreCase(hora_concreta)) {

						cbList.addElement(sal.getdni());
					}
				}
			} else {
				for (Salida sal : vSalidas) {
					if (sal.getFecha().equalsIgnoreCase(dia)
							&& sal.getHora().equalsIgnoreCase(hora_concreta)) {

						cbList.addElement(sal.getdni());
					}
				}
			}

		}

	}

	private class TextField_dniKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {

			actualizarModelo(true);
		}
	}

//	private class ComboBox_personasMouseListener extends MouseAdapter {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			String s = (String) cbList.getSelectedItem();
//			for (Salidas sal : vSalidas) {
//				if (sal.getdni().equalsIgnoreCase(s)) {
//					textArea_infoCiudadano.setText(sal.toString());
//					break;
//				}
//			}
//
//		}
//	}

	private class Btn_atrasMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Login l = new Login();
			l.setVisible(true);
			dispose();
		}
	}

	private class Btn_revisarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Salida sal = (Salida) cbList.getSelectedItem();

			sal.setRevisado(true);

		}

	}

	private class Btn_multarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Salida sal = (Salida) cbList.getSelectedItem();

			sal.setRevisado(true);
			sal.setMultado(true);

		}
	}

	private class Tglbtn_mostrartodoChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			if (!tglbtn_mostrartodo.isSelected()) {
				actualizarModelo(false);
			} else {
				actualizarModelo(true);
			}

		}
	}

//	private class ComboBox_personasActionListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			Salidas sal = (Salidas) cbList.getSelectedItem();
//
//			textArea_infoCiudadano.setText(sal.toString());
//
//		}
//
//	}
	private class ComboBox_personasMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			String salid = (String) cbList.getSelectedItem();
			int hora = (int) spinner_hora.getValue();
			int minutos = (int) spinner_minutos.getValue();
			String hora_concreta = "";
			String fecha = "";
			
			if (hora < 10 && hora >= 0) {
				hora_concreta = "0" + hora + ":";
			} else if (hora != -1) {
				hora_concreta = hora + ":";
			}

			if (minutos < 10 && minutos >= 0) {
				hora_concreta += "0" + minutos + "";
			} else {
				hora_concreta += minutos + "";
			}
			
			
            int dia= calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
            int mes= calendar.getCalendar().get(Calendar.MONTH);
            int año= calendar.getCalendar().get(Calendar.YEAR);
            fecha=dia+"/"+mes+"/"+año;
			
			
			if (hora < 0) {
				
					for (Salida sal : vSalidas) {
						if (sal.getdni().equalsIgnoreCase(salid) && sal.getFecha().equalsIgnoreCase(dia)) {
							textArea_infoCiudadano.setText(sal.toString());
						}
					}
				

			} else {
				
					for (Salida sal : vSalidas) {
						if (sal.getdni().equalsIgnoreCase(salid) && sal.getFecha().equalsIgnoreCase(dia)
								&& sal.getHora().equalsIgnoreCase(hora_concreta)) {

							textArea_infoCiudadano.setText(sal.toString());
						}
					
				}

			}
			
		}
	}
}