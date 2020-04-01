package controller;

import model.bo.EnderecoBO;

public class EnderecoController {
	
	private static final int TAMANHO_MINIMO_CAMPO_RUA = 3;
	private static final int TAMANHO_MAXIMO_CAMPO_RUA = 255;
	
	private EnderecoBO enderecoBo = new EnderecoBO();
	
	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = enderecoBo.excluir(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}

	public String salvar(String rua, String bairro, String numero, String cep, String cidade, String estado) {
		String mensagem = "";
		
		mensagem += validarCampoDeTexto("Rua", rua, TAMANHO_MINIMO_CAMPO_RUA, TAMANHO_MAXIMO_CAMPO_RUA);
		
		
		if(rua != null && rua.isEmpty() && rua.length() < 3 || rua.length() > 255) {
			mensagem = "Rua deve possuir pelo menos 3 caracteres";
		}
		if(estado !=null && !estado.isEmpty() && rua.length() > 3 ) {
			mensagem = "Selecione um estado";
		}
		
		if(mensagem.isEmpty()) {
			
		}
		return mensagem;
		
	}
	
	private String validarCampoDeTexto(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo) {
		String mensagem = "";
		if(valor != null && valor.isEmpty() && valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
			mensagem = nomeDoCampo + " deve possuir pelo menos + " + tamanhoMinimo + " caracteres e no máximo " + tamanhoMaximo + " caracteres\n";
		}
		return mensagem;
	}

}
