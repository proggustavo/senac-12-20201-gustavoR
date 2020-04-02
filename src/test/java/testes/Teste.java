package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ClienteController;
import controller.EnderecoController;
import controller.TelefoneController;
import model.dao.EnderecoDAO;
import model.vo.Endereco;
import model.vo.Telefone;

public class Teste {
	public static void main(String[] args) {
		cadastrarTelefone();
	}

	public static void testesCliente() {

		ClienteController clienteController = new ClienteController();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.consultarPorId(1);
		String message = clienteController.inserirClienteController("Gustavo", "Rodrigues", "12220985942", endereco);
		System.out.println(message);

	}
	
	public static void consultarEnderecos() {
		EnderecoController enderecoController = new EnderecoController();
		ArrayList<Endereco> enderecos = enderecoController.consultarTodosEnderecos();
		
		for (Endereco endereco : enderecos) {
			System.out.println(endereco.toString());
		}
		
	}
	
	
	public static void cadastrarTelefone() {
		TelefoneController telefoneController = new TelefoneController();
		Telefone telefone = new Telefone();
		telefone.setNumero("12341234");
		telefone.setCodigoPais("55");
		telefone.setDdd("48");
		telefone.setMovel(false);
		
		String message = telefoneController.salvar(telefone);
		
		JOptionPane.showMessageDialog(null, message, "Cadastro de Telefone", JOptionPane.INFORMATION_MESSAGE);
	}
}
