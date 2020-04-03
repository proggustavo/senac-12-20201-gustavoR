package controller;

import java.util.ArrayList;

import model.bo.TelefoneBO;
import model.dao.TelefoneDAO;
import model.vo.Telefone;
import utils.Utils;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();
	private TelefoneDAO dao = new TelefoneDAO();

	/**
	 * Salva um novo telefone, validando os valores informados
	 * 
	 * @param novoTelefone o telefone a ser salvo;
	 * @return uma mensagem informando uma das opções a seguir:
	 * 
	 *         (1) há campos para ajustar
	 * 
	 *         (2) salvo com sucesso
	 * 
	 *         (3) erro ao salvar
	 */
	public String salvar(Telefone novoTelefone) {
		String mensagemValidacao = validarCampos(novoTelefone);
		
		if (mensagemValidacao.isEmpty()) {
			
			mensagemValidacao = bo.salvar(novoTelefone);
		}
		return mensagemValidacao;
	}
	
	public ArrayList<Telefone> consultarTodos(){
		return dao.consultarTodos();
	}

	private String validarCampos(Telefone novoTelefone) {
		String message = "";
		
		novoTelefone.setNumero(Utils.formatOnlyNumbers(novoTelefone.getNumero()));
		novoTelefone.setCodigoPais(Utils.formatOnlyNumbers(novoTelefone.getCodigoPais()));
		novoTelefone.setDdd(Utils.formatOnlyNumbers(novoTelefone.getDdd()));

		if (novoTelefone.getNumero().length() < 9) {
			message = "Número do telefone inválido\nMinímo 9 e máximo 14 dígitos";
		}else {
			if(novoTelefone.getCodigoPais().length() != 2) {
				message += "Código do país inválido";
			}
			if (novoTelefone.getDdd().length() != 2) {
				message += "DDD inválido \n";
			}
		}

		return message;
	}

	private String validarCampoNumerico(String valorDoCampo, String nomeDoCampo, int tamanhoMinimo, int tamanhoMaximo) {
		// TODO desenvolver

		return "";
	}
	
	

}