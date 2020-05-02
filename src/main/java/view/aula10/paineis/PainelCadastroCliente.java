package view.aula10.paineis;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelCadastroCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(32, 38, 70, 15);
		add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(32, 96, 135, 15);
		add(lblSobrenome);
		
		textField = new JTextField();
		textField.setBounds(32, 65, 208, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 135, 208, 19);
		add(textField_1);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(74, 245, 117, 25);
		add(btnSalvar);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setBounds(74, 12, 143, 15);
		add(lblCadastroCliente);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(32, 166, 208, 15);
		add(lblDataNascimento);
		
		textField_2 = new JTextField();
		textField_2.setBounds(32, 193, 208, 19);
		add(textField_2);
		textField_2.setColumns(10);

	}

}
