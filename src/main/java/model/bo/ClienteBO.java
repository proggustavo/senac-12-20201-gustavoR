package model.bo;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteBO {

	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public String salvar(Cliente cliente1) {
		String msg = "";
		cliente1 = clienteDAO.salvar(cliente1);	
		if(cliente1.getId() > 0 ) {
			msg = "Cliente cadastrado com sucesso";
		}else {
			msg = "Cliente não cadastrado";
		}
		return msg;
	}

}
