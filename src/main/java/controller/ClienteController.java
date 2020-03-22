package controller;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteController {

	private ClienteDAO clienteDao = new ClienteDAO();

	public ArrayList<Cliente> listarTodosOsClientes() {
		return clienteDao.consultarTodos();
	}

	public boolean excluirCliente(Cliente cliente) {
		return clienteDao.excluirCliente(cliente.getId()); 
		
	}
}