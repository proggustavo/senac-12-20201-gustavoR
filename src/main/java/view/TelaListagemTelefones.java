package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.TelefoneController;
import model.vo.Telefone;

public class TelaListagemTelefones {

	private JFrame frame;
	private JTable tblTelefones;
	private ArrayList<Telefone> telefones;
	private String[] nomesColunas = { "Número", "Código País", "DDD", "Movel", "Ativo", "Cliente" };

	private void limparTabelaTelefones() {
		tblTelefones.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaTelefones() {
		limparTabelaTelefones();
		DefaultTableModel model = (DefaultTableModel) tblTelefones.getModel();
		
		for (Telefone telefone : telefones) {

			Object[] novaLinhaDaTabela = new Object[6];
			novaLinhaDaTabela[0] = telefone.getNumero();
			novaLinhaDaTabela[1] = telefone.getCodigoPais();
			novaLinhaDaTabela[2] = telefone.getDdd();
			novaLinhaDaTabela[3] = telefone.isMovel();
			novaLinhaDaTabela[4] = telefone.isAtivo();
			novaLinhaDaTabela[5] = telefone.getDono();

			model.addRow(novaLinhaDaTabela);
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemTelefones window = new TelaListagemTelefones();
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
	public TelaListagemTelefones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listagem de Telefones");
		frame.setBounds(100, 100, 767, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController telefoneController = new TelefoneController();
				telefones = telefoneController.consultarTodos();

				atualizarTabelaTelefones();
				
			}
		});
		btnBuscar.setBounds(441, 12, 117, 25);
		frame.getContentPane().add(btnBuscar);
	
		tblTelefones = new JTable();
		tblTelefones.setBounds(25, 70, 650, 400);
		frame.getContentPane().add(tblTelefones);


	}
}
