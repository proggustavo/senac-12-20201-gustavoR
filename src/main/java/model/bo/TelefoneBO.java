package model.bo;

import model.dao.TelefoneDAO;
import model.vo.Telefone;

public class TelefoneBO {
	
	private TelefoneDAO dao = new TelefoneDAO();

	public String salvar(Telefone novoTelefone) {
		String mensagem = "";

		novoTelefone = dao.salvar(novoTelefone);

		if (novoTelefone.getId() > 0) {
			mensagem = "Telefone cadastrado com sucesso";
		} else {
			mensagem = "Erro ao cadastrar telefone";
		}
		return mensagem;
	}

}
