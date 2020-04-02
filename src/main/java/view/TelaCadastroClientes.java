package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ClienteController;
import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class TelaCadastroClientes {

	private JFrame frame;
	private JTextField textNome;
	private JLabel lblSobrenome;
	private JTextField textSobrenome;
	private JTextField textCpfCnpj;
	private JLabel lblCpfcnpj;
	private ClienteController clienteController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClientes window = new TelaCadastroClientes();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Cadastro de Cliente");
		frame.setBounds(100, 100, 532, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(31, 12, 70, 15);
		frame.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(31, 39, 190, 23);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(31, 74, 122, 15);
		frame.getContentPane().add(lblSobrenome);
		
		textSobrenome = new JTextField();
		textSobrenome.setBounds(31, 101, 190, 23);
		frame.getContentPane().add(textSobrenome);
		textSobrenome.setColumns(10);
		
		textCpfCnpj = new JTextField();
		textCpfCnpj.setBounds(285, 39, 190, 23);
		frame.getContentPane().add(textCpfCnpj);
		textCpfCnpj.setColumns(10);
		
		lblCpfcnpj = new JLabel("CPF/CNPJ:");
		lblCpfcnpj.setBounds(285, 12, 70, 15);
		frame.getContentPane().add(lblCpfcnpj);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnderecoDAO enderecoDAO = new EnderecoDAO();
				Endereco endereco = enderecoDAO.consultarPorId(1);
				clienteController.inserirClienteController(textNome.getText(), textSobrenome.getText(), textCpfCnpj.getText(), endereco);
				
				String message = "";
				JOptionPane.showMessageDialog(null, message, "Cadastrar Cliente", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(199, 184, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		
	}
}
