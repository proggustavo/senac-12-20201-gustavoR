package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ClienteController;
import controller.EnderecoController;
import model.vo.Endereco;

public class TelaCadastroClientes {

	private JFrame frmCadastroCliente;
	private JTextField textNome;
	private JTextField textSobrenome;
	private JTextField textCpfCnpj;
	private JComboBox cmbEnderecos;
	private String message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClientes window = new TelaCadastroClientes();
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroCliente = new JFrame();
		frmCadastroCliente.setTitle("Cadastro Cliente");
		frmCadastroCliente.setBounds(100, 100, 450, 300);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 12, 70, 15);
		frmCadastroCliente.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(25, 31, 190, 23);
		frmCadastroCliente.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(25, 73, 121, 15);
		frmCadastroCliente.getContentPane().add(lblSobrenome);
		
		textSobrenome = new JTextField();
		textSobrenome.setBounds(25, 100, 190, 23);
		frmCadastroCliente.getContentPane().add(textSobrenome);
		textSobrenome.setColumns(10);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(243, 12, 70, 15);
		frmCadastroCliente.getContentPane().add(lblCpfcnpj);
		
		textCpfCnpj = new JTextField();
		textCpfCnpj.setBounds(237, 31, 190, 23);
		frmCadastroCliente.getContentPane().add(textCpfCnpj);
		textCpfCnpj.setColumns(10);
		
		
		ArrayList<Endereco> enderecos = new  ArrayList<Endereco>();
		EnderecoController enderecoController = new EnderecoController();
		
		enderecos = enderecoController.consultarTodosEnderecos();
		cmbEnderecos = new JComboBox();
		cmbEnderecos.addItem("- - - - - Selecione um endereço - - - - -");
		for (Endereco endereco : enderecos) {
			cmbEnderecos.addItem(endereco);
		}
		cmbEnderecos.setBounds(237, 100, 190, 24);
		frmCadastroCliente.getContentPane().add(cmbEnderecos);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ClienteController clienteController = new ClienteController();
					Endereco endereco = (Endereco) cmbEnderecos.getSelectedItem();
					
					message = clienteController.inserirClienteController(textNome.getText(), textSobrenome.getText(), textCpfCnpj.getText(), endereco);
					
				}catch (ClassCastException e) {
					message = "Nenhum endereço selecionado!";
				}
				JOptionPane.showMessageDialog(null, message, "Cadastro de Cliente",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(182, 179, 117, 25);
		frmCadastroCliente.getContentPane().add(btnCadastrar);
		
	}
}
