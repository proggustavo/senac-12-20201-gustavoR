package controller;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.dao.TelefoneDAO;
import model.vo.Cliente;
import model.vo.Endereco;
import model.vo.Telefone;
import utils.Utils;

public class ClienteController {

	private ClienteDAO clienteDao = new ClienteDAO();

	public ArrayList<Cliente> listarTodosOsClientes() {
		return clienteDao.consultarTodos();
	}

	public String excluirCliente(Cliente cliente) {
		String message = "";
		TelefoneDAO telefoneDao = new TelefoneDAO();
		ArrayList<Telefone> telefonesDoCliente = telefoneDao.consultarTodosPorIdCliente(cliente.getId());

		if (!telefonesDoCliente.isEmpty()) {
			message = "O Cliente não pode ser excluído pois tem telefone cadastrado.";
		} else {
			message = (clienteDao.excluirCliente(cliente.getId())) ? "O cliente foi excluído!"
					: "O cliente não foi excluído!";
		}

		return message;

	}

	public String inserirClienteController(String nome, String sobrenome, String cpfCnpj, Endereco endereco) {
		String message = "";

		if (!Utils.isValidString(nome)) {
			message += "Nome inválido ";
		} else if (!Utils.validarCpfCnpj(cpfCnpj)) {
			message += "CPF ou CNPJ inválido ";
		} else if (!Utils.isValidString(sobrenome)) {
			message += "Sobrenome inválido ";
		}

		if (message.isEmpty()) {
			if (clienteDao.cpfJaUtilizado(cpfCnpj)) {
				message += "CPF ou CNPJ já utilizado!";
			}else {
					Cliente novoCliente = new Cliente(nome, sobrenome, cpfCnpj, null, endereco);
					Cliente clienteCadastrado = clienteDao.salvar(novoCliente);
					// TODO como fazer uma ternária nesse caso
				if (clienteCadastrado.getId() > 0 ) {
					message += "Cliente cadastrado com sucesso!";
				} else {
					message += "Cliente não cadastrado!";
				}
			}
		}

		return message;

	}

}