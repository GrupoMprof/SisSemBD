package solicite

class Status {
	
	String descricao;
	
	static hasMany = [chamados:Chamado]; 	// cria uma associação um para muitos com Chamado

    static constraints = {
		descricao(nullable:false, blank:false, maxSize:60, unique:true)
    }
}
