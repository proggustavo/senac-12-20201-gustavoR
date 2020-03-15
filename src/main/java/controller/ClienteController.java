package controller;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteController {

	private ClienteDAO dao = new ClienteDAO();

	public ArrayList<Cliente> listarTodosOsClientes() {
		return dao.consultarTodos();
	}
}