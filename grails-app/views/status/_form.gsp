<%@ page import="solicite.Status" %>


<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="status.descricao.label" default="Descricao" />
	</label>
	<g:textField name="descricao" value="${statusInstance?.descricao}"/>
</div>

