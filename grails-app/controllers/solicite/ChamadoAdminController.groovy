package solicite

import grails.plugin.springsecurity.annotation.Secured;


class ChamadoAdminController {

	
    def index() {
		def lista = Chamado.list();
		render(view:"/chamadoAdmin/index", model:[chamados: lista]);
	}
	
	def alterar(){
		Chamado chamado = Chamado.get(params.id)
		render(template:"/chamadoAdmin/form", model: [chamado: chamado])
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
		
		chamado.dataFechamento = new Date();
		chamado.solucao = params.solucao;
		
		Status s = new Status();
		s.id = 2;
		chamado.status = s;

				
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
		
		render(template:"/chamadoAdmin/lista", model: [chamados: lista]);
	}
	
	def excluir(){
		Chamado chamado = Chamado.get(params.id)
		chamado.delete(flush:true)
		
		def lista = Chamado.list()
		render(template:"/chamadoAdmin/lista", model:[chamados: lista])
	}

}
