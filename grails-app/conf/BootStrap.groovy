import seguranca.*;

class BootStrap {

    def init = { servletContext ->
	
		Permissao admin = Permissao.findByAuthority("ROLE_ADMIN")
		if (admin == null){
			admin = new Permissao(authority: "ROLE_ADMIN").save(flush:true)
		}
		
		
		Permissao aluno = Permissao.findByAuthority("ROLE_ALUNO")
		if (aluno == null){
			aluno = new Permissao(authority: "ROLE_ALUNO").save(flush:true)
		}
		
		
		Usuario administrador = Usuario.findByUsername("admin")
		if (administrador == null){
			administrador = new Usuario(username: "admin", password: "123",
				enabled: true, accountExpired: false, accountLocked: false,
				passwordExpired: false).save(flush:true)
		}
		
		
		Usuario aluno1 = Usuario.findByUsername("aluno")
		if (aluno1 == null){
			aluno1 = new Usuario(username: "aluno", password: "123",
				enabled: true, accountExpired: false, accountLocked: false,
				passwordExpired: false).save(flush:true)
		}
		
		
		if (UsuarioPermissao.findByUsuarioAndPermissao(administrador,admin) == null)
		{
			new UsuarioPermissao(usuario: administrador, permissao: admin).save(flush:true)
		}
		
		
		if (UsuarioPermissao.findByUsuarioAndPermissao(aluno1,aluno) == null)
		{
			new UsuarioPermissao(usuario: aluno1, permissao: aluno).save(flush:true)
		}
		
		
		
    }
    def destroy = {
    }
}
