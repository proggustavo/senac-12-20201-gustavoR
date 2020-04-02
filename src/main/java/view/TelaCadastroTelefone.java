package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.TelefoneController;
import model.vo.Telefone;

public class TelaCadastroTelefone {

	private JFrame frmCadastroDeTelefone;
	private JTextField textCodigo;
	private JTextField textDDD;
	private JTextField textNumero;
	private TelefoneController telefoneController;
	private ButtonGroup radioGroup;
	private JRadioButton rdbtnMovel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frmCadastroDeTelefone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeTelefone = new JFrame();
		frmCadastroDeTelefone.setTitle("Cadastro de Telefone");
		frmCadastroDeTelefone.setBounds(100, 100, 450, 300);
		frmCadastroDeTelefone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeTelefone.getContentPane().setLayout(null);

		JLabel lblCdigoDoPas = new JLabel("Código do país:");
		lblCdigoDoPas.setBounds(33, 34, 130, 15);
		frmCadastroDeTelefone.getContentPane().add(lblCdigoDoPas);

		textCodigo = new JTextField();
		textCodigo.setBounds(33, 61, 60, 23);
		frmCadastroDeTelefone.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(33, 96, 70, 15);
		frmCadastroDeTelefone.getContentPane().add(lblDdd);

		textDDD = new JTextField();
		textDDD.setBounds(33, 123, 60, 23);
		frmCadastroDeTelefone.getContentPane().add(textDDD);
		textDDD.setColumns(10);

		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma opção:");
		lblSelecioneUmaOpo.setBounds(218, 34, 177, 15);
		frmCadastroDeTelefone.getContentPane().add(lblSelecioneUmaOpo);

		rdbtnMovel = new JRadioButton("Movel");
		rdbtnMovel.setBounds(329, 61, 80, 23);
		frmCadastroDeTelefone.getContentPane().add(rdbtnMovel);
		rdbtnMovel.setActionCommand("1");

		JRadioButton rdbtnFixo = new JRadioButton("Fixo");
		rdbtnFixo.setBounds(213, 61, 80, 23);
		frmCadastroDeTelefone.getContentPane().add(rdbtnFixo);
		rdbtnFixo.setActionCommand("0");
		
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnMovel);
		radioGroup.add(rdbtnFixo);
		
		JLabel lblNmeroDoTelefone = new JLabel("Número do Telefone:");
		lblNmeroDoTelefone.setBounds(218, 96, 177, 15);
		frmCadastroDeTelefone.getContentPane().add(lblNmeroDoTelefone);

		textNumero = new JTextField();
		textNumero.setBounds(218, 123, 160, 23);
		frmCadastroDeTelefone.getContentPane().add(textNumero);
		textNumero.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController telefoneController = new TelefoneController();
				Telefone telefone = new Telefone();
				telefone.setNumero(textNumero.getText());
				telefone.setCodigoPais(textCodigo.getText());
				telefone.setDdd(textDDD.getText());
				telefone.setMovel(rdbtnMovel.isSelected());
				
				String message = telefoneController.salvar(telefone);
				
				JOptionPane.showMessageDialog(null, message, "Cadastro de Telefone", JOptionPane.INFORMATION_MESSAGE);
				

			}
		});
		btnCadastrar.setBounds(164, 226, 117, 25);
		frmCadastroDeTelefone.getContentPane().add(btnCadastrar);
	}
}
