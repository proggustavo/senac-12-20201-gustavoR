package view.aula10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuPrincipal extends JFrame {

	private JDesktopPane desktopPane;
	private TelaInternaCadastroCliente telaCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuClientes = new JMenu("Clientes");
		menuClientes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-gestão-de-cliente.png")));
		menuBar.add(menuClientes);

		JMenuItem menuitemCadastroCliente = new JMenuItem("Cadastrar");
		menuitemCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaCadastro == null) {
					telaCadastro = new TelaInternaCadastroCliente();
				}
				else if(!telaCadastro.isVisible()) {
					desktopPane.add(telaCadastro);
					telaCadastro.show();
				}
			}
		});
		menuitemCadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		menuitemCadastroCliente.setIcon(
				new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-adicionar-usuário-masculino.png")));
		menuClientes.add(menuitemCadastroCliente);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		mntmListar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-lista-com-marcadores.png")));
		menuClientes.add(mntmListar);
		
		JMenuItem mntmRelatrios = new JMenuItem("Relatórios");
		mntmRelatrios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-documento-regular.png")));
		menuClientes.add(mntmRelatrios);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-comprar.png")));
		menuBar.add(mnProdutos);
		
		JMenu mnFuncionrios = new JMenu("Funcionários");
		mnFuncionrios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-treinamento.png")));
		menuBar.add(mnFuncionrios);
		
		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-cartão-de-crédito-sem-contato.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-confiança.png")));
		mnNewMenu.add(mntmManual);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-suporte-on-line-filled.png")));
		mnNewMenu.add(mntmAjuda);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-сharlie-сhaplin.png")));
		mnNewMenu.add(mntmAutores);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(5, 5, 1000, 800);
		getContentPane().add(desktopPane);
	}
}
