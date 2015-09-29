package solicite

class AreaRestritaController {

	
	def springSecurityService;
	
    def index() { }
	
	def logar(){
		render(view: "/areaRestrita/logar")
		println "logar";
	}
	
	def admin(){
		println "admin";
		String usuario = springSecurityService.principal.username;
		//String usuario = springSecurityService.principal.authorities;
		
		render(view: "/areaRestrita/admin", model: [usuario: usuario])
	}
	
	def logout(){
		render(view: "/areaRestrita/logar")
	}
	
	def erro(){
		render(view: "/areaRestrita/erro")
		println "erro";
	}
}
