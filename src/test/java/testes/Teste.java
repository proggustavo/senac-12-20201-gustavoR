package testes;

import controller.ClienteController;
import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class Teste {
	public static void main(String[] args) {
	
	
	ClienteController clienteController = new ClienteController();
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	Endereco endereco = enderecoDAO.consultarPorId(1);
	String message = clienteController.inserirClienteController("Gustavo", "Rodrigues", "12341243", endereco);
	System.out.println(message);
	
	}
	
}
