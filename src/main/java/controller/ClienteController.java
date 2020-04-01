package controller;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.dao.TelefoneDAO;
import model.vo.Cliente;
import model.vo.Telefone;

public class ClienteController {

	private ClienteDAO clienteDao = new ClienteDAO();
	

	public ArrayList<Cliente> listarTodosOsClientes() {
		return clienteDao.consultarTodos();
	}
	public String excluirCliente(Cliente cliente) {
		String message = "";
		TelefoneDAO telefoneDao = new TelefoneDAO();
		ArrayList<Telefone> telefonesDoCliente = telefoneDao.consultarTodosPorIdCliente(cliente.getId());
		
		if(!telefonesDoCliente.isEmpty()) {	
			message = "O Cliente não pode ser excluído pois tem telefone cadastrado.";
		}else {
			message = (clienteDao.excluirCliente(cliente.getId())) ? "O cliente foi excluído!" : "O cliente não foi excluído!";
		}

		return message;
		
	}
}