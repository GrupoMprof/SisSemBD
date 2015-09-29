package solicite



import grails.test.mixin.*
import spock.lang.*

@TestFor(StatusController)
@Mock(Status)
class StatusControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["descricao"] = 'Aberto'
    }

    void "Testando a acao index"() {

        when:"A acao index eh executada..."
            controller.index()

        then:"o model estah correto"
            !model.statusInstanceList
            model.statusInstanceCount == 0
    }
	

    void "Testando a acao create"() {
        when:"a acao create é executada"
            controller.create()

        then:"o model eh criado corretamente"
            model.statusInstance!= null
    }

	
    void "Testa se a acao save presiste corretamente uma instancia"() {

        when:"A acao save eh executada com uma instancia invalida"
            def status = new Status()
            status.validate()
            controller.save(status)

        then:"A acao save eh executada com uma instancia VALIDA"
            model.statusInstance!= null
            view == 'create'

        when:"A acao save eh executada com uma instancia VALIDA"
            response.reset()
            populateValidParams(params)
            status = new Status(params)

            controller.save(status)

        then:"o redirecionamento eh feito para a acao show"
            response.redirectedUrl == '/status/show/1'
            controller.flash.message != null
            Status.count() == 1
    }
    

    void "Testa a acao show retorna o model correto"() {
        when:"A acao show é executada com dominio null"
            controller.show(null)

        then:"o erro 404 eh retornado"
            response.status == 404

        when:"um dominio eh passado para a acao show"
            populateValidParams(params)
            def status = new Status(params)
            controller.show(status)

        then:"Um modelo eh preenchido contendo a instancia de dominio"
            model.statusInstance == status
    }

    void "Testa se a acao edit retorna um model correto"() {
        when:"A acao edit é executada com dominio null"
            controller.edit(null)

        then:"o erro 404 eh retornado"
            response.status == 404

        when:"um dominio eh passado para a acao edit"
            populateValidParams(params)
            def status = new Status(params)
            controller.edit(status)

        then:"Um modelo eh preenchido contendo a instancia de dominio"
            model.statusInstance == status
    }

	
    void "Testa se a acao update atualiza uma instancia de dominio valido"() {
        when:"Update eh chamado para uma instancia de dominio que nao existe"
            controller.update(null)

        then:"o erro 404 eh retornado"
            response.redirectedUrl == '/status/index'
            flash.message != null


        when:"Uma instancia de dominio invalida eh passada para a acao update"
            response.reset()
            def status = new Status()
            status.validate()
            controller.update(status)

        then:"a acao edit eh processada novamente com uma instancia invalida"
            view == 'edit'
            model.statusInstance == status

        when:"Um exemplo de dominio valido eh passado para a acao update"
            response.reset()
            populateValidParams(params)
            status = new Status(params).save(flush: true)
            controller.update(status)

        then:"o redirecionamento eh feito para a acao show"
            response.redirectedUrl == "/status/show/$status.id"
            flash.message != null
    }
    

    void "Testa se acao delete exclui uma instancia se ela existir"() {
        when:"A acao delete é executada uma uma instancia nula"
            controller.delete(null)

        then:"o erro 404 eh retornado"
            response.redirectedUrl == '/status/index'
            flash.message != null

        when:"uma instancia de dominio eh criada"
            response.reset()
            populateValidParams(params)
            def status = new Status(params).save(flush: true)

        then:"Ela existe"
            Status.count() == 1

        when:"A instancia eh passada para acao delete"
            controller.delete(status)

        then:"A instancia é deletada"
            Status.count() == 0
            response.redirectedUrl == '/status/index'
            flash.message != null
    }
	
}
