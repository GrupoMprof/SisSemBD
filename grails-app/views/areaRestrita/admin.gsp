<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Solicite - Home</title>
	</head>
	<body>
	<div id="controller-list" role="navigation">
	
		<sec:ifLoggedIn>
		<h1>Olá, ${usuario}!</h1>
		<br>
		<g:if test="${usuario.equals("admin") }">
			<li class="controller">
			<a href="/Solicite/chamadoAdmin/index">Atendimento de Chamado</a>
			</li>
			<br>
			<li class="controller">
			<a href="/Solicite/status/index">Cadastro de Status</a>
			</li>
		</g:if>
		
		<g:else>
			<li class="controller">
			<a href="/Solicite/chamado/index">Abertura de Chamado</a>
			</li>
		</g:else>
		<br>
		<li class="controller">
		<a href="/Solicite/j_spring_security_logout">Sair</a>
		</li>
		</sec:ifLoggedIn>
		
	</div>
	</body>
</html>
