package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import Individuos.Ciudadano;
//import Individuos.Persona;
//import Individuos.Policia;
//import IoDatos.IOdatos;
//import interfaz.Login;
//import interfaz.Registro.BtnNewButtonMouseListener;
//import interfaz.Registro.BtnVolverMouseListener;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import Clases.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtdni;
	private JTextField txtnombre;
	private JRadioButton rdbtnpolicia;
	private ArrayList<Persona> vPersona;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
//		setIconImage(Toolkit.getDefaultToolkit()
//				.getImage("C:\\Users\\Usuario\\Desktop\\TODA CUARENTENA\\cuarentena\\60-espana-sin-escudo_400px.jpg"));
		vPersona = IoDatos.cargarpersona();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 329, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(49, 122, 67, 21);
		contentPane.add(lblNewLabel_1);

		txtnombre = new JTextField();
		txtnombre.setBounds(138, 123, 171, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("DNI");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(49, 169, 67, 21);
		contentPane.add(lblNewLabel_1_1);

		txtdni = new JTextField();
		txtdni.setBounds(138, 170, 171, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);

		/*
		 * rdbtnPolicia = new JRadioButton("Policia"); buttonGroup.add(rdbtnPolicia);
		 * rdbtnPolicia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 * rdbtnPolicia.setBounds(72, 225, 84, 23); contentPane.add(rdbtnPolicia);
		 */

		/*
		 * rdbtnCiudadano = new JRadioButton("Ciudadano");
		 * buttonGroup.add(rdbtnCiudadano); rdbtnCiudadano.setFont(new Font("Tahoma",
		 * Font.PLAIN, 13)); rdbtnCiudadano.setBounds(158, 225, 109, 23);
		 * contentPane.add(rdbtnCiudadano);
		 */

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVolver.addMouseListener(new BtnVolverMouseListener());
		btnVolver.setBounds(49, 351, 89, 23);
		contentPane.add(btnVolver);

		JButton btnaceptar = new JButton("Aceptar Registro");

		btnaceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnaceptar.addMouseListener(new BtnNewButtonMouseListener());
		btnaceptar.setBounds(162, 351, 147, 23);
		contentPane.add(btnaceptar);

		txtdni = new JTextField();
		txtdni.setBounds(162, 170, 134, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);

		txtnombre = new JTextField();
		txtnombre.setBounds(162, 123, 134, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		rdbtnpolicia = new JRadioButton("Policia");
		rdbtnpolicia.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonGroup.add(rdbtnpolicia);
		rdbtnpolicia.setBounds(67, 255, 89, 23);
		contentPane.add(rdbtnpolicia);

		JRadioButton rdbtnCiudadano = new JRadioButton("Ciudadano");
		rdbtnCiudadano.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonGroup.add(rdbtnCiudadano);
		rdbtnCiudadano.setBounds(155, 255, 109, 23);
		contentPane.add(rdbtnCiudadano);
	}

	/*
	 * Al clicar el boton volver cierra la ventana registro y vuelve a la ventana
	 * login.
	 */
	private class BtnVolverMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Login log = new Login();
			log.setVisible(true);
			dispose();
		}
	}


	
	

	/*
	 * crea un objeto de persona o policia segun lo que hemos elegido.
	 */
	private class BtnNewButtonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String patdni = "dddddddd[A-Z]";
	        String pat2dni = "[A-Z]ddddddd[A-Z]";
	        boolean concuerda=false;

	        if (Pattern.matches(patdni, txtdni.getText()) || Pattern.matches(pat2dni, txtdni.getText())) {
	            concuerda = true;
	        }

			if ((!txtnombre.getText().equalsIgnoreCase("") || txtnombre.getText() != null)
					&& (!txtdni.getText().equalsIgnoreCase("") || txtdni.getText() != null) && (concuerda)) {
				if (rdbtnpolicia.isSelected()) {
					Policia poli = new Policia(txtnombre.getText(), txtdni.getText(), ("P-" + txtdni.getText()));
					vPersona.add(poli);
					JOptionPane.showMessageDialog(null, "Se Ha Guardado Con Exito", "Guardado Completado", 1);
					IoDatos.guardarPers(vPersona);
				} else {
					Ciudadano ciu = new Ciudadano(txtnombre.getText(), txtdni.getText(), ("C-" + txtdni.getText()));
					vPersona.add(ciu);
					IoDatos.guardarPers(vPersona);
					JOptionPane.showMessageDialog(null, "Se Ha Guardado Con Exito", "Guardado Completado", 1);
				}
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
			}

		
	}
}
