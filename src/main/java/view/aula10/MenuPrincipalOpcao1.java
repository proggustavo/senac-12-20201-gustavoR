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

import view.aula10.paineis.PainelTelefone;

public class MenuPrincipalOpcao1 extends JFrame {

	private JDesktopPane desktopPane;
	private TelaInternaCadastroCliente telaCadastroCliente;
	private TelaInternaCadastrotelefone telaInternaCadastrotelefone;
	private TelaInternaListarTelefones telaInternaListarTelefones;
	private TelaInternaExcluirTelefone telaInternaExcluirTelefone;
	private TelaInternaAutores telaInternaAutores;
	private TelaListarClientes telaListarClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalOpcao1 frame = new MenuPrincipalOpcao1();
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
	public MenuPrincipalOpcao1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuClientes = new JMenu("Clientes");
		menuClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaCadastroCliente == null) {
					telaCadastroCliente = new TelaInternaCadastroCliente();
				}
				 if(!telaCadastroCliente.isVisible()) {
					desktopPane.add(telaCadastroCliente);
					telaCadastroCliente.show();
				}
			}
		});
		menuClientes.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-gestão-de-cliente.png")));
		menuBar.add(menuClientes);

		JMenuItem menuitemCadastroCliente = new JMenuItem("Cadastrar");
		menuitemCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				painelTelefone = new PainelTelefone();
//				setContentPane(painelTelefone);
//				revalidate();
				if (telaCadastroCliente == null) {
					telaCadastroCliente = new TelaInternaCadastroCliente();
				}
				 if(!telaCadastroCliente.isVisible()) {
					desktopPane.add(telaCadastroCliente);
					telaCadastroCliente.show();
				}
			}
		});
		menuitemCadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		menuitemCadastroCliente.setIcon(
				new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-adicionar-usuário-masculino.png")));
		menuClientes.add(menuitemCadastroCliente);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaListarClientes == null) {
					telaListarClientes = new TelaListarClientes();
				}
				 if(!telaListarClientes.isVisible()) {
					desktopPane.add(telaListarClientes);
					telaListarClientes.show();
				}
			}
		});
		mntmListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		mntmListar.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-lista-com-marcadores.png")));
		menuClientes.add(mntmListar);
		
		JMenu mnTelefone = new JMenu("Telefones");
		mnTelefone.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-cardápio.png")));
		menuBar.add(mnTelefone);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaInternaCadastrotelefone == null) {
					telaInternaCadastrotelefone = new TelaInternaCadastrotelefone();
				}
				 if(!telaInternaCadastrotelefone.isVisible()) {
					desktopPane.add(telaInternaCadastrotelefone);
					telaInternaCadastrotelefone.show();
				}
				
			}
		});
		mntmCadastrar.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-adicionar-ao-banco-de-dados.png")));
		mnTelefone.add(mntmCadastrar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaInternaListarTelefones == null) {
					telaInternaListarTelefones = new TelaInternaListarTelefones();
				}
				 if(!telaInternaListarTelefones.isVisible()) {
					desktopPane.add(telaInternaListarTelefones);
					telaInternaListarTelefones.show();
				}
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-documento-regular.png")));
		mnTelefone.add(mntmNewMenuItem);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaInternaExcluirTelefone == null) {
					telaInternaExcluirTelefone = new TelaInternaExcluirTelefone();
				}
				 if(!telaInternaExcluirTelefone.isVisible()) {
					desktopPane.add(telaInternaExcluirTelefone);
					telaInternaExcluirTelefone.show();
				}
			}
		});
		mntmExcluir.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-à-esquerda-dentro-de-um-círculo.png")));
		mnTelefone.add(mntmExcluir);
		
		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-cartão-de-crédito-sem-contato.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-confiança.png")));
		mnNewMenu.add(mntmManual);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-suporte-on-line-filled.png")));
		mnNewMenu.add(mntmAjuda);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaInternaAutores == null) {
					telaInternaAutores = new TelaInternaAutores();
				}
				 if(!telaInternaAutores.isVisible()) {
					desktopPane.add(telaInternaAutores);
					telaInternaAutores.show();
				}
				
			}
		});
		mntmAutores.setIcon(new ImageIcon(MenuPrincipalOpcao1.class.getResource("/icons/icons8-сharlie-сhaplin.png")));
		mnNewMenu.add(mntmAutores);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(5, 5, 1000, 800);
		getContentPane().add(desktopPane);
	}
}
