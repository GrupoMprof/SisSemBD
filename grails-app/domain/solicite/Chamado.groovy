package solicite

import seguranca.Usuario


class Chamado {
	
	String titulo;
	String problema;
	String solucao;
	Date dataAbertura;
	Date dataFechamento;
	Usuario usuario; //cria uma fk na tabela Usuario
	Status status; //cria uma fk na tabela status
	//Conta conta; //cria uma fk na tabela conta
	//Atendente atendente; //cria uma fk na tabela atendente
	

    static constraints = {
		usuario nullable:true
		status nullable:true
		dataFechamento nullable:true
		solucao nullable:true, blank:false
    }
	
	/*
	static constraints = {
		nome nullable:false, blank:false
		email email:true, unique:true
		senha: size:6..10
		cpf validator: { valor, objeto ->
			(valor.size() == 11)
		}
	}
	*/
}
