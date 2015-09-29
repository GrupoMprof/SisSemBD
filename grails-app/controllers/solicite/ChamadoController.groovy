package solicite

import java.util.Date;

class ChamadoController {

    def index()
	{
		def lista = Chamado.list();
		render(view:"/chamado/index", model:[chamados: lista]);
	}
	
	/*
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Status.list(params), model:[statusInstanceCount: Status.count()]
	}
	*/
	
	def adicionar() {
		Chamado novoChamado = new Chamado();
		novoChamado.titulo = "";
		novoChamado.problema = "";
		
		render(template:"/chamado/form", model:[chamado: novoChamado]);
	}
	
	def salvar() {
		
		Chamado chamado = null;
		if (params.id) {
			chamado = Chamado.get(params.id)
		} else {
			chamado = new Chamado();
			chamado.status = new Status();
			//chamado.conta = new Conta();
		}
		
		chamado.titulo = params.titulo;
		chamado.problema = params.problema;
		chamado.dataAbertura = new Date();
		chamado.status.id = 1;
		//chamado.usuario.username = "aluno";
		
		//chamado.conta.id = 1;
				
		chamado.validate()
		if (!chamado.hasErrors()) {
			chamado.save(flush:true);
			render("Salvou com sucesso");
		}
		else {
			render("Ops...deu erro." + chamado.errors);
		}
		
	}
	
	def lista(){
		def lista = Chamado.list();
		
		render(template:"/chamado/lista", model: [chamados: lista]);
	}
	
	/*
	def alterar() {
		Produto produto = Produto.get(params.id);
		render(template:"/produto/form", model: [produto: produto]);
		
	}
	*/
	/*
	def excluir() {
		Produto produto = Produto.get(params.id);
		produto.delete(flush:true);
		
		def lista = Produto.list();
		render(template:"/produto/lista", model: [produtos: lista]);
	}
	*/

}
