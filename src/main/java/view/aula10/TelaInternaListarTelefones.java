package view.aula10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import controller.TelefoneController;
import model.vo.Cliente;
import model.vo.Telefone;

public class TelaInternaListarTelefones extends JInternalFrame {
	
	private JFrame frame;
	private JTable tblTelefones;
	private ArrayList<Telefone> telefones;
	private String[] nomesColunas = { "Número", "Código País", "DDD", "Movel", "Ativo", "Cliente" };
	private JComboBox cmbClientes;
	private ArrayList<Cliente> clientes;
	
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
			novaLinhaDaTabela[5] = telefone.getDono().getNome();

			model.addRow(novaLinhaDaTabela);
		}

	}
	
	private void atualizarTabelaTelefonesPorCliente() {
		limparTabelaTelefones();
		DefaultTableModel model = (DefaultTableModel) tblTelefones.getModel();
		
		for (Telefone telefone : telefones) {

			Object[] novaLinhaDaTabela = new Object[6];
			novaLinhaDaTabela[0] = telefone.getNumero();
			novaLinhaDaTabela[1] = telefone.getCodigoPais();
			novaLinhaDaTabela[2] = telefone.getDdd();
			novaLinhaDaTabela[3] = telefone.isMovel();
			novaLinhaDaTabela[4] = telefone.isAtivo();
			novaLinhaDaTabela[5] = telefone.getDono().getNome();

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
					TelaInternaListarTelefones frame = new TelaInternaListarTelefones();
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
	public TelaInternaListarTelefones() {
		setClosable(true);
		setBounds(100, 100, 766, 452);
		getContentPane().setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar Todos");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController telefoneController = new TelefoneController();
				telefones = telefoneController.consultarTodos();
				atualizarTabelaTelefones();
				
			}
		});
		btnBuscar.setBounds(570, 24, 139, 25);
		getContentPane().add(btnBuscar);
	
		tblTelefones = new JTable();
		tblTelefones.setBounds(59, 61, 650, 359);
		getContentPane().add(tblTelefones);
		
		JButton btnBuscarPorCliente = new JButton("Buscar Por Cliente");
		btnBuscarPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					TelefoneController telefoneController = new TelefoneController();
					telefones = telefoneController.consultarTodosPorIdCliente((Cliente) cmbClientes.getSelectedItem());
					atualizarTabelaTelefonesPorCliente();
				} catch (ClassCastException e) {
					JOptionPane.showMessageDialog(null, "Nenhum cliente Selecionado", "Cadastro de Cliente",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

			
		});
		btnBuscarPorCliente.setBounds(349, 24, 189, 25);
		getContentPane().add(btnBuscarPorCliente);
		
		ClienteController clienteController = new ClienteController();
		clientes =  clienteController.listarTodosOsClientes();
		cmbClientes = new JComboBox();
		cmbClientes.addItem("- - - - Selecione um Cliente - - - - -");
		for (Cliente cliente : clientes) {
			cmbClientes.addItem(cliente);
		}
		cmbClientes.setBounds(59, 24, 261, 24);
		getContentPane().add(cmbClientes);
		

	}

}
