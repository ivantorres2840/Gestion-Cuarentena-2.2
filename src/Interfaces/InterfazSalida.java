package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class InterfazSalida extends JFrame {

	private JPanel contentPane;
	private DefaultComboBoxModel modeloComboBox = new DefaultComboBoxModel();
	private String dni;
	//private ArrayList<Salida> vSalida;
	//private ArrayList<Persona> vPersona;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String dni=null;
					InterfazSalida frame = new InterfazSalida(dni);
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
	public InterfazSalida(String dni) {
		//vPersona = IOdatos.cargarpersona();
		this.dni = dni;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendario = new JCalendar();
		calendario.setBounds(25, 294, 212, 153);
		contentPane.add(calendario);
		
		JTextArea textAreasalidas = new JTextArea();
		textAreasalidas.setEditable(false);
		textAreasalidas.setBounds(25, 120, 428, 145);
		contentPane.add(textAreasalidas);
		
		JLabel lblsalidas = new JLabel("Salidas Realizadas");
		lblsalidas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblsalidas.setBounds(25, 95, 131, 14);
		contentPane.add(lblsalidas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 510, 183, 22);

		modeloComboBox = new DefaultComboBoxModel();
		comboBox.setModel(modeloComboBox);
		contentPane.add(comboBox);
		
		JLabel lblsalida = new JLabel("Salidas");
		lblsalida.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblsalida.setBounds(173, 11, 162, 73);
		contentPane.add(lblsalida);
		
		JLabel lblmotivos = new JLabel("Motivos");
		lblmotivos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmotivos.setBounds(378, 483, 60, 14);
		contentPane.add(lblmotivos);
		
		JLabel lblhoras = new JLabel("Horas");
		lblhoras.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblhoras.setBounds(300, 294, 48, 14);
		contentPane.add(lblhoras);
		
		JLabel lblminutos = new JLabel("Minutos");
		lblminutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblminutos.setBounds(358, 294, 60, 14);
		contentPane.add(lblminutos);
		
		JSpinner spinner_hora = new JSpinner();
		spinner_hora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_hora.setBounds(305, 319, 30, 20);
		contentPane.add(spinner_hora);
		
		JSpinner spinner_minutos = new JSpinner();
		spinner_minutos.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_minutos.setBounds(378, 319, 30, 20);
		contentPane.add(spinner_minutos);
		
		JTextArea textAreamotivos = new JTextArea();
		textAreamotivos.setBounds(25, 566, 428, 145);
		contentPane.add(textAreamotivos);
		
		JLabel lblotros = new JLabel("Otros:");
		lblotros.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblotros.setBounds(29, 541, 48, 14);
		contentPane.add(lblotros);
		
		JButton btnreserva = new JButton("Reservar");

		btnreserva.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnreserva.setBounds(358, 737, 95, 23);
		contentPane.add(btnreserva);
		
		JButton btnvolver = new JButton("Volver");

		btnvolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvolver.setBounds(25, 738, 89, 23);
		contentPane.add(btnvolver);
		
		modeloComboBox.addElement("Sacar a pasear al perro");
		modeloComboBox.addElement("Ir al medico de Urgencias");
		modeloComboBox.addElement("Ir a hacer la compra");
		modeloComboBox.addElement("Otros");
		textAreamotivos.setVisible(false);
		lblotros.setVisible(false);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modeloComboBox.getSelectedItem().equals("Otros")) {
					textAreamotivos.setVisible(true);
					lblotros.setVisible(true);
				} else {
					textAreamotivos.setVisible(false);
					lblotros.setVisible(false);
				}
			}
		});
		
		//vSalida = IOdatos.cargarSalida();

		//String salidas = "";
		//for (Salidas s : vSalida) {
		//	if (s.getdni().equalsIgnoreCase(dni)) {
		//		salidas += s.toString() + "\n";
		//	}
		//}
	//	textAreasalidas.setText(salidas);
		
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Login l = new Login();
			//	l.setVisible(true);
			//	dispose();
			}
		});
		
		btnreserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha="";
				int dia= calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes= calendario.getCalendar().get(Calendar.MONTH);
				int año= calendario.getCalendar().get(Calendar.YEAR);
				fecha=dia+"/"+mes+"/"+año;
				
				int hora= (int) spinner_hora.getValue();
				int minutos= (int) spinner_minutos.getValue();
				String hora_concreta="";
				
				if(hora<10 && hora>=0) {
					hora_concreta="0"+hora+":";
				}else if (hora!=1) {
					hora_concreta=hora+":";
				}
				
				if(minutos<10 && minutos>=0) {
					hora_concreta+="0"+minutos+"";
				}else {
					hora_concreta+=minutos+"";
				}
				
				if (comboBox.getSelectedItem().equals("Otros")) {
					//Salidas s = new Salidas(textAreamotivos.getText(), fecha,hora_concreta , dni);
			//		JOptionPane.showMessageDialog(null, "Se Ha Guardado Con Exito", "Guardado Completado", 1);
					//vSalida.add(s);
					//IOdatos.guardarSal(vSalida);
				} else {
					//Salidas c = new Salidas(comboBox.getSelectedItem().toString(), fecha,	hora_concreta, dni);
			//		JOptionPane.showMessageDialog(null, "Se Ha Guardado Con Exito", "Guardado Completado", 1);
			//		vSalida.add(c);
			//		IOdatos.guardarSal(vSalida);
				}
				
			}
		});
		
		
		
	}
}
