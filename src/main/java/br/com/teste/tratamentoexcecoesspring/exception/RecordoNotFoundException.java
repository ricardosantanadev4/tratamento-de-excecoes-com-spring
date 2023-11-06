package br.com.teste.tratamentoexcecoesspring.exception;

// RuntimeException e a superclasse daquelas excecoes que podem ser lancadas durante a operacao normal da Java Virtual Machine
public class RecordoNotFoundException extends RuntimeException {

//	necessario adcionar quando extends RuntimeException
	private static final long serialVersionUID = 1L;

	public RecordoNotFoundException(Long id) {
		/*
		 * super() chama o construtor da classe RuntimeException, esse construtor
		 * constroi uma nova exceção de tempo de execucao com a mensagem detalhada
		 * especificada, a mensagem detalhada e salva para recuperação posterior pelo
		 * metodo getMessage(), para o obter mais informacoes selecione a classe
		 * RuntimeException e pressione f3 onde voce vai ser direcionado a classe
		 */
		super("Registro não encontrado com id: " + id);
	}

}