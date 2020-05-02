package view.aula10;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.TelefoneController;
import model.vo.Cliente;
import model.vo.Telefone;
import javax.swing.JButton;

public class TelaInternaExcluirTelefone extends JInternalFrame {
	private JTextField textDDD;
	private JLabel lblNmero;
	private JTextField textNumero;
	private JComboBox cmbTelefone;
	private JButton btnExcluir;
	private JLabel lblDigiteOuSelecione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaExcluirTelefone frame = new TelaInternaExcluirTelefone();
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
	public TelaInternaExcluirTelefone() {
		setTitle("Excluir Telefone");
		setBounds(100, 100, 450, 300);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(12, 80, 46, 15);
		getContentPane().add(lblDdd);
		
		textDDD = new JTextField();
		textDDD.setBounds(76, 78, 57, 19);
		getContentPane().add(textDDD);
		textDDD.setColumns(10);
		
		lblNmero = new JLabel("Número:");
		lblNmero.setBounds(12, 51, 70, 15);
		getContentPane().add(lblNmero);
		
		textNumero = new JTextField();
		textNumero.setBounds(75, 49, 125, 19);
		getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		TelefoneController telefoneController = new TelefoneController();
		telefones =  telefoneController.consultarTodos();
		cmbTelefone = new JComboBox();
		cmbTelefone.addItem("- - - - - - Selecione um Telefone - - - - - - -");
		for (Telefone telefone : telefones) {
			cmbTelefone.addItem(telefone);
		}
		cmbTelefone.setBounds(76, 121, 304, 24);
		getContentPane().add(cmbTelefone);
		
		btnExcluir = new JButton("Excluir Telefone");
		btnExcluir.setBounds(133, 190, 164, 25);
		getContentPane().add(btnExcluir);
		
		lblDigiteOuSelecione = new JLabel("Digite ou Selecione um telefone para exclusão");
		lblDigiteOuSelecione.setBounds(12, 12, 368, 15);
		getContentPane().add(lblDigiteOuSelecione);

	}

}
