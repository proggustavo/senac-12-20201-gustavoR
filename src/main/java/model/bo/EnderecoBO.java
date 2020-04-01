package model.bo;

import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class EnderecoBO {
	
	private EnderecoDAO EnderecoDao = new EnderecoDAO();

	public String excluir(int idSelecionado) {
		String mensagem = "";
		if (EnderecoDao.temEnderecoCadastradoComId(idSelecionado)) {
			if (EnderecoDao.excluir(idSelecionado)) {
				mensagem = "Excluído com sucesso";
			} else {
				mensagem = "Erro ao excluir";
			}
		} else {
			mensagem = "Id informado (" + idSelecionado + ") não existe no banco.";
		}

		return mensagem;
	}

	public String salvar(Endereco novoEndereco) {
		String mensagem = "";

		novoEndereco = EnderecoDao.salvar(novoEndereco);

		if (novoEndereco.getId() > 0) {
			mensagem = "Salvo com sucesso";
		} else {
			mensagem = "Erro ao salvar";
		}

		return mensagem;
	}

}
