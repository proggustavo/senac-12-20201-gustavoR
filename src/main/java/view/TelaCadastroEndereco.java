package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.EnderecoController;

public class TelaCadastroEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textNumero;
	private JFormattedTextField textCep;
	private JComboBox cbSiglaEstado;
	private EnderecoController enderecoController; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco frame = new TelaCadastroEndereco();
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
	public TelaCadastroEndereco() {
		setTitle("Cadastro de Endereço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRua = new JLabel("Rua:*");
		lblRua.setBounds(15, 15, 60, 15);
		contentPane.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:*");
		lblBairro.setBounds(15, 45, 60, 15);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:*");
		lblCidade.setBounds(15, 83, 70, 15);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:*");
		lblEstado.setBounds(241, 83, 70, 15);
		contentPane.add(lblEstado);
		
		JLabel lblNmero = new JLabel("Número:*");
		lblNmero.setBounds(241, 15, 70, 15);
		contentPane.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP:*");
		lblCep.setBounds(241, 45, 70, 15);
		contentPane.add(lblCep);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enderecoController.salvar(textRua.getText(), textBairro.getText(), textNumero.getText(), textCep.getText() , textCidade.getText(),
				(String)cbSiglaEstado.getSelectedItem());
			}
		});
		btnSalvar.setBounds(98, 119, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
			
		});
		btnLimpar.setBounds(227, 119, 128, 25);
		contentPane.add(btnLimpar);
		
		textRua = new JTextField();
		textRua.setBounds(78, 13, 137, 20);
		contentPane.add(textRua);
		textRua.setColumns(10);
		
		textBairro = new JTextField();
		textBairro.setBounds(78, 43, 137, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setBounds(78, 81, 137, 20);
		contentPane.add(textCidade); //TODO combobox com as cidades por estado
		textCidade.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setBounds(314, 11, 114, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			textCep = new JFormattedTextField(mascaraCep);
			textCep.setBounds(314, 43, 110, 20);
			contentPane.add(textCep);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> siglasEstados =  consultarEstados();
		cbSiglaEstado = new JComboBox(siglasEstados.toArray()); //TODO integrar api correios
		cbSiglaEstado.setBounds(314, 78, 50, 25);
		contentPane.add(cbSiglaEstado);
	}

	protected void limparCampos() {
		this.textRua.setText("");
		this.textBairro.setText("");
		this.textCidade.setText("");
		this.textNumero.setText("");
		this.textBairro.setText("");
		this.textBairro.setText("");
		this.textCep.setText("");
		this.cbSiglaEstado.setSelectedIndex(-1);
	}

	private ArrayList<String> consultarEstados() {
		ArrayList<String> siglasEstados = new ArrayList<String>();
		
		siglasEstados.add("AC");
		siglasEstados.add("BA");
		siglasEstados.add("CE");
		siglasEstados.add("DF");
		siglasEstados.add("GO");
		siglasEstados.add("PR");
		siglasEstados.add("SC");
		siglasEstados.add("RS");
		
		return siglasEstados;
	}
}
