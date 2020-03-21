package view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;

public class TelaCadastroEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textNumero;

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
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(15, 15, 60, 15);
		contentPane.add(lblRua);
		
		JLabel lblNewLabel = new JLabel("Bairro:");
		lblNewLabel.setBounds(15, 45, 60, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(15, 83, 70, 15);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(241, 83, 70, 15);
		contentPane.add(lblEstado);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setBounds(241, 15, 70, 15);
		contentPane.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(241, 45, 70, 15);
		contentPane.add(lblCep);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(98, 119, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
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
		contentPane.add(textCidade);
		textCidade.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setBounds(314, 11, 114, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			JFormattedTextField txtCep = new JFormattedTextField();
			txtCep.setBounds(314, 43, 110, 20);
			contentPane.add(txtCep);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> siglasEstados =  consultarEstados();
		JComboBox cbSiglaEstado = new JComboBox(siglasEstados.toArray());
		cbSiglaEstado.setBounds(314, 78, 50, 25);
		contentPane.add(cbSiglaEstado);
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
