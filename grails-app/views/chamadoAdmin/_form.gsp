<div id="divMensagem"></div>
<g:formRemote name="frmChamado" url="[controller: 'chamadoAdmin', action: 'salvar']" update="divMensagem" onSuccess = "carregarLista()">

<div class="fieldcontain ${hasErrors(bean: chamado, field: 'Título', 'error')} ">
	<label for="titulo">
		<g:message code="chamado.titulo.label" default="Título" />:
		
	</label>
	<g:fieldValue bean="${chamado}" field="titulo"/><br/>
</div>

<div class="fieldcontain ${hasErrors(bean: chamado, field: 'Problema', 'error')} ">
	<label for="problema">
		<g:message code="chamado.problema.label" default="Problema" />:
		
		
	</label>
	<g:fieldValue bean="${chamado}" field="problema"/><br/>
</div>

<div class="fieldcontain ${hasErrors(bean: chamado, field: 'Solução', 'error')} ">
	<label for="solucao">
		<g:message code="chamado.solucao.label" default="Solução" />:
		
		
	</label>
	<g:textField name="solucao" value="${chamado?.solucao}" />
</div>


<fieldset class="buttons">
	<input type="submit" name="btnSalvar" value="Salvar" />
</fieldset>

<fieldset class="buttons">
	<input type="submit" name="btnCancelar" value="Cancelar" onclick="cancelar()" />
</fieldset>

<input type="hidden" name="id" value="${chamado?.id}"/>
	

	
</g:formRemote>