<%@ page import="solicite.Chamado" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		
		<g:set var="entityName" value="${message(code: 'chamado.label', default: 'Chamados')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<g:javascript library="jquery" />
		
		<script type="text/javascript">
			
			function carregarLista() {
				<g:remoteFunction controller="chamado" action="lista" update="divLista"/>
				jQuery("#divForm").html("");
			}
			

			function cancelar() {
				jQuery("#divForm").html("");
			}

		</script>
	</head>
	<body>
		<a href="#list-status" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/areaRestrita/admin')}"><g:message code="default.home.label"/></a></li>
				<li><g:remoteLink class="create" controller="chamado" action="adicionar" update="divForm">Novo Chamado</g:remoteLink></li>
			</ul>
		</div>

		
		<div id="divLista">
			<g:render template="lista" model="[chamados: chamados]"></g:render>
		</div>
		
		<div id="divForm"></div>
	</body>
</html>
