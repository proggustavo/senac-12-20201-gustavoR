package view.aula10.paineis;

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

public class MenuPrincipalOpcaoPanel extends JFrame {

	private JDesktopPane desktopPane;
	private PainelTelefone painelTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalOpcaoPanel frame = new MenuPrincipalOpcaoPanel();
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
	public MenuPrincipalOpcaoPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuClientes = new JMenu("Clientes");
		menuClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		menuClientes.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-gestão-de-cliente.png")));
		menuBar.add(menuClientes);

		JMenuItem menuitemCadastroCliente = new JMenuItem("Cadastrar");
		menuitemCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuitemCadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		menuitemCadastroCliente.setIcon(
				new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-adicionar-usuário-masculino.png")));
		menuClientes.add(menuitemCadastroCliente);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		mntmListar.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-lista-com-marcadores.png")));
		menuClientes.add(mntmListar);
		
		JMenu mnTelefone = new JMenu("Telefones");
		mnTelefone.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-cardápio.png")));
		menuBar.add(mnTelefone);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//instanciar o painel 
				painelTelefone = new PainelTelefone();
				
				//atualizar o content pane com o painel escolhido
				
				setContentPane(painelTelefone);
				revalidate();
				
			}
		});
		mntmCadastrar.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-adicionar-ao-banco-de-dados.png")));
		mnTelefone.add(mntmCadastrar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-documento-regular.png")));
		mnTelefone.add(mntmNewMenuItem);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmExcluir.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-à-esquerda-dentro-de-um-círculo.png")));
		mnTelefone.add(mntmExcluir);
		
		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-cartão-de-crédito-sem-contato.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-confiança.png")));
		mnNewMenu.add(mntmManual);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-suporte-on-line-filled.png")));
		mnNewMenu.add(mntmAjuda);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmAutores.setIcon(new ImageIcon(MenuPrincipalOpcaoPanel.class.getResource("/icons/icons8-сharlie-сhaplin.png")));
		mnNewMenu.add(mntmAutores);

//	
//		desktopPane = new JDesktopPane();
//		desktopPane.setBounds(5, 5, 1000, 800);
//		getContentPane().add(desktopPane);
	}
}
