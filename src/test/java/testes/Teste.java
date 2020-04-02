package testes;

import java.util.ArrayList;

import controller.ClienteController;
import controller.EnderecoController;
import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class Teste {
	public static void main(String[] args) {
		consultarEnderecos();
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
}
