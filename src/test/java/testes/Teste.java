package testes;

import controller.ClienteController;
import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class Teste {
	public static void main(String[] args) {
		testesCliente();
	}

	public static void testesCliente() {

		ClienteController clienteController = new ClienteController();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.consultarPorId(1);
		String message = clienteController.inserirClienteController("Gustavo", "Rodrigues", "12220985942", endereco);
		System.out.println(message);

	}

}
