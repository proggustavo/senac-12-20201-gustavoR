package view.aula10;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class TelaInternaAutores extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaAutores frame = new TelaInternaAutores();
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
	public TelaInternaAutores() {
		setBounds(100, 100, 450, 300);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblDesenvolvidoPorGustavo = new JLabel("Desenvolvido por Gustavo Rodrigues");
		lblDesenvolvidoPorGustavo.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblDesenvolvidoPorGustavo.setBounds(83, 129, 276, 15);
		getContentPane().add(lblDesenvolvidoPorGustavo);

	}

}
