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
	private JTextField textSobrenome;
	private JTextField textCpfCnpj;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 12, 70, 15);
		frame.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(25, 31, 114, 19);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(25, 73, 121, 15);
		frame.getContentPane().add(lblSobrenome);
		
		textSobrenome = new JTextField();
		textSobrenome.setBounds(25, 100, 114, 19);
		frame.getContentPane().add(textSobrenome);
		textSobrenome.setColumns(10);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(203, 12, 70, 15);
		frame.getContentPane().add(lblCpfcnpj);
		
		textCpfCnpj = new JTextField();
		textCpfCnpj.setBounds(203, 31, 114, 19);
		frame.getContentPane().add(textCpfCnpj);
		textCpfCnpj.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnderecoDAO enderecoDao = new EnderecoDAO();
				Endereco endereco = enderecoDao.consultarPorId(1);
				
				String message = clienteController.inserirClienteController(textNome.getText(), textSobrenome.getText(), textCpfCnpj.getText(), endereco);
				
				JOptionPane.showMessageDialog(null, message, "Cadastro de Cliente",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCadastrar.setBounds(147, 176, 117, 25);
		frame.getContentPane().add(btnCadastrar);
	}
}
