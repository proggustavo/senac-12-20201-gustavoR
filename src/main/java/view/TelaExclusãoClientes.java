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
	private JTextField textCpf;
	private JComboBox cmbClientes;
	private ClienteController clienteController = new ClienteController();

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
		
		JLabel lblSelecioneONome = new JLabel("Selecione o nome ou insira o CPF");
		lblSelecioneONome.setBounds(59, 12, 247, 23);
		frame.getContentPane().add(lblSelecioneONome);
		
		
		ArrayList<Cliente> clientes = clienteController.listarTodosOsClientes();
		cmbClientes =  new JComboBox(clientes.toArray());
		cmbClientes.setBounds(59, 47, 234, 24);
		frame.getContentPane().add(cmbClientes);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(59, 82, 70, 15);
		frame.getContentPane().add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(59, 109, 234, 21);
		frame.getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO adicionar uma confirmação se deseja excluir o cliente
				
				Cliente cliente = (Cliente)cmbClientes.getSelectedItem();
				String message = "";
				if(clienteController.excluirCliente(cliente)) {
					message = "Cliente excluído com sucesso!";
					JOptionPane.showMessageDialog(null, message);
				}else {
					message = "Cliente não foi excluído!";
					JOptionPane.showMessageDialog(null, message);
				}
						
						
				
			}
		});
		btnExcluir.setBounds(113, 168, 117, 25);
		frame.getContentPane().add(btnExcluir);
	}
}
