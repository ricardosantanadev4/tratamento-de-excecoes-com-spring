package br.com.teste.tratamentoexcecoesspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.teste.tratamentoexcecoesspring.exception.RecordoNotFoundException;

@RestControllerAdvice
public class AplicationControllerAdvace {

	/*
	 * necessario adicionar essa anotacao para informar qual e o tipo de exececao
	 * que esse metodo vai le dar
	 */
	@ExceptionHandler(RecordoNotFoundException.class)
	/*
	 * como essa excecao vai ser lancada quando o id nao for encontrado no banco de
	 * dados e necessario retornar o status 404, caso contrario vai retornar 200 ok
	 * que nao condiz com a causa da excecao
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(RecordoNotFoundException recordFoundException) {
		/*
		 * getMessage() usado para recuperar a mensgem especificada na excecao, que foi criada na
		 * Classe que extends RuntimeException
		 */
		return recordFoundException.getMessage();
	}
}
