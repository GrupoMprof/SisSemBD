<div id="divMensagem"></div>
<g:formRemote name="frmChamado" url="[controller: 'chamado', action: 'salvar']" update="divMensagem" onSuccess = "carregarLista()">

<div class="fieldcontain ${hasErrors(bean: chamado, field: 'Título', 'error')} ">
	<label for="titulo">
		<g:message code="chamado.titulo.label" default="Título" />
		
	</label>
	<g:textField name="titulo" value="${chamado?.titulo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: chamado, field: 'Problema', 'error')} ">
	<label for="problema">
		<g:message code="chamado.problema.label" default="Problema" />
		
	</label>
	<g:textField name="problema" value="${chamado?.problema}"/>
</div>

<fieldset class="buttons">
		<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Salvar')}" />
</fieldset>
<input type="hidden" name="id" value="${chamado?.id}"/>
	

	
</g:formRemote>