package view.aula10;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EnderecoController;
import model.vo.Endereco;

public class TelaInternaCadastroCliente extends JInternalFrame {
	private JTextField textNome;
	private JTextField textSobrenome;
	private JTextField textDtNascimento;
	private JComboBox cmbEnderecos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaCadastroCliente frame = new TelaInternaCadastroCliente();
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
	public TelaInternaCadastroCliente() {
		setClosable(true);
		setTitle("Cadastrar Cliente");
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(37, 12, 70, 15);
		getContentPane().add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(37, 72, 123, 15);
		getContentPane().add(lblSobrenome);
		
		textNome = new JTextField();
		textNome.setBounds(37, 39, 188, 21);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textSobrenome = new JTextField();
		textSobrenome.setBounds(37, 99, 188, 21);
		getContentPane().add(textSobrenome);
		textSobrenome.setColumns(10);
		
		textDtNascimento = new JTextField();
		textDtNascimento.setColumns(10);
		textDtNascimento.setBounds(249, 39, 188, 21);
		getContentPane().add(textDtNascimento);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(249, 12, 141, 15);
		getContentPane().add(lblDataNascimento);
		
		ArrayList<Endereco> enderecos = new  ArrayList<Endereco>();
		EnderecoController enderecoController = new EnderecoController();
		
		enderecos = enderecoController.consultarTodosEnderecos();
		cmbEnderecos = new JComboBox();
		cmbEnderecos.addItem("- - - - - Selecione um endereço - - - - -");
		for (Endereco endereco : enderecos) {
			cmbEnderecos.addItem(endereco);
		}
		cmbEnderecos.setBounds(247, 97, 281, 24);
		getContentPane().add(cmbEnderecos);

		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(174, 168, 188, 25);
		getContentPane().add(btnSalvar);

	}
}
