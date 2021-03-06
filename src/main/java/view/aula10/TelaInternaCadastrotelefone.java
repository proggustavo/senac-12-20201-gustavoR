package view.aula10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ClienteController;
import controller.TelefoneController;
import model.vo.Cliente;
import model.vo.Telefone;

public class TelaInternaCadastrotelefone extends JInternalFrame {
	
	private JTextField textCodPais;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JComboBox cmbClientes;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JCheckBox chckbxMovel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaCadastrotelefone frame = new TelaInternaCadastrotelefone();
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
	public TelaInternaCadastrotelefone() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCodigoDoPas = new JLabel("Código do País:");
		lblCodigoDoPas.setBounds(34, 32, 110, 15);
		getContentPane().add(lblCodigoDoPas);
		
		textCodPais = new JTextField();
		textCodPais.setBounds(163, 29, 237, 21);
		getContentPane().add(textCodPais);
		textCodPais.setColumns(10);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(163, 68, 237, 21);
		txtDdd.setColumns(10);
		getContentPane().add(txtDdd);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(34, 108, 146, 15);
		getContentPane().add(lblNumero);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(34, 71, 35, 15);
		getContentPane().add(lblDdd);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(163, 105, 237, 21);
		getContentPane().add(txtNumero);
		
		chckbxMovel = new JCheckBox("Móvel");
		chckbxMovel.setBounds(163, 171, 129, 23);
		getContentPane().add(chckbxMovel);
		
		ClienteController controllerClientes = new ClienteController();
		ArrayList<Cliente> clientes =  controllerClientes.listarTodosOsClientes();
		cmbClientes = new JComboBox(clientes.toArray());
		cmbClientes.setSelectedIndex(-1);
		cmbClientes.setBounds(163, 135, 237, 24);
		getContentPane().add(cmbClientes);
		
		JLabel lblDonoopcional = new JLabel("Dono:  (opcional)");
		lblDonoopcional.setBounds(34, 140, 129, 15);
		getContentPane().add(lblDonoopcional);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(163, 224, 237, 25);
		getContentPane().add(btnLimpar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController telefoneController = new	TelefoneController();
				Telefone novoTelefone = new Telefone();
				novoTelefone.setCodigoPais(txtDdd.getText());
				novoTelefone.setNumero(txtNumero.getText());
				if(cmbClientes.getSelectedItem() != null) {
					novoTelefone.setDono((Cliente) cmbClientes.getSelectedItem());
				}
				novoTelefone.setMovel(chckbxMovel.isSelected());
				
				telefoneController.salvar(novoTelefone);
				
				
			}
		});
		btnSalvar.setBounds(34, 224, 117, 25);
		add(btnSalvar);


	}

}
