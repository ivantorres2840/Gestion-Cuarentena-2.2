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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class InterfazSalida extends JFrame {

	private JPanel contentPane;
	private DefaultComboBoxModel modeloComboBox = new DefaultComboBoxModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazSalida frame = new InterfazSalida();
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
	public InterfazSalida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(25, 294, 212, 153);
		contentPane.add(calendar);
		
		JTextArea textAreasalidas = new JTextArea();
		textAreasalidas.setEditable(false);
		textAreasalidas.setBounds(25, 120, 428, 145);
		contentPane.add(textAreasalidas);
		
		JLabel lblsalidas = new JLabel("Salidas Realizadas");
		lblsalidas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblsalidas.setBounds(25, 95, 131, 14);
		contentPane.add(lblsalidas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(299, 510, 154, 22);

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
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(305, 319, 30, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(378, 319, 30, 20);
		contentPane.add(spinner_1);
		
		JTextArea textAreamotivos = new JTextArea();
		textAreamotivos.setBounds(25, 566, 428, 145);
		contentPane.add(textAreamotivos);
		
		JLabel lblotros = new JLabel("Otros:");
		lblotros.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblotros.setBounds(29, 541, 48, 14);
		contentPane.add(lblotros);
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(358, 737, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(25, 738, 89, 23);
		contentPane.add(btnNewButton_1);
		
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
		
		
		
		
	}
}
