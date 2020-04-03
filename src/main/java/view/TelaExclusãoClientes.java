package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ClienteController;
import model.vo.Cliente;

public class TelaExclusãoClientes {

	private JFrame frame;
	private JComboBox cmbClientes;
	private ClienteController clienteController = new ClienteController();
	private ArrayList<Cliente> clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusãoClientes window = new TelaExclusãoClientes();
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
	public TelaExclusãoClientes() {
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
		frame.setTitle("Tela para Exclusão de Clientes");

		JLabel lblSelecioneONome = new JLabel("Selecione o cliente:");
		lblSelecioneONome.setBounds(145, 12, 247, 23);
		frame.getContentPane().add(lblSelecioneONome);

		clientes = clienteController.listarTodosOsClientes();
		cmbClientes =  new JComboBox();
		cmbClientes.addItem("- - - - - - - - Selecione um Cliente - - - - - - - -");
		for (Cliente cliente : clientes) {
			cmbClientes.addItem(cliente);
		}
		cmbClientes.setBounds(41, 47, 367, 24);
		frame.getContentPane().add(cmbClientes);
		cmbClientes.setSelectedItem(0);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO adicionar uma confirmação se deseja excluir o cliente
				ClienteController clienteController = new ClienteController();
				Cliente cliente = new Cliente();
				try {
					cliente = (Cliente) cmbClientes.getSelectedItem();
					String message = clienteController.excluirCliente(cliente);
					if(message == "O cliente foi excluído!") {
						cmbClientes.removeItem(cmbClientes.getSelectedItem());
					}
					JOptionPane.showMessageDialog(null, message, "Excluir Cliente", JOptionPane.INFORMATION_MESSAGE);
					clientes = clienteController.listarTodosOsClientes();
				} catch (ClassCastException e) {
					JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado!", "Atenção!",
							JOptionPane.WARNING_MESSAGE);
				}				
			}
		});

		btnExcluir.setBounds(156, 110, 117, 25);
		frame.getContentPane().add(btnExcluir);

	}
}
